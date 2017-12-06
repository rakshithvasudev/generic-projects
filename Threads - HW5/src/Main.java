import java.util.concurrent.ThreadLocalRandom;

public class Main implements Runnable{




    public static void main(String[] args) {
//       Circle c = new Circle(45,45,10);
//       for (int k =0;k<500;k++)
//       {
//           try {
//               c.moveCircle(k,123);
//               Thread.sleep(100);
//           } catch (InterruptedException e) {
//               e.printStackTrace();
//           }
//       }

       
    }

    @Override
    public void run() {

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
