package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.models.Task;

public interface ISprintService {
    
    void createSprint(Sprint sprint);

    Sprint readSprintById(Long id);
    List<Sprint> readAllSprints();

    void updateSprint(Sprint sprint);

    void deleteSprint(Long id);

    List<Task> readTasks(Long id);

}
