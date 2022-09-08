package ma.sprintmanager.DAOs;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sprintmanager.models.Resource;


@Repository

public interface ResourceRepository extends JpaRepository<Resource, Long> {
    List<Resource> findByFirstName(String firstName);
    List<Resource> findByLastName(String lastName);
}
