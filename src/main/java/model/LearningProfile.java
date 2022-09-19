package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
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