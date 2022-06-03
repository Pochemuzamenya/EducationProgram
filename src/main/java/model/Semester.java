package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "semesters")
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer number;
    @Column
    private Integer hours;
    @Column
    private Integer contact_hours;
    @Column
    private Integer lectures;
    @Column
    private Integer lab_work;
    @Column
    private Integer practical_work;
    @Column
    private Integer seminar;
    @Column
    private Integer tactical_work;
    @Column
    private Integer military_work;
    @Column
    private Integer methodical_work;
    @Column
    private Integer conference;
    @Column
    private Integer audience;
    @Column
    private Integer consultation;
    @Column
    private Integer ko;
    @Column
    private Integer ind_work;
    @Column
    private Integer control;
    @Column
    private Integer credits;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "semesters_subsections",
            joinColumns = {@JoinColumn(name = "semester_id")},
            inverseJoinColumns = {@JoinColumn(name = "subsection_id")})
    private List<Subsection> subsections;
    public Semester() {
    }
}
