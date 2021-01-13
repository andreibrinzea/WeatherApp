package ro.mta.se.lab.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import ro.mta.se.lab.CustomExceptions.InvalidCountryException;
import static org.junit.jupiter.api.Assertions.*;


public class CountryNamesTest {

    private CountryNames countryNamesInstance = null;
    private String validCountryCode1 = null;
    private String validCountryCode2 = null;
    private String invalidCountryCode = null;
    private String validCountryName1 = null;
    private String validCountryName2 = null;

    @Before
    public void setUp() {
        countryNamesInstance = CountryNames.getInstance();
        validCountryCode1 = "FR";
        validCountryCode2 = "VE";
        invalidCountryCode = "XQ";
        validCountryName1 = "France";
        validCountryName2 = "Venezuela";
    }

    @Test
    public void checkInstance() {
        assertNotNull(countryNamesInstance);
        assertSame(CountryNames.getInstance(), countryNamesInstance);
    }

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

    @Test
    public void invalidCountryCode() throws InvalidCountryException {
        invalidCountryException.expect(InvalidCountryException.class);
        invalidCountryException.expectMessage("Invalid code country for country code " +
                invalidCountryCode + "!");
        String countryName = countryNamesInstance.getCountryNamesbyCode(invalidCountryCode);
    }

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