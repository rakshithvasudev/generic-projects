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

    /**
     * This function overrides the default 
     * @return the hashed value of the Die.
     */
    @Override
    public int hashCode() {
        int a = 883;
        a = faceValue*a*1033;
        a += faceValue*a;
        return a;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj!=null&& this.getClass()==obj.getClass()){
            Die objEqual = (Die)obj;
            return objEqual.faceValue == this.faceValue;
        }
    return false;
    }
}
