/**
 * Generic class that tracks the 2D co-ordinates.
 * @param <T>
 */
public class Coordinates2D<T> {
    private T x;
    private T y;


    public Coordinates2D(T x, T y){
        this.x = x;
        this.y = y;
    }


    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
