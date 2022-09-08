package ma.sprintmanager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.sprintmanager.DAOs.ResponsibleRepository;
import ma.sprintmanager.exceptions.EntityNotFoundException;
import ma.sprintmanager.exceptions.ErrorCode;
import ma.sprintmanager.exceptions.InvalidEntityException;
import ma.sprintmanager.models.Project;
import ma.sprintmanager.models.Responsible;
import ma.sprintmanager.validators.ResponsibleValidator;

@Service
public class ResponsibleService implements IResponsibleService{

    @Autowired
    private ResponsibleRepository responsibleRepo;



    @Override
    public void createResponsible(Responsible r) {
        List<String> errors = ResponsibleValidator.validate(r);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Responsable non valide !", ErrorCode.RESOURCE_NOT_VALID);
        }
        responsibleRepo.save(r); 
    }

    @Override
    public Responsible readResponsibleById(Long id) {
        Optional<Responsible> result = responsibleRepo.findById(id);
        if ( id == null || !result.isPresent() ) {
            throw new EntityNotFoundException("Responsable inexistant !", ErrorCode.RESOURCE_NOT_FOUND);
        }
        return result.get();
    }

    @Override
    public List<Responsible> readRsponsibleByName(String name) {
        List<Responsible> result1 = responsibleRepo.findByLastName(name);
        List<Responsible> result2 = responsibleRepo.findByFirstName(name);
        ArrayList<Responsible> merge = new ArrayList<>();
        merge.addAll(result1);
        merge.addAll(result2);
        if( merge.isEmpty() ){
            throw new EntityNotFoundException("Aucun employe ne porte ce nom !", ErrorCode.RESOURCE_NOT_FOUND);
        }
        return merge;
    }

    @Override
    public List<Responsible> readAllResponsibles() {
        return responsibleRepo.findAll();
    }

    @Override
    public void updateResponsible(Responsible r) {
        List<String> errors = ResponsibleValidator.validate(r);
        if( ! errors.isEmpty() ){
            throw new InvalidEntityException("Responsable invalide", ErrorCode.RESOURCE_NOT_VALID);
        }
        responsibleRepo.save(r);
    }

    @Override
    public void deleteResponsible(Long id) {
        responsibleRepo.delete(responsibleRepo.findById(id).get());        
    }

    @Override
    public List<Project> readProjects(Long id) {
        return ( (Responsible) responsibleRepo.findById(id).get() ).getProjects();
    }

}
