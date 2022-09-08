package ma.sprintmanager.DAOs;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ma.sprintmanager.models.Project;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

//    @Query(value = "SELECT * FROM project WHERE title_project like :title", nativeQuery = true)
    public List<Project> findByTitleProjectLike(String title);

}
