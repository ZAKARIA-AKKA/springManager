package ma.sprintmanager.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Status;

public class ProjectValidator 
{
    
    public static List<String> validate(Project project)
    {

        List<String> errors = new ArrayList<>();

        if (project == null){
            errors.add("Projet non valide");
        }else {
            if( ! StringUtils.hasLength(project.getTitleProject()) ){
                errors.add("Titre du projet requis");
            }
            if( project.getStartDateProject() == null ){
                errors.add("Date de debut requise");
            }
            if(( Status.DONE == project.getStatusProject() ) && ( project.getEndDateProject() == null )){
                errors.add("Date de fin requise");
            }
            if( project.getBudgetProject() == null ){
                errors.add("Budget du projet requis");
            }
            if( project.getStatusProject() == null ){
                errors.add("Statut du projet requis");
            }
            if( project.getCreator() == null ){
                errors.add("Createur requis");
            }
        }
        return errors;

    }

}
