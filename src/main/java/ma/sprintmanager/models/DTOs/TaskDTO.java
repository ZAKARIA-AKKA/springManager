package ma.sprintmanager.models.DTOs;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.sprintmanager.DAOs.SprintRepository;
import ma.sprintmanager.models.Status;
import ma.sprintmanager.models.Task;
import ma.sprintmanager.services.ResourceService;

@Data
@Builder
@Component
@NoArgsConstructor @AllArgsConstructor
public class TaskDTO {

    @Autowired
    private SprintRepository sprintRepo;

    @Autowired
    private ResourceService resourceService;
    
    private Long idTask;

    private String titleTask;
    private String descriptionTask;
    private Date startDateTask;
    private Date endDateTask;
    private Status statusTask;
    private Long sprintId;
    private Long employeeId;

    public Task toEntity(TaskDTO dto){
        if( dto == null )   return null;
        return Task.builder()
                        .idTask(dto.getIdTask())
                        .titleTask(dto.getTitleTask())
                        .descriptionTask(dto.getDescriptionTask())
                        .startDateTask(dto.getStartDateTask())
                        .endDateTask(dto.getEndDateTask())
                        .statusTask(dto.getStatusTask())
                        .sprint( sprintRepo.findById(dto.getSprintId()).get() )
                        .employee( resourceService.readResourceById(dto.getEmployeeId()) )
                        .build();
    }

    public static TaskDTO fromEntity(Task task){
        if( task == null )   return null;
        return TaskDTO.builder()
                        .idTask(task.getIdTask())
                        .titleTask(task.getTitleTask())
                        .descriptionTask(task.getDescriptionTask())
                        .startDateTask(task.getStartDateTask())
                        .endDateTask(task.getEndDateTask())
                        .statusTask(task.getStatusTask())
                        .sprintId( task.getSprint().getIdSprint() )
                        .employeeId( task.getEmployee().getId() )
                        .build();
    }

}
