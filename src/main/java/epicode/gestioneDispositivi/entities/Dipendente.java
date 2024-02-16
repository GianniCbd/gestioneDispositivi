package epicode.gestioneDispositivi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "dipendente")
@ToString
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String avatar;

    @OneToMany(mappedBy = "dipendente")
    @JsonIgnore
    private List<Dispositivo> dispositivo;

    public Dipendente(String username, String name, String lastName, String email,String avatar) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
    }

}
