package model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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
