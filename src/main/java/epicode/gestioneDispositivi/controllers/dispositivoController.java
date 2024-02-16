package epicode.gestioneDispositivi.controllers;

import epicode.gestioneDispositivi.entities.Dispositivo;
import epicode.gestioneDispositivi.exceptions.BadRequestException;
import epicode.gestioneDispositivi.payload.newDispositivoDTO;
import epicode.gestioneDispositivi.services.DispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dispositivo")
public class dispositivoController {

    @Autowired
    DispositivoService dispositivoService;

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Dispositivo save (@RequestBody @Validated newDispositivoDTO dispositivo , BindingResult validation){
        if(validation.hasErrors()){
            throw new BadRequestException((validation.getAllErrors()));
        }
        return  dispositivoService.save(dispositivo);
    }

    @GetMapping("")
    public Page<Dispositivo> getDispositivo(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String orderBy){
        return dispositivoService.getDispositivo(page, size, orderBy);
    }

    @GetMapping("/{dispositivoId}")
    public Dispositivo findById(@PathVariable int dispositivoId) {
        return dispositivoService.findById(dispositivoId);
    }



    @PutMapping("/{dispositivoID}")
    public Dispositivo findByIdAndUpdate(@PathVariable int dispositivoId) {
        return dispositivoService.findByIdAndUpdate(dispositivoId);
    }


    @DeleteMapping("/{dispositivoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int dispositivoId) {
        dispositivoService.findByIdAndDelete(dispositivoId);
    }


}
