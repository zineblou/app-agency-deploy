package ma.atos.agencymanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AgencyNotFoundResponse {
    @ResponseBody
    @ExceptionHandler(AgencyNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)

    String agencyNotFoundHandler(AgencyNotFoundException exception){
        return exception.getMessage();
    }
}
