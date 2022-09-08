package ma.sprintmanager.services;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.SprintRepository;
import ma.sprintmanager.exceptions.EntityNotFoundException;
import ma.sprintmanager.exceptions.ErrorCode;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.models.Task;
import ma.sprintmanager.validators.SprintValidator;

@Service
public class SprintService implements ISprintService {

    @Autowired
    private SprintRepository sprintRepo;


    @Override
    public void createSprint(Sprint sprint) {
        // Sprint s = dtoClass.toEntity(dto);
        List<String> errors = SprintValidator.validate(sprint);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Sprint non valide !", ErrorCode.SPRINT_NOT_VALID);
        }
        sprintRepo.save(sprint);        
    }

    @Override
    public Sprint readSprintById(Long id) {
        Optional<Sprint> result = sprintRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Sprint inexistant !", ErrorCode.SPRINT_NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Sprint> readAllSprints() {
        // List<Sprint> sprints = sprintRepo.findAll();
        // List<SprintDTO> dtos = new ArrayList<>();
        // for (Sprint s : sprints ) {
        //     dtos.add( SprintDTO.fromEntity(s) );
        // }
        return sprintRepo.findAll();    
    }

    @Override
    public void updateSprint(Sprint sprint) {
        // Sprint s = dtoClass.toEntity(dto);
        List<String> errors = SprintValidator.validate(sprint);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Projet non valide !", ErrorCode.SPRINT_NOT_VALID);
        }
        sprintRepo.save(sprint);          
    }

    @Override
    public void deleteSprint(Long id) {
        Optional<Sprint> sprint = sprintRepo.findById(id);
        if ( id == null || !sprint.isPresent() ) {
            throw new EntityNotFoundException("Projet inexistant !", ErrorCode.PROJECT_NOT_FOUND);
        }
        sprintRepo.delete( sprint.get() ); 
        }

    @Override
    public List<Task> readTasks(Long id) {
        // List<Task> tasks = sprintRepo.findById(id).get().getTasks();
        // List<TaskDTO> dtos = new ArrayList<>();
        // for (Task t : tasks) {
        //     dtos.add( TaskDTO.fromEntity(t) );
        // }
        return readSprintById(id).getTasks();    
    }
    
}
