package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "themes")
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer semester;
    @Column
    private Integer hours;
    @Column
    private Integer practical_hours;
    @Column
    private Integer lectures;
    @Column
    private Integer seminar;
    @Column
    private Integer consultation;
    @Column
    private Integer ind_work;
    @Column
    private String monitoring;
    @Column
    private String description;
    @Column
    private Integer contact_hours;
    @Column
    private Integer lab_work;
    @Column
    private Integer practical_work;
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
    private Integer ko;
    @Column
    private Integer control;
    public Theme() {
    }
}
