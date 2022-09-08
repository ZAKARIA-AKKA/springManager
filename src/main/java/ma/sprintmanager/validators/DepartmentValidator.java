package ma.sprintmanager.validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import ma.sprintmanager.models.Department;

public class DepartmentValidator 
{

    public static List<String> validate(Department department)
    {

        List<String> errors = new ArrayList<>();

        if (department == null){
            errors.add("Nom du departement requis");
        }else if( ! StringUtils.hasLength(department.getName()) ){
            errors.add("Nom du departement requis");
        }
        return errors;

    }
}
