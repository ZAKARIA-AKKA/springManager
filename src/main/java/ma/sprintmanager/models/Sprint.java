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
@Entity @Table(name = "sprints")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sprint")
    private Long idSprint;

    @Column(name = "title_sprint")
    private String titleSprint;
    
    @Column(name = "desctiption_sprint")
    private String descriptionSprint;

    @Column(name = "start_date_sprint")
    @Temporal(TemporalType.DATE)
    private Date startDateSprint;

    @Column(name = "end_date_sprint")
    @Temporal(TemporalType.DATE)
    private Date endDateSprint;

    @Column(name = "status_sprint")
    @Enumerated(value = EnumType.STRING)
    private Status statusSprint;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_project")
    private Project project;
    
    @JsonIgnore
    @OneToMany(
        mappedBy = "sprint",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Task> tasks = new ArrayList<>(); 

}
