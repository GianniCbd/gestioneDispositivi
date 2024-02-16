package epicode.gestioneDispositivi.services;

import epicode.gestioneDispositivi.Enum.StatoDispositivo;
import epicode.gestioneDispositivi.entities.Dispositivo;
import epicode.gestioneDispositivi.exceptions.NotFoundException;
import epicode.gestioneDispositivi.payload.newDispositivoDTO;
import epicode.gestioneDispositivi.repositories.DispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DispositivoService {

@Autowired
    DispositivoRepository dispositivoRepository;

@Autowired
    DipendenteService dipendenteService;


    //Get
    public Page<Dispositivo> getAllUser(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return dispositivoRepository.findAll(pageable);
    }

//    Post
    public Dispositivo save(newDispositivoDTO newDispositivoDTO){
        Dispositivo dispositivo = new Dispositivo(newDispositivoDTO.getType(), StatoDispositivo.valueOf("DISPONIBILE").toString());
        return dispositivoRepository.save(dispositivo);
    }
    public Dispositivo findById(long id) {
        return dispositivoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }
    public Dispositivo findByIdAndUpdate(int id, Dispositivo body) {
            Dispositivo found = this.findById(id);
            found.setStato(StatoDispositivo.valueOf("DISPONIBILE").toString());
        return dispositivoRepository.save(found);
    }

    public void findByIdAndDelete(int id) {
        Dispositivo found = this.findById(id);
        dispositivoRepository.delete(found);
    }





}
