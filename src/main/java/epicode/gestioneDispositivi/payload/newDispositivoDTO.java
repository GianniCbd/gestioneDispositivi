package epicode.gestioneDispositivi.payload;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class newDispositivoDTO {
    String type;
    String stato;




    List<String> errorsList;
}
