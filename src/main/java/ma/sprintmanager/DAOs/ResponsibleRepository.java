package ma.sprintmanager.DAOs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sprintmanager.models.Responsible;


@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
 
    List<Responsible> findByFirstName(String firstName);
    List<Responsible> findByLastName(String lastName);

}
