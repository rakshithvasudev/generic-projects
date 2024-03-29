import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakshith on 20-sept-2017 for CSC527-HW2. This class demonstrates
 * Generics in Java with updates.
 *
 * @pre The classes that are to be passed must implement
 * comparable.
 *
 * @param <T> Any datatype that user potentially wants to consider
 *           passing usually numerical.
 */
public class RegisteredVar<T extends Comparable<T>> {

    // generic data container
    private T genericData;

    // tracks number of times generic data was changed.
    private int timesChanged;

    // list that tracks all the updated timestamps.
    private List<Timestamp> latestTimeStamp;

    // list that tracks all the values of the generic data.
    private List<T> lastValues;

    /**
     * Constructor initializes the generic data to null, number of times changed
     * timestamps and lastValues to startup.
     */
    public RegisteredVar(){
        genericData = null;
        timesChanged=0;
        latestTimeStamp = new ArrayList<>();
        lastValues = new ArrayList<>();
    }

    /**
     * Sets a newValue to the generic data variable. Accepts type T.
     * @param newValue type T param to set the value to the generic data.
     */
    public void setValue(T newValue){

        // if the newValue is not equal to already generic data
        // value then update the values. Otherwise do nothing.
        if(newValue != genericData){

            // updates the number of times changed field.
            updateCounters();

            // set the new Value to generic data.
            genericData = newValue;

            // update the timestamps,
            // add to the list.
            setupTimestamp();

            //add to the latest values.
            setupValues(newValue);
        }



    }

    /**
     * Adds to the lastValues list.
     * @param newValue A Generic type that allows
     *                 new value to be added.
     */
    private void setupValues(T newValue) {
        lastValues.add(newValue);
    }

    /**
     * Increments the number of times the generic value was changed.
     *
     */
    private void updateCounters() {
        if(genericData==null)
            timesChanged=0;
        else
            timesChanged+=1;
    }

    /**
     * Adds the time stamp list.
     */
    private void setupTimestamp() {
        latestTimeStamp.add(new Timestamp(System.currentTimeMillis()));
    }

    /**
     * This method compares all the values in the lastValues list and
     * returns the Maximum value.
     */
    public T getMax(){
        T max=lastValues.get(0) ;
        for (T e:lastValues) {
          if(e.compareTo(max) > 0){
               max = e;
               }
            }
        return max;
    }

    /**
     * This method compares all the values in the lastValues list and
     * returns the Minimum value.
     */
    public T getMin(){
       T min = lastValues.get(0);
        for (T e:lastValues) {
            if(e.compareTo(min) < 0){
                min = e;
            }
        }
        return min;
    }

    /**
     * Get the value of generic data.
     * @return the value of generic data.
     */
    public T getValue(){
        return genericData;
    }


    /**
     * Prints the last three time stamps.
     */
    public void getLastThreeTimeStamps(){
        int size = latestTimeStamp.size();
        try {
            for (int i = size - 1; i > size - 4; i--)
                System.out.println(latestTimeStamp.get(i));
        }catch (Exception e){
            System.out.println("3 values haven't been changed yet!");
        }
    }

    /**
     * Prints the last three values of the generic data.
     */
    public void getLastThreeValuesStamps(){
        int size = lastValues.size();
        try {
            for (int i = size - 1; i > size - 4; i--)
                System.out.println(lastValues.get(i));
        }catch (Exception e){
            System.out.println("3 values haven't been changed yet!");
        }
    }


    /**
     * This function retrieves the number of times the variable
     * was changed.
     * @return number of times changed which is an integer.
     */
    public int getTimesChanged(){
        return timesChanged;
    }

}
