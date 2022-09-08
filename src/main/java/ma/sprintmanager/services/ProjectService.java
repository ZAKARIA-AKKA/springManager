package ma.sprintmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.ProjectRepository;
import ma.sprintmanager.exceptions.EntityNotFoundException;
import ma.sprintmanager.exceptions.ErrorCode;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.validators.ProjectValidator;

@Service
public class ProjectService implements IProjectService{

    @Autowired
    ProjectRepository projectRepo;
    @Autowired
    IResponsibleService responsibleService;


    @Override
    public void createProject(Project project) {
        // Project p = ProjectDTO.toEntity(dto);
        List<String> errors = ProjectValidator.validate(project);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Projet non valide !", ErrorCode.PROJECT_NOT_VALID);
        }
        projectRepo.save(project);        
    }

    @Override
    public Project readProjectById(Long id) {
        Optional<Project> result = projectRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Projet inexistant !", ErrorCode.PROJECT_NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Project> readAllProjects() {
        // List<Project> projects = projectRepo.findAll();
        // List<ProjectDTO> dtos = new ArrayList<>();
        // for (Project p : projects) {
        //     dtos.add( ProjectDTO.fromEntity(p) );
        // }
        return projectRepo.findAll();
    }

    @Override
    public void updateProject(Project project) {
        // Project p = ProjectDTO.toEntity(dto);
        List<String> errors = ProjectValidator.validate(project);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Projet non valide !", ErrorCode.PROJECT_NOT_VALID);
        }
        projectRepo.save(project);    
    }

    @Override
    public void deleteProject(Long id) {
        Optional<Project> p = projectRepo.findById(id);
        if ( id == null || !p.isPresent() ) {
            throw new EntityNotFoundException("Projet inexistant !", ErrorCode.PROJECT_NOT_FOUND);
        }
        projectRepo.delete(p.get()); 
    }

    @Override
    public List<Sprint> readSprints(Long id) {
        return readProjectById(id).getSprints();
    }

    @Override
    public List<Project> searchProjects(String title) {
        return projectRepo.findByTitleProjectLike(title);
    }

}
