package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    private Set set;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private String subject_index;
    @Column
    private String status;
    @OneToOne
    private Chair chair;
    @OneToOne
    private Version version;
    @Type( type = "int-array" )
    @Column(columnDefinition = "integer[]")
    private Integer[] semestrs;

    public Program() {
    }

    @Override
    public String toString() {
        return "\n{\n\"subject\": \"" + subject.getName() + "\",\n" +
                "\"specialty_code\": \"" + set.getLearning_profile().getSpecialty().getCode() + "\",\n" +
                "\"specialty\": \"" + set.getLearning_profile().getSpecialty().getName() + "\",\n" +
                "\"learning_profile\": \"" + set.getLearning_profile().getName() + "\",\n" +
                "\"study_form\": \"" + set.getStudy_form() + "\",\n" +
                "\"year\": \"" + set.getYear() + "\",\n" +
                "\"last_edit\": \"" + version.getLast_edit() + "\",\n" +
                "\"creation_date\": \"" + version.getCreation_date() + "\",\n" +
                "\"status\": \"" + status + "\"\n" +
                "}";
    }

    @JsonValue
    @JsonRawValue
    public String toJson(){
        return "\n{\n\"subject\": \"" + subject.getName() + "\",\n" +
                "\"specialty_code\": \"" + set.getLearning_profile().getSpecialty().getCode() + "\",\n" +
                "\"specialty\": \"" + set.getLearning_profile().getSpecialty().getName() + "\",\n" +
                "\"learning_profile\": \"" + set.getLearning_profile().getName() + "\",\n" +
                "\"study_form\": \"" + set.getStudy_form() + "\",\n" +
                "\"year\": \"" + set.getYear() + "\",\n" +
                "\"last_edit\": \"" + version.getLast_edit() + "\",\n" +
                "\"creation_date\": \"" + version.getCreation_date() + "\",\n" +
                "\"status\": \"" + status + "\"\n" +
                "}";
    }

}
