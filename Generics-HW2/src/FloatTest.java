public class FloatTest {
    public static void main(String[] args) {
        RegisteredVar<Float> registeredVar = new RegisteredVar<>();
        registeredVar.setValue((float) 34.33);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue((float)37.23242);
        registeredVar.setValue((float)132334.232);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue((float)3314.232);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        registeredVar.setValue((float)342.2335);

        System.out.println("\nLatest generic value: "+registeredVar.getValue());
        System.out.println("Number of times changed: "+registeredVar.getTimesChanged() +"\n");
        System.out.println("Last 3 Modified timestamps in Reverse Order(Latest to Old) : ");
        registeredVar.getlastThreeTimeStamps();
        System.out.println("\n");
        System.out.println("Last 3 Modified values in Reverse Order(Latest to Old) : ");
        registeredVar.getlastThreeValuesStamps();
    }
}
