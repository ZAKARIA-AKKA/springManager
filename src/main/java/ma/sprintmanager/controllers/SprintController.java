package ma.sprintmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import ma.sprintmanager.models.DTOs.TaskDTO;
import ma.sprintmanager.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.DTOs.SprintDTO;
import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.services.ISprintService;


@CrossOrigin
@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    private ISprintService sprintService;
    @Autowired
    private SprintDTO dtoClass;



    @PostMapping("/new")
    public void addSprint(@RequestBody SprintDTO dto) {
        sprintService.createSprint( dtoClass.toEntity(dto) );
    }

    @GetMapping("/list/all")
    public List<SprintDTO> listAll(){
        List<Sprint> sprints = sprintService.readAllSprints();
        List<SprintDTO> dtos = new ArrayList<>();
        for (Sprint s : sprints) {
            dtos.add( SprintDTO.fromEntity(s) );
        }
        return dtos;
    }
    
    @GetMapping("/show/{id}")
    public SprintDTO readSprint(@PathVariable Long id ){
        return SprintDTO.fromEntity( sprintService.readSprintById(id) );
    }

    @PostMapping("/update")
    public void updateSprint(@RequestBody SprintDTO dto) {
        sprintService.updateSprint( dtoClass.toEntity(dto) );
    }

    @GetMapping("/delete/{id}")
    public void deleteSprint(@RequestParam Long id) {
        sprintService.deleteSprint(id);
    }

    @GetMapping("/get/last")
    public SprintDTO getLastSprint(){
        List<SprintDTO> sprints = listAll();
        return sprints.get(sprints.size()-1);
    }

    @GetMapping("/tasks/{id}")
    public List<TaskDTO> getTasks(@PathVariable Long id ){
        List<Task> tasks = sprintService.readSprintById(id).getTasks();
        List<TaskDTO> dtos = new ArrayList<>();
        for (Task t : tasks) {
            dtos.add( TaskDTO.fromEntity(t) );
        }
        return dtos;
    }

}
