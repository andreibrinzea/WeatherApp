package ro.mta.se.lab.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * Test suite class that contains test classes
 * {@link CityTest}, {@link CountryNamesTest} and
 * {@link ModelSuiteClasses}
 *
 * @author Andrei Brinzea
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CityTest.class,
        CountryTest.class,
        CountryNamesTest.class})

public class ModelSuiteClasses {
}
