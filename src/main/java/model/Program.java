package model;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
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
        ),
        @TypeDef(
                name = "string-array",
                typeClass = StringArrayType.class
        )
})
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private String status;
    @ManyToOne
    private LearningProfile learning_profile;
    //@OneToOne
    //private Specialty specialty;
    @Column
    private Integer year;
    @Column
    private String degree;
    @ManyToOne
    private Chair chair;
    @ManyToOne
    private Version version;
    @Column(name = "index")
    private String subject_index;
    @Type(type = "int-array")
    @Column(columnDefinition = "integer[]")
    private Integer[] semesters;
    @Column
    private String study_form;
    @Column
    private String purpose;
    @Type(type = "string-array")
    @Column
    private String[] tasks;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subjects_before",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private List<Subject> subjects_before;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "subjects_after",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "subject_id")})
    private List<Subject> subjects_after;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_competences",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private List<Competence> competences;
    @Column
    private Integer hours;
    @Column
    private Integer exam_hours;
    @Column
    private Integer credits;
    @Column
    private String certification_form;
    @Column
    private Integer exam_credits;
    @Type(type = "string-array")
    @Column
    private String[] certification_forms;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_subsections",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "subsection_id")})
    private List<Subsection> subsections;

    @Column
    private String guidance;
    @Column
    private String coursework_theme;
    @Type(type = "string-array")
    @Column
    private String[] bibliography;
    @Type(type = "string-array")
    @Column
    private String[] periodicals;
    @Type(type = "string-array")
    @Column
    private String[] teaching_materials;
    @Type(type = "string-array")
    @Column
    private String[] databases;
    @Type(type = "string-array")
    @Column
    private String[] lab_equipment;
    @Type(type = "string-array")
    @Column
    private String[] software;
    @Type(type = "string-array")
    @Column
    private String[] technical_means;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_lesson_forms",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "lesson_form_id")})
    private List<LessonForm> lessonForms;
    @Column
    private String entrance_certification;
    @Column
    private String current_certification;
    @Column
    private String mid_certification;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_teachers",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "teacher_id")})
    private List<Teacher> teachers;
    @ManyToOne
    private Teacher chair_head;

    public Program() {
    }

    public Program(Program p) {
        this.subject = p.subject;
        this.status = p.status;
        this.learning_profile = p.learning_profile;
        this.year = p.year;
        this.degree = p.degree;
        this.chair = p.chair;
        this.subject_index = p.subject_index;
        this.semesters = p.semesters;
        this.study_form = p.study_form;
        this.purpose = p.purpose;
        this.tasks = p.tasks;
        this.subjects_before = p.subjects_before;
        this.subjects_after = p.subjects_after;
        this.competences = p.competences;
        this.hours = p.hours;
        this.exam_hours = p.exam_hours;
        this.credits = p.credits;
        this.certification_form = p.certification_form;
        this.exam_credits = p.exam_credits;
        this.certification_forms = p.certification_forms;
        this.subsections = p.subsections;
        //this.indWorks = p.indWorks;
        //this.seminars = p.seminars;
        //this.issues = p.issues;
        this.guidance = p.guidance;
        this.coursework_theme = p.coursework_theme;
        this.bibliography = p.bibliography;
        this.periodicals = p.periodicals;
        this.teaching_materials = p.teaching_materials;
        this.databases = p.databases;
        this.lab_equipment = p.lab_equipment;
        this.software = p.software;
        this.technical_means = p.technical_means;
        this.lessonForms = p.lessonForms;
        this.teachers = p.teachers;
        this.chair_head = p.chair_head;
    }

    public void copyParameters(Program p) {
        if (p.subject != null)
            this.subject = p.subject;
        if (p.status != null)
            this.status = p.status;
        if (p.learning_profile != null)
            this.learning_profile = p.learning_profile;
        if (p.year != null)
            this.year = p.year;
        if (p.degree != null)
            this.degree = p.degree;
        if (p.chair != null)
            this.chair = p.chair;
        if (p.subject_index != null)
            this.subject_index = p.subject_index;
        if (p.semesters != null)
            this.semesters = p.semesters;
        if (p.study_form != null)
            this.study_form = p.study_form;
        if (p.purpose != null)
            this.purpose = p.purpose;
        if (p.tasks != null)
            this.tasks = p.tasks;
        if (p.subjects_before != null)
            this.subjects_before = p.subjects_before;
        if (p.subjects_after != null)
            this.subjects_after = p.subjects_after;
        if (p.competences != null)
            this.competences = p.competences;
        if (p.hours != null)
            this.hours = p.hours;
        if (p.exam_hours != null)
            this.exam_hours = p.exam_hours;
        if (p.credits != null)
            this.credits = p.credits;
        if (p.certification_form != null)
            this.certification_form = p.certification_form;
        if (p.exam_credits != null)
            this.exam_credits = p.exam_credits;
        if (p.certification_forms != null)
            this.certification_forms = p.certification_forms;
        if (p.subsections != null)
            this.subsections = p.subsections;
        /*
        if (p.indWorks != null)
            this.indWorks = p.indWorks;
        if (p.seminars != null)
            this.seminars = p.seminars;
        if (p.issues != null)
            this.issues = p.issues;
         */
        if (p.guidance != null)
            this.guidance = p.guidance;
        if (p.coursework_theme != null)
            this.coursework_theme = p.coursework_theme;
        if (p.bibliography != null)
            this.bibliography = p.bibliography;
        if (p.periodicals != null)
            this.periodicals = p.periodicals;
        if (p.teaching_materials != null)
            this.teaching_materials = p.teaching_materials;
        if (p.databases != null)
            this.databases = p.databases;
        if (p.lab_equipment != null)
            this.lab_equipment = p.lab_equipment;
        if (p.software != null)
            this.software = p.software;
        if (p.technical_means != null)
            this.technical_means = p.technical_means;
        if (p.lessonForms != null)
            this.lessonForms = p.lessonForms;
        if (p.teachers != null)
            this.teachers = p.teachers;
        if (p.chair_head != null)
            this.chair_head = p.chair_head;
        this.version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        /*
        this.subject = old.subject;
        this.status = old.status;
        this.learning_profile = old.learning_profile;
        //this.specialty = old.specialty;
        this.year = old.year;
        this.degree = old.degree;
        this.chair = old.chair;
        this.version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        this.subject_index = old.subject_index;
        this.semestrs = old.semestrs;
         */
    }


    private java.util.Set<Integer> getCourses(Integer[] semestrs) {
        java.util.Set set = new HashSet();
        for (Integer i : semestrs) {
            set.add((i + 1) / 2);
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
                //", specialty=" + specialty +
                ", year=" + year +
                ", degree='" + degree + '\'' +
                ", chair=" + chair +
                ", version=" + version +
                ", subject_index='" + subject_index + '\'' +
                ", semestrs=" + Arrays.toString(semesters) +
                ", study_form='" + study_form + '\'' +
                '}';
    }

/*
@JsonValue
@JsonRawValue
 public JSONObject toJson(){
        JSONObject json = new JSONObject();
        json.put("id", id);
        json.put("subject", subject.getName());
        json.put("specialty_code",learning_profile.getSpecialty().getCode());
        json.put("specialty",learning_profile.getSpecialty().getName());
        json.put("learning_profile",learning_profile.getName());
        json.put("study_form", study_form);
        json.put("year",year);
        json.put("last_edit",version.getLast_edit());
        json.put("creation_date",version.getCreation_date());
        json.put("status",status);
        json.put("index", subject_index);
        json.put("semestrs", semestrs);
        json.put("courses",getCourses(semestrs));
        return json;
    }

 */
}
