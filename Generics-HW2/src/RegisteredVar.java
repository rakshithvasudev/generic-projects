import java.sql.Timestamp;
import java.util.List;

public class RegisteredVar<T> {

    private T genericData;
    private int timesChanged;
    private List<Timestamp> latestTimeStamp;
    private List<RegisteredVar> lastThreeValues;
    private int maxValue;
    private int minValue;

    public RegisteredVar(){
        genericData = null;
    }

    public void setValue(T newValue){
        if(genericData==null)

            genericData = newValue;

    }


}
