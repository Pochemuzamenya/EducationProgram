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
    private Integer seminars;
    @Column
    private Integer consultations;
    @Column
    private Integer ind_work;
    @Column
    private String monitoring;
    @Column
    private String description;
    public Theme() {
    }
}
