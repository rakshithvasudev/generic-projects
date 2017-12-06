import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable{

    // used for choosing thread picking
    private static int randomThreadNumber = 0;
    private Circle c = new Circle(45,45,10);


    public static void main(String[] args) {






    }

    @Override
    public void run() {

        // left moving thread
        if(randomThreadNumber == 1){
            c.moveCircleTo();
        }

        // right moving thread
        else if (randomThreadNumber == 2){

        }

        //top moving thread
        else if(randomThreadNumber == 3){

        }

        //bottom moving thread
        else{

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
