package ma.sprintmanager.controllers;

import java.util.ArrayList;
import java.util.List;

import ma.sprintmanager.models.DTOs.SprintDTO;
import ma.sprintmanager.models.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.DTOs.ProjectDTO;
import ma.sprintmanager.models.Project;
import ma.sprintmanager.services.IProjectService;


@CrossOrigin
@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private IProjectService projectService;
    @Autowired
    private ProjectDTO dtoClass;
    


    @PostMapping("/new")
    public void addProject(@RequestBody ProjectDTO dto) {
        projectService.createProject( dtoClass.toEntity(dto) );
    }

    @GetMapping("/list/all")
    public List<ProjectDTO> listAll(){
        List<Project> projects = projectService.readAllProjects();
        List<ProjectDTO> dtos = new ArrayList<>();
        for (Project p : projects) {
            dtos.add( ProjectDTO.fromEntity(p) );
        }
        return dtos;
    }
    
    @GetMapping("/show/{id}")
    public ProjectDTO readProject(@PathVariable Long id ){
        return ProjectDTO.fromEntity( projectService.readProjectById(id) );
    }

    @PostMapping("/update")
    public void updateProject(@RequestBody ProjectDTO dto) {
        projectService.updateProject( dtoClass.toEntity(dto) );
    }

    @GetMapping("/delete/{id}")
    public void deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
    }

    @GetMapping("/sprints/{id}")
    public List<SprintDTO> getSprints(@PathVariable Long id ){
        List<Sprint> sprints = projectService.readProjectById(id).getSprints();
        List<SprintDTO> dtos = new ArrayList<>();
        for (Sprint s : sprints ) {
            dtos.add( SprintDTO.fromEntity(s) );
        }
        return dtos;
    }

    @GetMapping("/search/{title}")
    public List<ProjectDTO> searchProjects(@PathVariable String title ){
        List<Project> projects = projectService.searchProjects(title);
        List<ProjectDTO> dtop = new ArrayList<>();
        for (Project p : projects ) {
            dtop.add( ProjectDTO.fromEntity(p));
        }
        return dtop;
    }

}
