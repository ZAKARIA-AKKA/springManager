package ma.sprintmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.Responsible;
import ma.sprintmanager.services.ResponsibleService;

@CrossOrigin
@RestController
@RequestMapping("/responsible")
public class ResponsibleController {
    
    @Autowired
    private ResponsibleService responsibleService;


    @PostMapping("/new")
    public void addResponsible(@RequestBody Responsible responsible) {
        responsibleService.createResponsible(responsible);
    }

    @GetMapping("/list/all")
    public List<Responsible> listAll(){
        return responsibleService.readAllResponsibles();
    }
    
    @GetMapping("/show/{id}")
    public Responsible readResponsible(@PathVariable Long id ){
        return responsibleService.readResponsibleById(id);
    }
    
    @GetMapping("/show/{name}")
    public List<Responsible> readResponsible(@PathVariable String name ){
        return responsibleService.readRsponsibleByName(name);
    }


    @PostMapping("/update")
    public void updateResponsible(@RequestBody Responsible responsible) {
        responsibleService.updateResponsible(responsible);
    }

    @GetMapping("/delete/{id}")
    public void deleteResponsible(@RequestParam Long id) {
        responsibleService.deleteResponsible(id);
    }
}