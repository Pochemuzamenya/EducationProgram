package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class ResponseJSON {
    Filter filters;
    List<Program> subjects;

    public ResponseJSON(List<Program> subjects,Filter filters) {
        this.subjects = subjects;
        this.filters = filters;
    }

    public ResponseJSON() {
    }
}
