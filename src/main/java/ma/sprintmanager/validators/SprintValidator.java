package ma.sprintmanager.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Sprint;
import ma.sprintmanager.models.Status;

public class SprintValidator {
    public static List<String> validate(Sprint sprint)
    {

        List<String> errors = new ArrayList<>();

        if (sprint == null){
            errors.add("Sprint non valide");
        }else {
            if( ! StringUtils.hasLength(sprint.getTitleSprint()) ){
                errors.add("Titre du Sprint requis");
            }
            if( sprint.getStartDateSprint() == null ){
                errors.add("Date de debut requise");
            }
            if(( Status.DONE == sprint.getStatusSprint() ) && ( sprint.getEndDateSprint() == null )){
                errors.add("Date de fin requise");
            }
            if( sprint.getStatusSprint() == null ){
                errors.add("Statut du projet requis");
            }
            if( sprint.getProject() == null ){
                errors.add("Projet requis");
            }
        }
        return errors;

    }

}
