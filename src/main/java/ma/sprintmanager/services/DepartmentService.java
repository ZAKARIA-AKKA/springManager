package ma.sprintmanager.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.DepartmentRepository;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Department;
import ma.sprintmanager.models.Resource;
import ma.sprintmanager.validators.DepartmentValidator;

@Service
public class DepartmentService implements IDepartmentService{

    @Autowired
    DepartmentRepository departmentRepo;


    @Override
    public void createDepartment(Department d) {
        List<String> errors = DepartmentValidator.validate(d);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Departement non valide !");
        }
        departmentRepo.save(d);
    }

    @Override
    public Department readDepartmentById(Long id) {
        Optional<Department> result = departmentRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Departement inexistant");
        }
        return result.get();
    }

    @Override
    public List<Department> readDepartmentsByName(String name) {
        List<Department> result = departmentRepo.findByName(name);
        if( result.isEmpty() ){
            throw new EntityNotFoundException("Aucun departement ne porte ce nom");
        }
        return result;
    }

    @Override
    public List<Department> readAllDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public void updateDepartment(Department d) {
        List<String> errors = DepartmentValidator.validate(d);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Departement invalide");
        }
        departmentRepo.save(d);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepo.delete(readDepartmentById(id));        
    }

    @Override
    public List<Resource> readResources(Long id) {
        return readDepartmentById(id).getResources();
    }
    
}
