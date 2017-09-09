import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Rakshith on 9/7/2017.
 */
public class Die {
    private int faceValue;
    public int roll(){
        faceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return faceValue;
    }

    @Override
    public String toString() {
        return ("["+faceValue+":]");
    }
}
