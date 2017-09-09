import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Rakshith on 9/7/2017.
 */
public class Die {
    private int faceValue;

    /**
     * This function simulates the roll event that can return any random
     * value between 1 and 6, much like an actual dice.
     *
     * @return a random value between 1 and 6 using ThreadLocalRandom.
     */
    public int roll() {
        faceValue = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        return faceValue;
    }

    @Override
    public String toString() {
        return ("[" + faceValue + ":]");
    }

    /**
     * Helps to support unique value identification.
     * This function overrides the default hashcode from java
     * to prevent in a violation of the general contract for
     * Object.hashCode(), which will prevent the class from functioning properly
     * in conjunction with all hash-based collections, including HashMap, HashSet, and Hashtable.
     *
     * @return the hashed value of the Die.
     */
    @Override
    public int hashCode() {
        int a = 883;
        a = faceValue * a * 1033;
        a += faceValue * a;
        return a;
    }

    /**
     * @param obj Object for checking for equality in input.
     * @return True only if the object is equal in value and not via reference.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj != null && this.getClass() == obj.getClass()) {
            Die objEqual = (Die) obj;
            return objEqual.faceValue == this.faceValue;
        }
        return false;
    }
}
