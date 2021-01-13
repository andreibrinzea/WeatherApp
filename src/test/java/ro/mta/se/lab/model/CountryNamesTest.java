package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ro.mta.se.lab.CustomExceptions.InvalidCountryException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link CountryNames} class
 * and contains parameterized tests
 *
 * @author Andrei Brinzea
 */

public class CountryNamesTest {
    /**
     * Members of <b>CountryNamesTest</b>
     * <i>countryNamesInstance: </i> instance of {@link CountryNames}
     * <i>validCountryCode1: </i> code used for an valid test
     * <i>validCountryCode2: </i> code used for an valid test
     * <i>invalidCountryCode: </i> code used for an invalid test
     * <i>validCountryName1: </i> code used for an valid test
     * <i>validCountryName2: </i> code used for an valid test
     */

    private CountryNames countryNamesInstance = null;
    private String validCountryCode1 = null;
    private String validCountryCode2 = null;
    private String invalidCountryCode = null;
    private String validCountryName1 = null;
    private String validCountryName2 = null;

    /**
     * Function used to set specific date before test
     */
    @Before
    public void setUp() {
        countryNamesInstance = CountryNames.getInstance();
        validCountryCode1 = "FR";
        validCountryCode2 = "VE";
        invalidCountryCode = "XQ";
        validCountryName1 = "France";
        validCountryName2 = "Venezuela";
    }

    /**
     * Test function test used to check instance of {@link CountryNames}
     * class
     */
    @Test
    public void checkInstance() {
        assertNotNull(countryNamesInstance);
        assertSame(CountryNames.getInstance(), countryNamesInstance);
    }

    /**
     * Test function used to check valid country codes
     */
    @Test
    public void checkValidCountryCodes() {
        assertSame(CountryNames.getInstance(), countryNamesInstance);
        try {
            assertEquals(validCountryName1, countryNamesInstance.getCountryNamesbyCode(validCountryCode1));
            assertEquals(validCountryName2, countryNamesInstance.getCountryNamesbyCode(validCountryCode2));
        } catch (InvalidCountryException e) {
            e.printStackTrace();
        }
    }

    @Rule
    public ExpectedException invalidCountryException = ExpectedException.none();

    /**
     * Test function used to check a specific exception for an
     * invalid country code
     */
    @Test
    public void invalidCountryCode() throws InvalidCountryException {
        invalidCountryException.expect(InvalidCountryException.class);
        invalidCountryException.expectMessage("Invalid code country for country code " +
                invalidCountryCode + "!");
        String countryName = countryNamesInstance.getCountryNamesbyCode(invalidCountryCode);
    }

    /**
     * Function used to clear data after test
     */
    @After
    public void clearData() {
        countryNamesInstance = null;
        validCountryCode1 = null;
        validCountryCode2 = null;
        invalidCountryCode = null;
        validCountryName1 = null;
        validCountryName2 = null;
    }

}