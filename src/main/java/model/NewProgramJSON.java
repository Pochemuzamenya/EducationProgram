package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
public class NewProgramJSON {
    private List<Subject> subjects;
    private List<Specialty> specialties;
    private List<LearningProfile> learning_profiles;
    private List<Chair> chairs;

    public NewProgramJSON() {
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    public List<LearningProfile> getLearning_profiles() {
        return learning_profiles;
    }

    public void setLearning_profiles(List<LearningProfile> learning_profiles) {
        this.learning_profiles = learning_profiles;
    }

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
