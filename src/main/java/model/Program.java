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
    @JoinColumn(name = "learning_profile_id")
    private LearningProfile learning_profile;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private String study_form;
    @Column
    private Integer year;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp creation_date;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp last_edit;
    @Column
    private String status;
    @Column
    @JsonIgnore
    private String degree;

    public Program() {
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", learning_profile=" + learning_profile +
                ", subject=" + subject.getName() +
                ", study_form='" + study_form + '\'' +
                ", year=" + year +
                ", creation_date=" + creation_date +
                ", last_edit=" + last_edit +
                ", status='" + status + '\'' +
                ", degree='" + degree + '\'' +
                '}';
    }
    /**/
    @JsonValue
    @JsonRawValue
    public String toJson(){
        return "\n{\n\"subject\": \"" + subject.getName() + "\",\n" +
                "\"specialty_code\": \"" + learning_profile.getSpecialty().getCode() + "\",\n" +
                "\"specialty\": \"" + learning_profile.getSpecialty().getName() + "\",\n" +
                "\"learning_profile\": \"" + learning_profile.getName() + "\",\n" +
                "\"study_form\": \"" + study_form + "\",\n" +
                "\"year\": \"" + year + "\",\n" +
                "\"last_edit\": \"" + last_edit + "\",\n" +
                "\"creation_date\": \"" + creation_date + "\",\n" +
                "\"status\": \"" + status + "\"\n" +
                "}";
    }

}
