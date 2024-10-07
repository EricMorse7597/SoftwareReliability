import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class) // This tells JUnit to use the Parameterized test runner, which allows the test
public class DataDrivenMinTest {
    private List<String> list;
    private Object result;

    public DataDrivenMinTest(List<String> list, String result) {
        this.list = list;
        this.result = result;
    }

    @Parameters
    public static Collection<Object[]> minValues() {
        List<String> list1 = new ArrayList<>();
        String result1;

        list1.add("cat");
        result1 = "cat";

        List<String> list2 = new ArrayList<>();
        String result2;

        list2.add("cat");
        list2.add("dog");
        result2 = "cat";

        return Arrays.asList(
                new Object[][] {
                        { list1, result1 },
                        { list2, result2 }
                });
    }

    @Test
    public void minTest() {
        System.out.println("Min Tests");
        Object obj = Min.min(list);

        assertTrue("Failed test", obj.equals(result));
    }

}
