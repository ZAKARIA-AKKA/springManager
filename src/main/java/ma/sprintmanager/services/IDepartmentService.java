package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Department;
import ma.sprintmanager.models.Resource;

public interface IDepartmentService {

    void createDepartment(Department d);

    Department readDepartmentById(Long id);
    List<Department> readDepartmentsByName(String name);
    List<Department> readAllDepartments();

    void updateDepartment(Department d);

    void deleteDepartment(Long id);

    List<Resource> readResources(Long id);

}
