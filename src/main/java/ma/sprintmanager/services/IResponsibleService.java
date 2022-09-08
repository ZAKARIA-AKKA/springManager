package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Responsible;

public interface IResponsibleService {
    
    void createResponsible(Responsible r);

    Responsible readResponsibleById(Long id);
    List<Responsible> readRsponsibleByName(String name);
    List<Responsible> readAllResponsibles();

    void updateResponsible(Responsible r);

    void deleteResponsible(Long id);

    List<Project> readProjects(Long id);

}
