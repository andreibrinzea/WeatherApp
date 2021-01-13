package ro.mta.se.lab.CustomExceptions;


/**
 * Specific exception class for invalid country exceptions
 *
 * @author Andrei Brinzea
 */
public class InvalidCountryException extends Exception {
    public InvalidCountryException(String errMessage) {
        super(errMessage);
    }
}