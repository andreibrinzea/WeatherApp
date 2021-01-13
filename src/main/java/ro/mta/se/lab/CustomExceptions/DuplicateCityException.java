package ro.mta.se.lab.CustomExceptions;

public class DuplicateCityException extends Exception {
    public DuplicateCityException(String errMessage) {
        super(errMessage);
    }
}
