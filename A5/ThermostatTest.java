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
    public void PCTest1() { // testing for pred 1 and 2 true - a b c d: true
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
        assertTrue(thermo.getRunTime() == 70 - 63);
    }

    @Test
    public void PCTest2() { // testing for pred 1 false - a b c: true / d: false
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

        assertFalse(thermo.turnHeaterOn(settings));
    }

    @Test
    public void PCTest3() { // testing for pred 2 false - a c d: true -- b: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(63);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(false);

        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);
        thermo.setThresholdDiff(0);

        thermo.turnHeaterOn(settings);
        assertFalse(thermo.getRunTime() == Math.abs(70 - 63));
    }

    @Test
    public void CACCTest1() { // a is determinate - a, c, d: true -- b: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setThresholdDiff(0);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(63);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(false);
        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);

        assertTrue(thermo.turnHeaterOn(settings));
    }

    @Test
    public void CACCTest2() { // a and c is determinate, - b, d: true -- a, c: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 69);
        thermo.setThresholdDiff(0);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(90);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(true);
        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);

        assertFalse(thermo.turnHeaterOn(settings));
    }

    @Test
    public void CACCTest3() { // B and C is determinate - b, c, d: true -- a: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 65);
        thermo.setThresholdDiff(0);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(67);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(true);
        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);

        assertTrue(thermo.turnHeaterOn(settings));
    }

    @Test
    public void CACCTest4() { // B is determinate - c, d: true -- a, b: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 65);
        thermo.setThresholdDiff(0);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(67);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(false);
        thermo.setOverTemp(70);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(12);

        assertFalse(thermo.turnHeaterOn(settings));
    }

    @Test
    public void CACCTest5() { // D is determinate - a, b, c, d: true
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 65);
        thermo.setThresholdDiff(0);
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

    @Test
    public void CACCTest6() { // D is determinate - a, b, c: true -- d: false
        Thermostat thermo = new Thermostat();
        ProgrammedSettings settings = new ProgrammedSettings();

        settings.setSetting(Period.MORNING, DayType.WEEKDAY, 65);
        thermo.setThresholdDiff(0);
        thermo.setPeriod(Period.MORNING);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setCurrentTemp(63);
        thermo.setDay(DayType.WEEKDAY);

        thermo.setOverride(true);
        thermo.setOverTemp(65);

        thermo.setMinLag(10);
        thermo.setTimeSinceLastRun(8);

        assertFalse(thermo.turnHeaterOn(settings));
    }
}
