package model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Program implements Cloneable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @Column
    private String status;
    @ManyToOne
    @JoinTable(name = "lesson_plans_programs",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "lesson_plan_id")})
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
    @OneToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "programs_competences",
            joinColumns = {@JoinColumn(name = "program_id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id")})
    private List<Competence> competences;
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

    @Override
    public Program clone() throws CloneNotSupportedException {
        return (Program) super.clone();
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
