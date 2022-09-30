package org.isu.rpd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "competences")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String description;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "competences_indicators",
            joinColumns = { @JoinColumn(name = "competence_id") },
            inverseJoinColumns = { @JoinColumn(name = "indicator_id") })
    private List<Indicator> indicators;

    public Competence() {
    }
}
