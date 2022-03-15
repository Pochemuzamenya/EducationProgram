package model;

import com.fasterxml.jackson.annotation.*;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;
import org.json.JSONObject;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.*;

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
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private String status;
    @OneToOne
    private LearningProfile learning_profile;
    @OneToOne
    private Specialty specialty;
    @Column
    private Integer year;
    @Column
    private String degree;
    @OneToOne
    private Chair chair;
    @OneToOne
    private Version version;
    @Column
    private String subject_index;
    @Type( type = "int-array" )
    @Column(columnDefinition = "integer[]")
    private Integer[] semestrs;
    @Column
    private String study_form;
    /*@Column
    private String purpose;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinTable(name = "programs_tasks",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id"))
    private List<Task> tasks;
    @Column
    private String choice;
    @Column
    private String subjects_before_text;*/
    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "programs_subjects_before",
            joinColumns = @JoinColumn(name = "program_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects_before;*/
    public Program() {
    }

    public void copyParameters(Program old) {
        this.subject = old.subject;
        this.status = old.status;
        this.learning_profile = old.learning_profile;
        this.specialty = old.specialty;
        this.year = old.year;
        this.degree = old.degree;
        this.chair = old.chair;
        this.version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        this.subject_index = old.subject_index;
        this.semestrs = old.semestrs;
    }

    public LearningProfile getLearning_profile() {
        return learning_profile;
    }

    public void setLearning_profile(LearningProfile learning_profile) {
        this.learning_profile = learning_profile;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }

    public String getStudy_form() {
        return study_form;
    }

    public void setStudy_form(String study_form) {
        this.study_form = study_form;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
/*
    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }
*/
    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
/*
    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
    */

    public Version getVersion() {
        return version;
    }

    public void setVersion(Version version) {
        this.version = version;
    }


    public String getSubject_index() {
        return subject_index;
    }

    public void setSubject_index(String subject_index) {
        this.subject_index = subject_index;
    }

    public Integer[] getSemestrs() {
        return semestrs;
    }

    public void setSemestrs(Integer[] semestrs) {
        this.semestrs = semestrs;
    }

    private java.util.Set<Integer> getCourses(Integer[] semestrs) {
        java.util.Set set = new HashSet();
        for (Integer i:semestrs){
            set.add((i+1)/2);
        }
        return set;
    }

    @Override
    public String toString() {
        return "Program{" +
                "id=" + id +
                ", subject=" + subject +
                ", status='" + status + '\'' +
                ", learning_profile=" + learning_profile +
                ", specialty=" + specialty +
                ", year=" + year +
                ", degree='" + degree + '\'' +
                ", chair=" + chair +
                ", version=" + version +
                ", subject_index='" + subject_index + '\'' +
                ", semestrs=" + Arrays.toString(semestrs) +
                ", study_form='" + study_form + '\'' +
                '}';
    }
    /*public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

public List<String> getTaskNames(){
        List<String> list = new ArrayList<>();
        for (Task task: tasks)
            list.add(task.getName());
        return list;
}

    public String getChoice() {
        return choice;
    }

    public void setChoice(String place) {
        this.choice = place;
    }
*/
/*
    @JsonRawValue
    public String getChoice(){
        String[] ar = subject_index.split("\\.");
        if (ar[1].equals("О") || ar[1].equals("Б") || ar[0].equals("ЭЛК"))
            return String.format("Учебная дисциплина \"%s\" относится к обязательной части программы.", subject.getName());
        else if (ar[1].equals("В") || ar[1].equals("ДВ"))
        return String.format("Учебная дисциплина \"%s\" относится к к части, формируемой участниками образовательных отношений.", subject.getName());
        return null;
    }

 */

@JsonValue
@JsonRawValue
 public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("subject", subject.getName());
        json.put("specialty_code",specialty.getCode());
        json.put("specialty",specialty.getName());
        json.put("learning_profile",learning_profile.getName());
        json.put("study_form", study_form);
        json.put("year",year);
        json.put("last_edit",version.getLast_edit());
        json.put("creation_date",version.getCreation_date());
        json.put("status",status);
        json.put("index", subject_index);
        json.put("semestrs", semestrs);
        json.put("courses",getCourses(semestrs));

        /*json.put("purpose",purpose);
        json.put("tasks", getTaskNames());
        json.put("choice", choice);
        json.put("subjects_before_text", subjects_before_text);*/
        //json.put("subjects_before", subjects_before);
        return json;
    }

}
