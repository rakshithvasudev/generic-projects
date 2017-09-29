import org.junit.*;
/**
 * Created by Rakshith on 9/28/2017.
 */
public class DieTest {
    public static final int LOWERVALUE = 1;
    public static final int HIGHERVALUE = 6;
    public boolean isInRange(int value){
        return (value>LOWERVALUE && value<=HIGHERVALUE);
    }

    @Test
    public void DieConstructor(){
        Die d;
        d = new Die();
        Assert.assertFalse(d.roll()<-1);
    }

    @Test
    public void RollTest(){
        Die d1 = new Die();
        int faceValues = d1.roll();
        Assert.assertTrue("Generated values were not matched!",isInRange(faceValues));
    }


}
