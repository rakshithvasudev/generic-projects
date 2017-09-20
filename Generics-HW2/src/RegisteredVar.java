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
    private int maxValue;
    private int minValue;

    public RegisteredVar(){
        genericData = null;
        timesChanged=0;
        latestTimeStamp = new ArrayList<>();
        lastThreeValues = new ArrayList<>();
        maxValue=Integer.MIN_VALUE;
        minValue=Integer.MAX_VALUE;
    }


    public void setValue(T newValue){
        updateCounters();
        genericData = newValue;
    }

    private void updateCounters() {
        if(genericData==null)
            timesChanged=0;
        else
            timesChanged+=1;
    }


}
