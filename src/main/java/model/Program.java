package model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    private LessonPlan lesson_plan;
    @ManyToOne
    private Chair chair;
    /*@OneToOne
    private Version version;*/
    private String index;
    @Column
    private String purpose;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_tasks",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "task_id")})
    private List<Task> tasks;
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
    /*@ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_competences",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private List<Competence> competences;*/
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
    @Column
    private Integer contact_hours;
    @Column
    private Integer lectures;
    @Column
    private Integer lab_work;
    @Column
    private Integer practical_work;
    @Column
    private Integer seminar;
    @Column
    private Integer tactical_work;
    @Column
    private Integer military_work;
    @Column
    private Integer methodical_work;
    @Column
    private Integer conference;
    @Column
    private Integer audience;
    @Column
    private Integer consultation;
    @Column
    private Integer ko;
    @Column
    private Integer ind_work;
    @Column
    private Integer control;
    /*@ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_subsections",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "subsection_id")})
    private List<Subsection> subsections;*/
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_semesters",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "semester_id")})
    private List<Semester> semesters;
    @Column
    private String guidance;
    @Column
    private Boolean has_coursework;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_courseworks",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "coursework_id")})
    private List<Coursework> courseworks;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_books",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "source_id")})
    private List<Source> books;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_add_books",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "source_id")})
    private List<Source> addBooks;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_periodicals",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "source_id")})
    private List<Source> periodicals;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_databases",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "source_id")})
    private List<Source> databases;
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_meth_works",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "source_id")})
    private List<Source> methWorks;
    @Column
    private String lab_equipment;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_equipment",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "equipment_id")})
    private List<Equipment> equipment;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_software",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "software_id")})
    private List<Software> software;
    @Column
    private String educational_tech;
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
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp creation_date;
    @Column
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Timestamp last_edit;
    public Program() {
    }


    public void copyParameters(Program p) {
        if (p.subject != null)
            this.subject = p.subject;
        if (p.status != null)
            this.status = p.status;
        if (p.lesson_plan != null)
            this.lesson_plan = p.lesson_plan;
        if (p.chair != null)
            this.chair = p.chair;
        if (p.index != null)
            this.index = p.index;
        if (p.purpose != null)
            this.purpose = p.purpose;
        if (p.tasks != null)
            this.tasks = p.tasks;
        if (p.subjects_before != null)
            this.subjects_before = p.subjects_before;
        if (p.subjects_after != null)
            this.subjects_after = p.subjects_after;
        if (p.hours != null)
            this.hours = p.hours;
        if (p.exam_hours != null)
            this.exam_hours = p.exam_hours;
        if (p.credits != null)
            this.credits = p.credits;
        if (p.certification_form != null)
            this.certification_form = p.certification_form;
        if (p.contact_hours != null)
            this.contact_hours = p.contact_hours;
        if (p.lectures != null)
            this.lectures = p.lectures;
        if (p.lab_work != null)
            this.lab_work = p.lab_work;
        if (p.practical_work != null)
            this.practical_work = p.practical_work;
        if (p.seminar != null)
            this.seminar = p.seminar;
        if (p.tactical_work != null)
            this.tactical_work = p.tactical_work;
        if (p.military_work != null)
            this.military_work = p.military_work;
        if (p.methodical_work != null)
            this.methodical_work = p.methodical_work;
        if (p.conference != null)
            this.conference = p.conference;
        if (p.audience != null)
            this.audience = p.audience;
        if (p.consultation != null)
            this.consultation = p.consultation;
        if (p.ko != null)
            this.ko = p.ko;
        if (p.ind_work != null)
            this.ind_work = p.ind_work;
        if (p.control != null)
            this.control = p.control;
        if (p.exam_credits != null)
            this.exam_credits = p.exam_credits;
        if (p.semesters != null)
            this.semesters = p.semesters;
        if (p.guidance != null)
            this.guidance = p.guidance;
        if (p.has_coursework != null)
            this.has_coursework = p.has_coursework;
        if (p.courseworks != null)
            this.courseworks = p.courseworks;
        if (p.books != null)
            this.books = p.books;
        if (p.addBooks != null)
            this.addBooks = p.addBooks;
        if (p.periodicals != null)
            this.periodicals = p.periodicals;
        if (p.methWorks != null)
            this.methWorks = p.methWorks;
        if (p.databases != null)
            this.databases = p.databases;
        if (p.lab_equipment != null)
            this.lab_equipment = p.lab_equipment;
        if (p.equipment != null)
            this.equipment = p.equipment;
        if (p.software != null)
            this.software = p.software;
        if (p.educational_tech != null)
            this.educational_tech = p.educational_tech;
        if (p.lessonForms != null)
            this.lessonForms = p.lessonForms;
        if (p.teachers != null)
            this.teachers = p.teachers;
        if (p.entrance_certification!=null)
            this.entrance_certification = p.entrance_certification;
        if (p.current_certification != null)
            this.current_certification = p.current_certification;
        if (p.mid_certification != null)
            this.mid_certification = p.mid_certification;
        //this.version.setLast_edit(new Timestamp(System.currentTimeMillis()));
        this.setLast_edit(new Timestamp(System.currentTimeMillis()));
    }


    private java.util.Set<Integer> getCourses(Integer[] semestrs) {
        java.util.Set set = new HashSet();
        for (Integer i : semestrs) {
            set.add((i + 1) / 2);
        }
        return set;
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
