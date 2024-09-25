import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith (Parameterized.class) // This tells JUnit to use the Parameterized test runner, which allows the test
// to be run multiple times with different input parameters.
public class DataDrivenUnionTest {

    private Vector<Object> vector1, vector2, result;

    public DataDrivenUnionTest(Vector<Object> vector1, Vector<Object> vector2, Vector<Object> result) {
        this.vector1 = vector1;
        this.vector2 = vector2;
        this.result = result;
    }

    
  @Parameters  // This annotation is used to define the input values that the
  // test will be executed with
   
  
  public static Collection<Object[]> unionValues()  {
    Vector<Object> result1 = new Vector<Object>();
    Vector<Object> Vector11 = new Vector<Object>();
    Vector<Object> Vector21 = new Vector<Object>();

    result1.add(1);
    result1.add(2);
    result1.add(3);
    result1.add(4);
    result1.add(5);
    result1.add(6);

    Vector11.add(1);
    Vector11.add(2);
    Vector11.add(3);

    Vector21.add(4);
    Vector21.add(5);
    Vector21.add(6);

    Vector<Object> result2 = new Vector<Object>();
    Vector<Object> Vector12 = new Vector<Object>();
    Vector<Object> Vector22 = new Vector<Object>();

    result2.add(1);
    result2.add(3);
    result2.add(4);
    result2.add(5);

    Vector12.add(1);
    Vector12.add(null);
    Vector12.add(3);

    Vector22.add(3);
    Vector22.add(4);
    Vector22.add(5);

    Vector<Object> result3 = new Vector<Object>();
    Vector<Object> Vector13 = new Vector<Object>();
    Vector<Object> Vector23 = new Vector<Object>();

    result3.add(1);
    result3.add(2);
    result3.add(3);

    Vector13.add(1);
    Vector13.add(2);
    Vector13.add(3);

    Vector<Object> result4 = new Vector<Object>();
    Vector<Object> Vector14 = new Vector<Object>();
    Vector<Object> Vector24 = new Vector<Object>();

    Vector<Object> result5 = new Vector<Object>();
    Vector<Object> Vector15 = new Vector<Object>();
    Vector<Object> Vector25 = new Vector<Object>();

    result5.add(1);
    result5.add("Bob");
    result5.add('a');
    result5.add(2);
    result5.add("Mary");

    Vector15.add(1);
    Vector15.add("Bob");
    Vector15.add('a');

    Vector25.add(2);
    Vector25.add('a');
    Vector25.add("Mary");

    Vector<Object> result6 = new Vector<Object>();
    Vector<Object> Vector26 = new Vector<Object>();
    
    Vector26.add(3);
    Vector26.add(4);
    Vector26.add(5);

	return Arrays.asList (
        new Object [][] { 
            {Vector11, Vector21, result1}, 
            {Vector12, Vector22, result2}, 
            {Vector13, Vector23, result3}, 
            {Vector14, Vector24, result4}, 
            {Vector15, Vector25, result5}, 
            {null, Vector26, result6} 
         }); 
  }

    @Test
    public void unionTest() {
        System.out.println("Union test");
        System.out.println("vector 1: " + vector1);
        System.out.println("vector 2: " + vector2);
        System.out.println("vector union result: " + result);

        assertTrue("Failed union test", App.union(vector1, vector2).equals(result));
    }

    @Test
    public void unionOldTest() {
        System.out.println("union old test");
        System.out.println("vector 1: " + vector1);
        System.out.println("vector 2: " + vector2);
        System.out.println("vector union result: " + result);

        assertTrue("Failed unionOld test", App.unionOld(vector1, vector2).equals(result));
    }
}