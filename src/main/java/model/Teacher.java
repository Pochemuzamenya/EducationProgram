package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "teachers")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String first_name;
    @Column
    private String middle_name;
    @Column
    private String last_name;
    @Column
    private String rank;
    @Column
    private String degree;

    public Teacher() {
    }
}
