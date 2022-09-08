package ma.sprintmanager.models;

import javax.persistence.Entity;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity @Table(name = "Departments")
@Data @AllArgsConstructor @NoArgsConstructor
public class Department {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_department")
    private Long id;

    @Column(name = "name_department")
    private String name;

    @JsonIgnore
    @OneToMany(
        mappedBy = "department",
        // cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Resource> resources = new ArrayList<>();

}
