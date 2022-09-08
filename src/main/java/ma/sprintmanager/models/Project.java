package ma.sprintmanager.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity @Table(name = "projects")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_project")
    private Long idProject;

    @Column(name = "title_project")
    private String titleProject;
    
    @Column(name = "desctiption_project")
    private String descriptionProject;

    @Column(name = "start_date_project")
    @Temporal(TemporalType.DATE)
    private Date startDateProject;

    @Column(name = "end_date_project")
    @Temporal(TemporalType.DATE)
    private Date endDateProject;

    @Column(name = "budget_project")
    private Double budgetProject;

    @Column(name = "status_project")
    @Enumerated(value = EnumType.STRING)
    private Status statusProject;

    @JsonIgnore
    @OneToMany(
        mappedBy = "project",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Sprint> sprints = new ArrayList<>(); 

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "project_creator_id")
    private Responsible creator;

}
