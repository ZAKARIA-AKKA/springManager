package ma.sprintmanager.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Status;
import ma.sprintmanager.models.Task;

public class TaskValidator 
{

    public static List<String> validate(Task task)
    {

        List<String> errors = new ArrayList<>();

        if (task == null){
            errors.add("Tache non valide !");
        }else {
            if( ! StringUtils.hasLength(task.getTitleTask()) ){
                errors.add("Titre requis");
            }
            if( task.getStartDateTask() == null ){
                errors.add("Date de debut requise");
            }
            if(( Status.DONE == task.getStatusTask() ) && ( task.getEndDateTask() == null )){
                errors.add("Date de fin requise");
            }
            if( task.getStatusTask() == null ){
                errors.add("Statut requis");
            }
            if( task.getSprint() == null ){
                errors.add("Sprint requis");
            }
            if( task.getEmployee() == null ){
                errors.add("Ressource requise");
            }
        }
        return errors;

    }
}
