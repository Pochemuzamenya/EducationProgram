package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class LessonPlan implements Cloneable{
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
    /*@ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "lesson_plans_competences",
            joinColumns = {@JoinColumn(name = "lesson_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private List<Competence> competences=new ArrayList<>();*/
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "lesson_plans_programs",
            joinColumns = {@JoinColumn(name = "lesson_plan_id")},
            inverseJoinColumns = {@JoinColumn(name = "program_id")})
    private List<Program> programs;
    public LessonPlan() {
    }

    @Override
    public LessonPlan clone() throws CloneNotSupportedException {
        return (LessonPlan) super.clone();
    }

    @JsonRawValue
    @JsonValue
    public String toJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return "{" +
                "\"id\": " + id + ",\n" +
                "\"learningProfile\": " + objectMapper.writeValueAsString(learningProfile)+ ",\n" +
                "\"degree\": " + "\"" + degree + "\"" + ",\n" +
                "\"study_form\": " + "\"" + study_form + "\"" + ",\n" +
                "\"year\": " + year + "\n" +
                "}";
    }
}
