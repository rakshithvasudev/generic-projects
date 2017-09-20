public class IntegerTest {

    public static void main(String[] args) {
        RegisteredVar<Integer> registeredVar = new RegisteredVar<>();
        registeredVar.setValue(34);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(37);
        registeredVar.setValue(1334);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(334);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue(34235);

        System.out.println("Latest generic value: "+registeredVar.getValue());
        System.out.println("Number of times changed: "+registeredVar.getTimesChanged() +"\n");
        System.out.println("Last 3 Modified timestamps: ");
        registeredVar.getlastThreeTimeStamps();
        System.out.println("\n");
        System.out.println("Last 3 Modified values: ");
        registeredVar.getlastThreeValuesStamps();

    }

}
