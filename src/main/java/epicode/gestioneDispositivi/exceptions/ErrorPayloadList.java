package epicode.gestioneDispositivi.exceptions;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorPayloadList extends ErrorPayload {

    private List<String> errorList;

    public ErrorPayloadList(String message, LocalDateTime localDateTime, List<String>errorList){
        super(message, localDateTime);
        this.errorList = errorList;
    }
    }
