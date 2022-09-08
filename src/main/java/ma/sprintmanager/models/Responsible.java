package ma.sprintmanager.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity @Table(name = "responsibles")
@Data @AllArgsConstructor @NoArgsConstructor @EqualsAndHashCode(callSuper = true)
public class Responsible extends Resource{

    @Column(name = "email_responsible")
    private String email;
    
    @Column(name = "password_responsible")
    private String password;

    @JsonIgnore
    @OneToMany(
        fetch = FetchType.LAZY,
        mappedBy = "creator",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Project> projects = new ArrayList<>();
    


}
