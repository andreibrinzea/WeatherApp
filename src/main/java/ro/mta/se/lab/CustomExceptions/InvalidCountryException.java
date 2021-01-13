package ro.mta.se.lab.CustomExceptions;

public class InvalidCountryException extends Exception {
    public InvalidCountryException(String errMessage) {
        super(errMessage);
    }
}