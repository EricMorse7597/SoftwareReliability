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
        /**
         * This test shows the method returns the right element when there's only one,
         * it should pass
         */
        List<String> list1 = new ArrayList<>();
        String result1;
        list1.add("dog");
        result1 = "dog";

        /**
         * This test shows the method returns the smallest string, it should pass.
         */
        List<String> list2 = new ArrayList<>();
        String result2;
        list2.add("cat");
        list2.add("dog");
        result2 = "cat";

        /**
         * This test shows the method returns the right int when there's only one, it
         * should pass.
         */
        List<Integer> list3 = new ArrayList<>();
        Integer result3;
        list3.add(2);
        result3 = 2;

        /**
         * This test shows the method returns the right int when theres more then one,
         * it should pass.
         */
        List<Integer> list4 = new ArrayList<>();
        Integer result4;
        list4.add(1);
        list4.add(2);
        result4 = 1;

        /**
         * This test shows the method returns the right int when it's not the first, it
         * should pass.
         * element
         */
        List<Integer> list5 = new ArrayList<>();
        Integer result5;
        list5.add(200);
        list5.add(20);
        list5.add(50);
        list5.add(3);
        list5.add(2);
        result5 = 2;

        /**
         * This test shows the method returns the right string even through, it should
         * pass.
         * capitilization
         */
        List<String> list6 = new ArrayList<>();
        String result6;
        list6.add("cat");
        list6.add("Dog");
        result6 = "Dog";

        /**
         * This test shows the method returns the right int even though it's negative,
         * it should pass.
         */
        List<Integer> list7 = new ArrayList<>();
        Integer result7;
        list7.add(1);
        list7.add(-1);
        list7.add(5);
        result7 = -1;

        /**
         * This test shows the method returns the right string even though the 2nd could
         * have been interpreted as a number, it should pass.
         */
        List<String> list8 = new ArrayList<>();
        String result8;
        list8.add("cat");
        list8.add("four");
        result8 = "cat";

        /**
         * This test shows the method doesn't always return true (the result is
         * incorrect), it should fail
         */
        List<String> list9 = new ArrayList<>();
        Integer result9;
        list9.add("two");
        list9.add("four");
        result9 = 2;

        /**
         * This test shows the method returns NPEs, it should show an error
         */
        List<Integer> list10 = new ArrayList<>();
        Integer result10;
        list10.add(null);
        list10.add(2);
        result10 = 2;

        return Arrays.asList(
                new Object[][] {
                        { list1, result1 },
                        { list2, result2 },
                        { list3, result3 },
                        { list4, result4 },
                        { list5, result5 },
                        { list6, result6 },
                        { list7, result7 },
                        { list8, result8 },
                        { list9, result9 },
                        { list10, result10 }
                });
    }

    @Test
    public void minTest() {
        System.out.println("Min Tests");
        Object obj = Min.min(list);

        assertTrue("Failed test", obj.equals(result));
    }

}
