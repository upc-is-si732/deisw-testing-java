package pe.edu.upc.testing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Course {
    private Integer id;
    private String name;
    private String level;
    private float credit;
}
