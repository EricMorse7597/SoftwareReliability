import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import java.util.*;

@RunWith(Parameterized.class) // This tells JUnit to use the Parameterized test runner, which allows the test
public class ThermostatTest<T extends Comparable<T>> {
    private List<T> list;
    private T result;

    public ThermostatTest(List<T> list, T result) {
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

        return Arrays.asList(
                new Object[][] {
                        { list1, result1 }
                });
    }

    @Test
    public void PCTest1() {
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(63);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(true);

        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);

        assertTrue(thermo.turnHeaterOn(settings));
    }

    public void PCTest2() {
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(63);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(true);

        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(8);

        assertTrue(thermo.turnHeaterOn(settings));
    }

}
