package ma.sprintmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.TaskRepository;
import ma.sprintmanager.exceptions.EntityNotFoundException;
import ma.sprintmanager.exceptions.ErrorCode;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Task;
import ma.sprintmanager.validators.TaskValidator;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepo;




    @Override
    public void createTask(Task task) {
        // Task t = dtoClass.toEntity(dto);
        List<String> errors = TaskValidator.validate(task);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Tache non valide !", ErrorCode.TASK_NOT_VALID);
        }
        taskRepo.save(task);         
    }

    @Override
    public Task readTaskById(Long id) {
        Optional<Task> result = taskRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Tache inexistante !", ErrorCode.TASK_NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Task> readAllTasks() {
        // List<Task> tasks = taskRepo.findAll();
        // List<TaskDTO> dtos = new ArrayList<>();
        // for (Task t : tasks ) {
        //     dtos.add( TaskDTO.fromEntity(t) );
        // }
        return taskRepo.findAll();
    }

    @Override
    public void updateTask(Task task) {
        // Task t = dtoClass.toEntity(dto);
        List<String> errors = TaskValidator.validate(task);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Tache non valide !", ErrorCode.TASK_NOT_VALID);
        }
        taskRepo.save(task);        
    }

    @Override
    public void deleteTask(Long id) {
        Optional<Task> t = taskRepo.findById(id);
        if ( id == null || !t.isPresent() ) {
            throw new EntityNotFoundException("Projet inexistant !", ErrorCode.PROJECT_NOT_FOUND);
        }
        taskRepo.delete( t.get() ); 
    }
    
}
