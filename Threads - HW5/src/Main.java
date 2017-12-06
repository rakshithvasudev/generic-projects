public class Main{
    public static void main(String[] args) {
       Circle c = new Circle(45,45,10);
       for (int k =0;k<500;k++)
       {
           try {
               c.moveCircle(k,123);
               Thread.sleep(100);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
    }
}
