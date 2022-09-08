package ma.sprintmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.sprintmanager.exceptions.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.ResourceRepository;
import ma.sprintmanager.exceptions.ErrorCode;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Resource;
import ma.sprintmanager.validators.ResourceValidator;

@Service
public class ResourceService implements IResourceService{

    @Autowired
    ResourceRepository resourceRepo;

    @Override
    public void createResource(Resource r) {
        List<String> errors = ResourceValidator.validate(r);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Resource non valide !", ErrorCode.RESOURCE_NOT_VALID);
        }
        resourceRepo.save(r);
    }

    @Override
    public Resource readResourceById(Long id) {
        Optional<Resource> result = resourceRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Resource inexistante !", ErrorCode.RESOURCE_NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Resource> readResourcesByName(String name) {
        List<Resource> result1 = resourceRepo.findByLastName(name);
        List<Resource> result2 = resourceRepo.findByFirstName(name);
        ArrayList<Resource> merge = new ArrayList<>();
        merge.addAll(result1);
        merge.addAll(result2);
        if( merge.isEmpty() ){
            throw new EntityNotFoundException("Aucun employe ne porte ce nom !", ErrorCode.RESOURCE_NOT_FOUND);
        }
        return merge;
    }

    @Override
    public List<Resource> readAllResources() {
        return resourceRepo.findAll();
    }

    @Override
    public void updateResource(Resource r) {   
        List<String> errors = ResourceValidator.validate(r);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Resource non valide !", ErrorCode.RESOURCE_NOT_VALID);
        }
        resourceRepo.save(r);
    }

    @Override
    public void deleteResource(Long id) {
        resourceRepo.delete(readResourceById(id));       
    }


    
    
}
