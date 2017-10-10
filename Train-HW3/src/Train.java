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


    @Override
    public String toString() {
    String trainDescription = "Train "+ "Train: #1" + " TotalWt: "+evalTotalWeight()+ " kg.";
    return trainDescription;
    }
}
