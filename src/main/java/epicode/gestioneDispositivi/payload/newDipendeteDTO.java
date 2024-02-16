package epicode.gestioneDispositivi.payload;

import epicode.gestioneDispositivi.entities.Dispositivo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class newDipendeteDTO {

    @NotEmpty(message = "Inserire minimo 3 caratteri")
    @Size(min = 3, max = 20, message = "L'username deve essere compreso tra 3 e 20 caratteri")
    private String username;
    @NotEmpty(message = "Inserire minimo 4 caratteri")
    @Size(min = 3, max = 20, message = "Il nome deve essere compreso tra 3 e 20 caratteri")
    private String name;
    @NotEmpty(message = "Inserire minimo 4 caratteri")
    @Size(min = 3, max = 20, message = "Il nome deve essere compreso tra 3 e 20 caratteri")
    private String lastname;
    @NotEmpty(message = "Inserire minimo 4 caratteri")
    @Email(message = "email non valida")
    private String email;
    List<Dispositivo> dispositivo;


    List<String> errorsList;

}

