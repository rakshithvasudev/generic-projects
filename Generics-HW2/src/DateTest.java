import java.util.Date;

/**
 * Created by Rakshith on 21st - sept- 2017, this class is used
 * to test RegisteredVar Generic class with Date objects.
 * Threads are introduced intermittently just to make sure
 * timestamps work.
 */
public class DateTest {
    public static void main(String[] args) {
        RegisteredVar<Date> registeredVar = new RegisteredVar<>();
        registeredVar.setValue(new Date(System.currentTimeMillis()));

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(new Date(System.currentTimeMillis()));
        registeredVar.setValue(new Date(System.currentTimeMillis()));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(new Date(System.currentTimeMillis()));

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(new Date(System.currentTimeMillis()));

        System.out.println("\nLatest generic value: "+registeredVar.getValue());
        System.out.println("Number of times changed: "+registeredVar.getTimesChanged() +"\n");
        System.out.println("Last 3 Modified timestamps in Reverse Order(Latest to Old) : ");
        registeredVar.getLastThreeTimeStamps();
        System.out.println("\n");
        System.out.println("Last 3 Modified values in Reverse Order(Latest to Old) : ");
        registeredVar.getLastThreeValuesStamps();
        System.out.println("Least Value: "+registeredVar.getMin());
        System.out.println("Max Value: "+registeredVar.getMax());

    }
}
