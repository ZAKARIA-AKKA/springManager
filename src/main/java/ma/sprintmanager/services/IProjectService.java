package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Sprint;

public interface IProjectService {

    void createProject(Project project);

    Project readProjectById(Long id);
    List<Project> readAllProjects();

    void updateProject(Project project);

    void deleteProject(Long id);

    List<Sprint> readSprints(Long id);

    List<Project> searchProjects(String title );
}
