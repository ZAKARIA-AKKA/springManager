package ma.sprintmanager.DAOs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sprintmanager.models.Sprint;


@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {

}
