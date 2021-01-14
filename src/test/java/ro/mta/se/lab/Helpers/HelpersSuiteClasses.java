package ro.mta.se.lab.Helpers;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Test suite class that contains test classes
 * {@link ParserTest} and {@link WeatherClientTest}
 *
 * @author Andrei Brinzea
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ParserTest.class,
        WeatherClientTest.class})

public class HelpersSuiteClasses {
}
