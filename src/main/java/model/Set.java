package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sets")
@ToString
public class Set {
    @Id
    private Integer id;
    @OneToOne
    private LearningProfile learning_profile;
    @OneToOne
    private Chair chair;
    @Column
    private String study_form;
    @Column
    private Integer year;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LearningProfile getLearning_profile() {
        return learning_profile;
    }

    public void setLearning_profile(LearningProfile learning_profile) {
        this.learning_profile = learning_profile;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public String getStudy_form() {
        return study_form;
    }

    public void setStudy_form(String study_form) {
        this.study_form = study_form;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
