import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable {

    // used for choosing thread picking
    private static int randomThreadNumber = randomNumberGenerator(1, 4);
    private static int xLoc = 300, yLoc = 200, radius = 10;
    private static volatile Circle c = new Circle(xLoc, yLoc, radius);

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main).start();
        new Thread(main).start();
        new Thread(main).start();
        new Thread(main).start();
    }

    @Override
    public void run() {

        while (true) {

//            if ((c.getX() <= 0) || (c.getX() >= xLoc)) {
//
//                System.out.println("Inside X  break");
//                break;
//
//            } else if ((c.getY() <= 0) || (c.getY() >= 0)) {
//
//                System.out.println("Inside Y break");
//                break;
//            }

            // allows threads to enter sequentially
            synchronized (Main.class) {
                // left moving thread
                if (randomThreadNumber == 1) {
                    int delay = randomNumberGenerator(250,375);
                    c.moveCircleBy(-5, 0);
                    introduceDelay(randomNumberGenerator(250,375));
                    System.out.println("left thread, delay: " +delay +": ("+c.getX()+", "+c.getY()+")");
                }

                // right moving thread
                else if (randomThreadNumber == 2) {
                    int delay = randomNumberGenerator(250,375);
                    c.moveCircleBy(5, 0);
                    introduceDelay(delay);
                    System.out.println("right thread + delay: " +delay +": ("+c.getX()+", "+c.getY()+")");
                }

                //top moving thread (0 is at the top)
                else if (randomThreadNumber == 3) {
                    int delay = randomNumberGenerator(250,375);
                    c.moveCircleBy(0, -5);
                    introduceDelay(randomNumberGenerator(250,375));
                    System.out.println("top thread + delay: " +delay+": ("+c.getX()+", "+c.getY()+")");
                }

                //bottom moving thread (max y is at the bottom)
                else {
                    int delay = randomNumberGenerator(250,375);
                    c.moveCircleBy(0, 5);
                    introduceDelay(randomNumberGenerator(250,375));
                    System.out.println("bottom thread + delay: " +delay +": ("+c.getX()+", "+c.getY()+")");
                }

                randomThreadNumber = randomNumberGenerator(1, 4);


            }
        }
    }

    private void introduceDelay(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    /**
     * Generates a random number in a specified range.
     *
     * @param min least value to be generated.
     * @param max max value to be generated.
     * @return random number in specified range.
     */
    private static int randomNumberGenerator(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
