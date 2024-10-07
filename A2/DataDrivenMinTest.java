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

        List<Integer> list4 = new ArrayList<>();
        Integer result4;
        list4.add(1);
        list4.add(2);
        result4 = 2;

        List<Object> list5 = new ArrayList<>();
        Object result5;
        list5.add(1);
        list5.add(2);
        result5 = 1;

        return Arrays.asList(
                new Object[][] {
                        { list1, result1 }, // Tests for correct output
                        { list2, result2 }, // Tests for correct output
                        { list3, result3 }, // Tests for correct output
                        { list4, result4 }, // Tests for incorrect output (error)
                        { list5, result5 }
                });
    }

    @Test
    public void minTest() {
        System.out.println("Min Tests");
        Object obj = Min.min(list);

        assertTrue("Failed test", obj.equals(result));
    }

}
