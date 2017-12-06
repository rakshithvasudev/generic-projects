import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable{

    // used for choosing thread picking
    private static int randomThreadNumber = randomNumberGenerator(1,4);
    private static int xloc = 300, yloc =200, radius = 10;
    private static Circle c = new Circle(xloc,yloc,radius);

    public static void main(String[] args) {
        Main main = new Main();
        new Thread(main).start();
        new Thread(main).start();
        new Thread(main).start();
        new Thread(main).start();
    }

    @Override
    public void run() {

        // left moving thread
        if(randomThreadNumber == 1){
            c.moveCircleBy(-5,0);
        }

        // right moving thread
        else if (randomThreadNumber == 2){
           c.moveCircleBy(5,0);
        }

        //top moving thread (0 is at the top)
        else if(randomThreadNumber == 3){
          c.moveCircleBy(0,-5);
        }

        //bottom moving thread (max y is at the bottom)
        else{
          c.moveCircleBy(0,5);
        }

      randomThreadNumber = randomNumberGenerator(1,4);
    }


    /**
     * Generates a random number in a specified range.
     * @param min least value to be generated.
     * @param max max value to be generated.
     * @return random number in specified range.
     */
    private static int randomNumberGenerator(int min,int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
