package org.isu.rpd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "indicators")
public class Indicator implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String code;
    @Column
    private String description;
    @Column
    private String know;
    @Column
    private String can;
    @Column
    private String own;

    public Indicator() {
    }
}
