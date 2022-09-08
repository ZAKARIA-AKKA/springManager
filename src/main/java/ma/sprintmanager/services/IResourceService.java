package ma.sprintmanager.services;

import java.util.List;

import ma.sprintmanager.models.Resource;

public interface IResourceService {

    void createResource(Resource r);

    Resource readResourceById(Long id);
    List<Resource> readResourcesByName(String name);
    List<Resource> readAllResources();

    void updateResource(Resource r);

    void deleteResource(Long id);
    
}
