package org.isu.rpd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "lesson_forms")
public class LessonForm implements Cloneable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
    @Column
    private String form;
    @ManyToOne
    private Theme theme;
    @Column
    private Integer hours;
    

    public LessonForm() {
    }
}
