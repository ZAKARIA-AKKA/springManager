package ma.sprintmanager.models;

import java.util.Date;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

@DynamicUpdate
@Entity @Table(name = "tasks")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_task")
    private Long idTask;

    @Column(name = "title_task")
    private String titleTask;
    
    @Column(name = "desctiption_task")
    private String descriptionTask;

    @Column(name = "start_date_task")
    @Temporal(TemporalType.DATE)
    private Date startDateTask;

    @Column(name = "end_date_task")
    @Temporal(TemporalType.DATE)
    private Date endDateTask;

    @Column(name = "status_task")
    @Enumerated(value = EnumType.STRING)
    private Status statusTask;

    @ManyToOne
    @JoinColumn(name = "sprint_id")
    private Sprint sprint;

    @ManyToOne(
        cascade = CascadeType.MERGE
    )
    @JoinColumn(name = "epmloyee_in_charge_id")
    private Resource employee;

}
