package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@Table(name = "subsections")
public class Subsection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String description;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subsections_themes",
            joinColumns = { @JoinColumn(name = "subsection_id") },
            inverseJoinColumns = { @JoinColumn(name = "theme_id") })
    private List<Theme> themes;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subsections_ind_works",
            joinColumns = {@JoinColumn(name = "subsection_id")},
            inverseJoinColumns = {@JoinColumn(name = "ind_work_id")})
    private List<IndWork> indWorks;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subsections_seminars",
            joinColumns = {@JoinColumn(name = "subsection_id")},
            inverseJoinColumns = {@JoinColumn(name = "seminar_id")})
    private List<Seminar> seminars;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subsections_issues",
            joinColumns = {@JoinColumn(name = "subsection_id")},
            inverseJoinColumns = {@JoinColumn(name = "issue_id")})
    private List<Issue> issues;

    public Subsection() {
    }
}
