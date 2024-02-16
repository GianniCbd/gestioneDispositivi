package epicode.gestioneDispositivi.controllers;

import epicode.gestioneDispositivi.entities.Dipendente;
import epicode.gestioneDispositivi.exceptions.BadRequestException;
import epicode.gestioneDispositivi.payload.newDipendeteDTO;
import epicode.gestioneDispositivi.services.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dipendente")
public class dipendenteController {
    @Autowired
    DipendenteService dipendenteService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dipendente save (@RequestBody @Validated newDipendeteDTO newDipendeteDTOO, BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException((validation.getAllErrors()));
        }
        return  dipendenteService.save(newDipendeteDTOO);
    }

    @GetMapping("")
    public Page<Dipendente> getAllUser(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String orderBy){
        return dipendenteService.getAllUser(page, size, orderBy);
    }

    @GetMapping("/{dipendenteId}")
    public Dipendente findById(@PathVariable int dipendenteId) {
        return dipendenteService.findById(dipendenteId);
    }


    @PutMapping("/{dipendenteID}")
    public Dipendente findAndUpdate(@PathVariable int dipendenteId, @RequestBody Dipendente body) {
        return dipendenteService.findByIdAndUpdate(dipendenteId, body);
    }


    @DeleteMapping("/{dipendenteId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int dipendenteId) {
        dipendenteService.findByIdAndDelete(dipendenteId);
    }



}
