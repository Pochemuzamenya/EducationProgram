package org.isu.rpd.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class NewProgramJSON {
    private List<Subject> subjects;
    private List<Specialty> specialties;
    private List<LearningProfile> learning_profiles;
    private List<Chair> chairs;
    private List<Degree> degrees;
    private List<StudyForm> studyForms;

    public NewProgramJSON() {
    }

}
