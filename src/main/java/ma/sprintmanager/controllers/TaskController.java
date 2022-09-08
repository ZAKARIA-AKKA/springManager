package ma.sprintmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.DTOs.TaskDTO;
import ma.sprintmanager.models.Task;
import ma.sprintmanager.services.ITaskService;


@CrossOrigin
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private ITaskService taskService;
    @Autowired
    private TaskDTO dtoClass;
    


    @PostMapping("/new")
    public void addTask(@RequestBody TaskDTO dto) {
        taskService.createTask( dtoClass.toEntity(dto) );
    }

    @GetMapping("/list/all")
    public List<TaskDTO> listAll(){
        List<Task> tasks = taskService.readAllTasks();
        List<TaskDTO> dtos = new ArrayList<>();
        for (Task t : tasks) {
            dtos.add( TaskDTO.fromEntity(t) );
        }
        return dtos;
    }
    
    @GetMapping("/show/{id}")
    public TaskDTO readTask(@PathVariable Long id ){
        return TaskDTO.fromEntity( taskService.readTaskById(id) );
    }


    @PostMapping("/update")
    public void updateTask(@RequestBody TaskDTO dto) {
        taskService.updateTask( dtoClass.toEntity(dto) );
    }

    @GetMapping("/delete/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
