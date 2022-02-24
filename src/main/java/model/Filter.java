package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.List;
@JsonPropertyOrder({ "chair", "specialty", "degree", "year", "subject"})
public class Filter {
    List<String> chair;
    List<Integer> year;
    List<String> subject;
    List<String> specialty;
    List<String> degree;

    public Filter() {
    }

    public List<String> getChair() {
        return chair;
    }

    public void setChair(List<String> chair) {
        this.chair = chair;
    }

    public List<Integer> getYear() {
        return year;
    }

    public void setYear(List<Integer> year) {
        this.year = year;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<String> specialty) {
        this.specialty = specialty;
    }

    public List<String> getDegree() {
        return degree;
    }

    public void setDegree(List<String> degree) {
        this.degree = degree;
    }

/*
    @JsonValue
    @JsonRawValue
    public String toJson(){
        return "{\"chair\": \"" + chairs + "\",\n" +
                "\"specialty\": \"" + specialties +  "\",\n" +
                "\"degree\": \"" + degrees + "\",\n" +
                "\"year\": \"" + years + "\",\n" +
                "\"subject\": \"" + subjects + "\"" +
                "\n}";
    */
}
