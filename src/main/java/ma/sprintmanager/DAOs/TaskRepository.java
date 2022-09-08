package ma.sprintmanager.DAOs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.sprintmanager.models.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
