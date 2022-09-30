package org.isu.rpd.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "learning_profiles")
public class LearningProfile implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @OneToOne
    private Specialty specialty;
    public LearningProfile() {
    }
/*
    @JsonValue
    @JsonRawValue
    public String toJson() {
        return "LearningProfile{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", specialty=" + specialty +
                '}';
    }*/
}