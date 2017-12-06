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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates2D<?> that = (Coordinates2D<?>) o;

        if (x != null ? !x.equals(that.x) : that.x != null) return false;
        return y != null ? y.equals(that.y) : that.y == null;
    }

    @Override
    public int hashCode() {
        int result = x != null ? x.hashCode() : 0;
        result = 31 * result + (y != null ? y.hashCode() : 0);
        return result;
    }
}
