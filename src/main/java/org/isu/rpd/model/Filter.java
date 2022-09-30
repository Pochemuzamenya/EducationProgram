package org.isu.rpd.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@JsonPropertyOrder({ "chair", "specialty", "degree", "year", "subject"})
@Getter
@Setter
@ToString
public class Filter {
    List<String> chair;
    List<Integer> year;
    List<String> subject;
    List<String> specialty;
    List<String> degree;

    public Filter() {
    }

}
