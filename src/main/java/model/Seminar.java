package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "seminars")
public class Seminar implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer hours;
    @Column
    private Integer practical_hours;
    @Column
    private String eval_tool;
    @ManyToOne
    private Theme theme;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "seminars_competences",
            joinColumns = {@JoinColumn(name = "seminar_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private Set<Competence> competences;
    public Seminar() {
    }
}
