package pe.edu.upc.testing.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private Integer id;
    private String lastName;
    private String firstName;
}
