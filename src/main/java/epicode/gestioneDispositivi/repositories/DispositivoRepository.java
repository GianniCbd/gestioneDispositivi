package epicode.gestioneDispositivi.repositories;

import epicode.gestioneDispositivi.entities.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo,Long > {


}
