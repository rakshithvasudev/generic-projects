import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates Generics in Java with updates.
 * @param <T> Any datatype that user potentially wants to consider
 *           passing.
 */
public class RegisteredVar<T> {

    private T genericData;
    private int timesChanged;
    private List<Timestamp> latestTimeStamp;
    private List<T> lastValues;
    private double maxValue;
    private double minValue;

    public RegisteredVar(){
        genericData = null;
        timesChanged=0;
        latestTimeStamp = new ArrayList<>();
        lastValues = new ArrayList<>();
        maxValue=Double.MIN_VALUE;
        minValue=Double.MAX_VALUE;
    }


    public void setValue(T newValue){
        updateCounters();
        genericData = newValue;
        setupTimestamp();
        updateMax();
        updateMin();
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
    private void updateMax(){
        if((double)genericData>maxValue){
            maxValue =(double)genericData;
        }
    }

    private void updateMin(){
        if((double)genericData<minValue){
            minValue =(double)genericData;
        }
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
