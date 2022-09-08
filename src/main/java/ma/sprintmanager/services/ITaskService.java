package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Task;

public interface ITaskService {
    
    void createTask(Task task);

    Task readTaskById(Long id);
    List<Task> readAllTasks();

    void updateTask(Task task);

    void deleteTask(Long id);

}
