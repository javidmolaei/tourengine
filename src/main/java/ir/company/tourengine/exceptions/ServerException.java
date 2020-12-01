package ir.company.tourengine.exceptions;


import ir.company.tourengine.model.response.StandardResponse;
import org.slf4j.Logger;

public class ServerException extends Exception {
    public ServerException(String message) {
        super(message);
    }
    public static StandardResponse create(String message, Exception ex) {
        return StandardResponse.getNOKExceptions(message);
    }

}