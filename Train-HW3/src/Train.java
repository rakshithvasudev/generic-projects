import java.util.List;

/**
 * Created by Rakshith on oct 9 2017, for CSC527 - HW3.
 * This class encompasses the entire train.
 */

public class Train {
    private List<Car> trainCars;

    public Train(List<Car> trainCars) {
        this.trainCars = trainCars;
    }

    /**
     * Gets the total weight of all the cars in the train.
     * @return total weight of all cars.
     */
    public float evalTotalWeight(){
        int totalWeight = 0;
        for (Car e :trainCars) {
            totalWeight+=e.getWeight();
        }
        return totalWeight;
    }

    /**
     * Gets the description for the entire train as required by specs.
     * @return description for train.
     */
    @Override
    public String toString() {

        // get the description for train
        String trainDescription = "Train "+ "Train1" +" # cars: "+trainCars.size() +" TotalWt: "+evalTotalWeight()+ " kg.";
        StringBuilder carDescription = new StringBuilder("\n");

        // get the description for all cars
        for (Car e:trainCars) {
            carDescription.append(e.toString());
            carDescription.append("\n");
         }

     return trainDescription + carDescription.toString();
    }
}
