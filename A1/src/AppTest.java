import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Test;

public class AppTest {

    App ourApp = new App();
    
    @Test
    public void baseCaseTest() {
        Vector<Object> result = new Vector<Object>();
        Vector<Object> Vector1 = new Vector<Object>();
        Vector<Object> Vector2 = new Vector<Object>();

        result.add(1);
        result.add(2);
        result.add(3);
        result.add(4);
        result.add(5);
        result.add(6);

        Vector1.add(1);
        Vector1.add(2);
        Vector1.add(3);

        Vector2.add(4);
        Vector2.add(5);
        Vector2.add(6);
        
        System.out.println("in appTest -- baseCaseTest()");
        assertTrue("union is incorrect in base case", App.union(Vector1, Vector2).equals(result));
    }
    
    @Test
    public void duplicateAndNullObjectTest() {
        Vector<Object> result = new Vector<Object>();
        Vector<Object> Vector1 = new Vector<Object>();
        Vector<Object> Vector2 = new Vector<Object>();

        result.add(1);
        result.add(3);
        result.add(4);
        result.add(5);

        Vector1.add(1);
        Vector1.add(null);
        Vector1.add(3);

        Vector2.add(3);
        Vector2.add(4);
        Vector2.add(5);
        
        System.out.println("in appTest -- duplicateAndNullObjectTest()");
        assertTrue("union is incorrect with duplicate and/or null", App.union(Vector1, Vector2).equals(result));
    }
}
