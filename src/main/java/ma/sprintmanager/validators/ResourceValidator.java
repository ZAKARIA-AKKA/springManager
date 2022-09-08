package ma.sprintmanager.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Resource;

public class ResourceValidator {
    
    public static List<String> validate(Resource resource)
    {

        List<String> errors = new ArrayList<>();

        if (resource == null){
            errors.add("Ressource non valide");
        }else {
            if( ! StringUtils.hasLength(resource.getFirstName()) ){
                errors.add("Nom requis");
            }
            if( ! StringUtils.hasLength(resource.getLastName()) ){
                errors.add("Prenom requis");
            }
//            if( resource.getType() == null ){
//                errors.add("Type requis");
//            }
//            if( resource.getDepartment() == null ){
//                errors.add("Departement requis");
//            }
            
        }
        return errors;

    }

}
