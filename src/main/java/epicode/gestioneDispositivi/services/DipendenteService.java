package epicode.gestioneDispositivi.services;

import epicode.gestioneDispositivi.entities.Dipendente;
import epicode.gestioneDispositivi.exceptions.NotFoundException;
import epicode.gestioneDispositivi.payload.newDipendeteDTO;
import epicode.gestioneDispositivi.repositories.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    DipendenteRepository dipendenteRepository;



    //Get
    public Page<Dipendente> getAllUser(int page, int size, String orderBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(orderBy));
        return dipendenteRepository.findAll(pageable);
    }

    //Post
  public Dipendente save(newDipendeteDTO newDipendeteDTO){
        Dipendente dipendente = new Dipendente(newDipendeteDTO.getUsername(),newDipendeteDTO.getName(), newDipendeteDTO.getLastname(), newDipendeteDTO.getEmail(),"mmm");
        return dipendenteRepository.save(dipendente);
  }

    public Dipendente findById(long id) {
        return dipendenteRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        Dipendente found = this.findById(id);
        dipendenteRepository.delete(found);
    }

    public Dipendente findByIdAndUpdate(int id, Dipendente body) {

        Dipendente found = this.findById(id);
        found.setUsername(body.getUsername());
        found.setName(body.getName());
        found.setLastName(body.getLastName());
        found.setEmail(body.getEmail());
        found.setAvatar(body.getAvatar());
        return dipendenteRepository.save(found);
    }



}
