package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "lesson_plans")
public class LessonPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "learning_profile_id")
    private LearningProfile learningProfile;
    @Column
    private String degree;
    @Column
    private String study_form;
    @Column
    private Integer year;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "lesson_plans_competences",
            joinColumns = {@JoinColumn(name = "lesson_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private List<Competence> competences=new ArrayList<>();
    public LessonPlan() {
    }
}
