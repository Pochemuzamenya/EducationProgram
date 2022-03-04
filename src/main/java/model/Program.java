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
import org.json.JSONObject;

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
    /*@Column
    private String subject_index;*/
    @Column
    private String status;
    @OneToOne
    private Chair chair;
    @OneToOne
    private Version version;
    /*@Type( type = "int-array" )
    @Column(columnDefinition = "integer[]")
    private Integer[] semestrs;*/

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    /*public String getSubject_index() {
        return subject_index;
    }

    public void setSubject_index(String subject_index) {
        this.subject_index = subject_index;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }

    /*public Integer[] getSemestrs() {
        return semestrs;
    }

    public void setSemestrs(Integer[] semestrs) {
        this.semestrs = semestrs;
    }*/

    @JsonValue
    @JsonRawValue
    public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("subject", subject.getName());
        json.put("specialty_code",set.getLearning_profile().getSpecialty().getCode());
        json.put("specialty",set.getLearning_profile().getSpecialty().getName());
        json.put("learning_profile",set.getLearning_profile().getName());
        json.put("study_form",set.getStudy_form());
        json.put("year",set.getYear());
        json.put("last_edit",version.getLast_edit());
        json.put("creation_date",version.getCreation_date());
        json.put("status",status);
        return json;
        /*return "\n{\n\"subject\": \"" + subject.getName() + "\",\n" +
                "\"specialty_code\": \"" + set.getLearning_profile().getSpecialty().getCode() + "\",\n" +
                "\"specialty\": \"" + set.getLearning_profile().getSpecialty().getName() + "\",\n" +
                "\"learning_profile\": \"" + set.getLearning_profile().getName() + "\",\n" +
                "\"study_form\": \"" + set.getStudy_form() + "\",\n" +
                "\"year\": \"" + set.getYear() + "\",\n" +
                "\"last_edit\": \"" + version.getLast_edit() + "\",\n" +
                "\"creation_date\": \"" + version.getCreation_date() + "\",\n" +
                "\"status\": \"" + status + "\"\n" +
                "}";*/
    }

}
