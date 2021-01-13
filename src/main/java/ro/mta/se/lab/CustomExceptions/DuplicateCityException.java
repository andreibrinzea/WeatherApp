package ro.mta.se.lab.CustomExceptions;

/**
 * Specific exception class for duplicate city exceptions
 *
 * @author Andrei Brinzea
 */
public class DuplicateCityException extends Exception {
    public DuplicateCityException(String errMessage) {
        super(errMessage);
    }
}
