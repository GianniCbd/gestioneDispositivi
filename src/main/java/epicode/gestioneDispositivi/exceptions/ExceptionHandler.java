package epicode.gestioneDispositivi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class ExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPayload HandleNotFound(NotFoundException e){
        return new ErrorPayload(e.getMessage(), LocalDateTime.now());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorPayload HandleBadRequest(BadRequestException e) {
        if(e.getErrorList() != null){

            List<String> errorList = e.getErrorList().stream().map(objectError -> objectError.getDefaultMessage()).toList();
            return new ErrorPayloadList(e.getMessage(),LocalDateTime.now(),errorList);
        }else{
            return new ErrorPayload(e.getMessage(), LocalDateTime.now());
        }
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorPayload handleGeneric(Exception e) {
        e.printStackTrace();
        return new ErrorPayload("Errore generico, risolveremo il prima possibile", LocalDateTime.now());
    }
}
