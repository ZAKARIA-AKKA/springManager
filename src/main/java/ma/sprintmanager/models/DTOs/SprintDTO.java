package ma.sprintmanager.models.DTOs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.sprintmanager.DAOs.ProjectRepository;
import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.models.Status;

@Data
@Builder
@Component
@NoArgsConstructor @AllArgsConstructor
public class SprintDTO {

    @Autowired
    private ProjectRepository projectRepo;
    
    private Long idSprint;

    private String titleSprint;
    private String descriptionSprint;
    private Date startDateSprint;
    private Date endDateSprint;
    private Status statusSprint;
    private Long projectId;
    private Integer numberOfTasks;
    
    public Sprint toEntity(SprintDTO dto){
        if( dto == null )   return null;
        
        return Sprint.builder()
                        .idSprint(dto.getIdSprint())
                        .titleSprint(dto.getTitleSprint())
                        .descriptionSprint(dto.getDescriptionSprint())
                        .startDateSprint(dto.getStartDateSprint())
                        .endDateSprint(dto.getEndDateSprint())
                        .statusSprint(dto.getStatusSprint())
                        .project( projectRepo.findById(dto.getProjectId()).get() )
                        .build();
    }

    public static SprintDTO fromEntity(Sprint sprint){
        if( sprint == null )   return null;
        return SprintDTO.builder()
                            .idSprint(sprint.getIdSprint())
                            .titleSprint(sprint.getTitleSprint())
                            .descriptionSprint(sprint.getDescriptionSprint())
                            .startDateSprint(sprint.getStartDateSprint())
                            .endDateSprint(sprint.getEndDateSprint())
                            .statusSprint(sprint.getStatusSprint())
                            .projectId( sprint.getProject().getIdProject() )
                            .numberOfTasks( sprint.getTasks().size() )
                            .build();
    }
}
