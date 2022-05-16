package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "ind_works")
public class IndWork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String type;
    @Column
    private Integer hours;
    @ManyToOne
    private Theme theme;
    @Column
    private String eval_tool;
    @Column
    private String timing;
    @Column
    private String study_source;

    public IndWork() {
    }
}
