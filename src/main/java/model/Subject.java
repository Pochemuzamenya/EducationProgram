package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "subjects")
public class Subject implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    public Subject() {
    }

    @Override
    protected Subject clone() throws CloneNotSupportedException {
        return (Subject) super.clone();
    }
}

