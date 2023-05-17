package pe.edu.upc.testing.repository;

import pe.edu.upc.testing.entity.Student;

public interface StudentRepository {
    Student findById(Integer id);
}
