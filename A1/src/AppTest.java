import static org.junit.Assert.assertEquals;

import java.util.Vector;

import org.junit.Test;

public class AppTest {

    App ourApp = new App();
    
    @Test
    public void test1() {
        Vector<Object> answer = new Vector<Object>();
        Vector<Object> Vector1 = new Vector<Object>();
        Vector<Object> Vector2 = new Vector<Object>();

        answer.add(1);
        answer.add(2);
        answer.add(3);
        answer.add(4);
        answer.add(5);
        answer.add(6);

        Vector1.add(1);
        Vector1.add(2);
        Vector1.add(3);
        Vector2.add(4);
        Vector2.add(5);
        Vector2.add(6);
        assertEquals(answer, App.union(answer, answer));
    }
    
    @Test
    public void test2() {
        Vector<Object> answer = new Vector<Object>();
        Vector<Object> Vector1 = new Vector<Object>();
        Vector<Object> Vector2 = new Vector<Object>();

        answer.add(1);
        answer.add(2);
        answer.add(3);
        answer.add(4);
        answer.add(5);

        Vector1.add(1);
        Vector1.add(2);
        Vector1.add(3);
        Vector2.add(3);
        Vector2.add(4);
        Vector2.add(5);
        assertEquals(answer, App.union(answer, answer));
    }
}
