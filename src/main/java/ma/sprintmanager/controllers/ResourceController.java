package ma.sprintmanager.controllers;

import java.util.List;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ma.sprintmanager.models.Resource;
import ma.sprintmanager.services.ResourceService;


@CrossOrigin
@RestController
@RequestMapping("/resource")
public class ResourceController {
    
    @Autowired
    private ResourceService resourceService;



    @PostMapping("/new")
    public void addResource(@RequestBody Resource resource) {
        resourceService.createResource(resource);
    }

    @GetMapping("/list/all")
    public List<Resource> listAll(){
        return resourceService.readAllResources();
    }
    
    @GetMapping("/show/{id}")
    public Resource readResource(@PathVariable Long id ){
        return resourceService.readResourceById(id);
    }

    @PostMapping("/update")
    public void updateResource(@RequestBody Resource resource) {
        resourceService.updateResource(resource);;
    }

    @GetMapping("/delete/{id}")
    public void deleteResource(@RequestParam Long id) {
        resourceService.deleteResource(id);
    }
}
