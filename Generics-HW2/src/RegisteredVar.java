import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates Generics in Java with updates.
 * @param <T> Any datatype that user potentially wants to consider
 *           passing.
 */
public class RegisteredVar<T extends Comparable<T>> {

    private T genericData;
    private int timesChanged;
    private List<Timestamp> latestTimeStamp;
    private List<T> lastValues;

    public RegisteredVar(){
        genericData = null;
        timesChanged=0;
        latestTimeStamp = new ArrayList<>();
        lastValues = new ArrayList<>();
    }


    public void setValue(T newValue){
        updateCounters();
        genericData = newValue;
        setupTimestamp();
        setupValues(newValue);
    }

    private void setupValues(T newValue) {
    if (timesChanged>0){
        lastValues.add(newValue);
        }
    }

    private void updateCounters() {
        if(genericData==null)
            timesChanged=0;
        else
            timesChanged+=1;
    }

    /**
     * Adds the time stamp.
     */
    private void setupTimestamp() {
        latestTimeStamp.add(new Timestamp(System.currentTimeMillis()));
    }

    /**
     *
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

    public T getMin(){
       T min = lastValues.get(0);
        for (T e:lastValues) {
            if(e.compareTo(min) < 0){
                min = e;
            }
        }
        return min;
    }

    public T getValue(){
        return genericData;
    }



    public void getlastThreeTimeStamps(){
        int size = latestTimeStamp.size();
        try {
            for (int i = size - 1; i > size - 4; i--)
                System.out.println(latestTimeStamp.get(i));
        }catch (Exception e){
            System.out.println("3 values haven't been changed yet!");
        }
    }


    public void getlastThreeValuesStamps(){
        int size = lastValues.size();
        try {
            for (int i = size - 1; i > size - 4; i--)
                System.out.println(lastValues.get(i));
        }catch (Exception e){
            System.out.println("3 values haven't been changed yet!");
        }
    }



    public int getTimesChanged(){
        return timesChanged;
    }

}
