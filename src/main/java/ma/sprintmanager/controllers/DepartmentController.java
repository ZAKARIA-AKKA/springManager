package ma.sprintmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.Department;
import ma.sprintmanager.services.DepartmentService;

@CrossOrigin
@RestController
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/new")
    public void addDepartment(@RequestBody Department department) {
        departmentService.createDepartment(department);
    }

    @GetMapping("/list/all")
    public List<Department> listAll(){
        return departmentService.readAllDepartments();
    }
    
    @GetMapping("/show/{id}")
    public Department readDepartment(@PathVariable Long id ){
        return departmentService.readDepartmentById(id);
    }

    @PostMapping("/update")
    public void updateDepartment(@RequestBody Department department) {
        departmentService.updateDepartment(department);;
    }

    @GetMapping("/delete/{id}")
    public void deleteDepartment(@RequestParam Long id) {
        departmentService.deleteDepartment(id);
    }
}
