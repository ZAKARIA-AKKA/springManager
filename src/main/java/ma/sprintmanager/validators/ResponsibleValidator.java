package ma.sprintmanager.validators;

import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Responsible;

public class ResponsibleValidator 
{

    public static List<String> validate(Responsible responsible)
    {

        List<String> errors = ResourceValidator.validate(responsible);

        if( ! StringUtils.hasLength(responsible.getEmail()) ){
            errors.add("Email requis");
        }
        if( ! StringUtils.hasLength(responsible.getPassword()) ){
            errors.add("Mot de passe requis");
        }        
        return errors;

    }

}
