import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * This class demonstrates Generics in Java with updates.
 * @param <T> Anydata type that user potentially wants to consider
 *           passing.
 */
public class RegisteredVar<T> {

    private T genericData;
    private int timesChanged;
    private List<Timestamp> latestTimeStamp;
    private List<T> lastThreeValues;
    private double maxValue;
    private double minValue;

    public RegisteredVar(){
        genericData = null;
        timesChanged=0;
        latestTimeStamp = new ArrayList<>();
        lastThreeValues = new ArrayList<>();
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
            setupTimestamp();
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

}
