package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "programs")
@Getter
@Setter
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
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp creation_date;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp last_edit;
    @Column
    private String status;
    @OneToOne
    private Chair chair;

    public Program() {
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", learning_profile=" + set.getLearning_profile().getName() +
                ", subject=" + subject.getName() +
                ", study_form='" + set.getStudy_form() + '\'' +
                ", year=" + set.getYear() +
                ", creation_date=" + creation_date +
                ", last_edit=" + last_edit +
                ", status='" + status + '\'' +
                ", degree='" + set.getDegree() + '\'' +
                '}';
    }
    /**/
    @JsonValue
    @JsonRawValue
    public String toJson(){
        return "\n{\n\"subject\": \"" + subject.getName() + "\",\n" +
                "\"specialty_code\": \"" + set.getLearning_profile().getSpecialty().getCode() + "\",\n" +
                "\"specialty\": \"" + set.getLearning_profile().getSpecialty().getName() + "\",\n" +
                "\"learning_profile\": \"" + set.getLearning_profile().getName() + "\",\n" +
                "\"study_form\": \"" + set.getStudy_form() + "\",\n" +
                "\"year\": \"" + set.getYear() + "\",\n" +
                "\"last_edit\": \"" + last_edit + "\",\n" +
                "\"creation_date\": \"" + creation_date + "\",\n" +
                "\"status\": \"" + status + "\"\n" +
                "}";
    }

}
