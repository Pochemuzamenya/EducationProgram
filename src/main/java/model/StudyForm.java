package model;

import javax.persistence.*;

@Entity
@Table(name = "study_forms")
public class StudyForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    public StudyForm() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StudyForm{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
