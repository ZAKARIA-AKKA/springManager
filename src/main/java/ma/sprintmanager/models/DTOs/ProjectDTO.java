package ma.sprintmanager.models.DTOs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Status;
import ma.sprintmanager.services.ResponsibleService;

@Data
@Builder
@Component
@NoArgsConstructor @AllArgsConstructor
public class ProjectDTO 
{
    @Autowired
    private ResponsibleService responsibleService;
    
    private Long idProject;

    private String titleProject;
    private String descriptionProject;
    private Date startDateProject;
    private Date endDateProject;
    private Double budgetProject;
    private Status statusProject;
    private Long creatorId;

    public Project toEntity(ProjectDTO dto){
        if( dto == null )   return null;
        
        return Project.builder()
                        .idProject(dto.getIdProject())
                        .titleProject(dto.getTitleProject())
                        .descriptionProject(dto.getDescriptionProject())
                        .startDateProject(dto.getStartDateProject())
                        .endDateProject(dto.getEndDateProject())
                        .budgetProject(dto.getBudgetProject())
                        .statusProject(dto.getStatusProject())
                        .creator(responsibleService.readResponsibleById(dto.getCreatorId()))
                        .build();
    }

    public static ProjectDTO fromEntity(Project project){
        if( project == null )   return null;
        return ProjectDTO.builder()
                            .idProject(project.getIdProject())
                            .titleProject(project.getTitleProject())
                            .descriptionProject(project.getDescriptionProject())
                            .startDateProject(project.getStartDateProject())
                            .endDateProject(project.getEndDateProject())
                            .budgetProject(project.getBudgetProject())
                            .statusProject(project.getStatusProject())
                            .creatorId( project.getCreator().getId() )
                            .build();
    }

}
