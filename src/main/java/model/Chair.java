package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "chairs")
public class Chair implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private Integer number;
    @OneToOne
    private Faculty faculty;
    @ManyToOne
    @JoinColumn(name = "chair_head")
    private Teacher chair_head;

    public Chair() {
    }

}
