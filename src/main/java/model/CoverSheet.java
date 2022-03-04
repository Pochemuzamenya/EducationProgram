package model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.json.JSONObject;

import javax.persistence.*;
import java.util.HashSet;

@Entity
@Table(name = "programs")
@Getter
@Setter
@ToString
@TypeDefs({
        @TypeDef(
                name = "int-array",
                typeClass = IntArrayType.class
        )
})

public class CoverSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    private Subject subject;
    @Column
    private String subject_index;
    @OneToOne
    private Set set;
    @OneToOne
    private Chair chair;
    @Type( type = "int-array" )
    @Column(columnDefinition = "integer[]")
    private Integer[] semestrs;

    public CoverSheet() {
    }

    /*public Integer[] getCourses(Integer[] semestrs){
        semestrs.length
    }*/
    private static java.util.Set<Integer> getCourses(Integer[] semestrs) {
        java.util.Set set = new HashSet();
        for (Integer i:semestrs){
            set.add((i+1)/2);
        }
        return set;
    }
    @JsonValue
    @JsonRawValue
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("subject", subject.getName());
        json.put("index", subject_index);
        json.put("specialty_code",set.getLearning_profile().getSpecialty().getCode());
        json.put("specialty",set.getLearning_profile().getSpecialty().getName());
        json.put("learning_profile",set.getLearning_profile().getName());
        json.put("degree",set.getLearning_profile().getSpecialty().getDegree());
        json.put("study_form",set.getStudy_form());
        json.put("chair", set.getChair().getName());
        json.put("semestrs", semestrs);
        json.put("courses",getCourses(semestrs));
        json.put("year",set.getYear());
        return json;
    }
}
