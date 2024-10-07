import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class) // This tells JUnit to use the Parameterized test runner, which allows the test
public class DataDrivenMinTest<T extends Comparable<T>> {
    private List<T> list;
    private T result;

    public DataDrivenMinTest(List<T> list, T result) {
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

        List<Integer> list3 = new ArrayList<>();
        Integer result3;
        list3.add(1);
        list3.add(2);
        result3 = 1;

        return Arrays.asList(
                new Object[][] {
                        { list1, result1 },
                        { list2, result2 },
                        { list3, result3 }
                });
    }

    @Test
    public void minTest() {
        System.out.println("Min Tests");
        Object obj = Min.min(list);

        assertTrue("Failed test", obj.equals(result));
    }

}
