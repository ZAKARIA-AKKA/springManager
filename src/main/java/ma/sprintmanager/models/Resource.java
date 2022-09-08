package ma.sprintmanager.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity @Table(name = "resources")
@Inheritance(strategy = InheritanceType.JOINED)
@Data @AllArgsConstructor @NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_resource")
    private Long id;

    @Column(name = "first_name_resource")
    private String firstName;
    
    @Column(name = "last_name_resource")
    private String lastName;

    @Column(name = "description_resource")
    private String descriptionR;

    @Column(name = "type_account")
    @Enumerated(value = EnumType.STRING)
    private EmployeeType type;

    @Column(name = "phone_resource")
    private String phone;

    @Column(name = "adress_resource")
    private String adress;

    @Column(name = "situation_resource")
    private String situation;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @JsonIgnore
    @OneToMany(
        mappedBy = "employee",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY,
        orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>();

    
}

