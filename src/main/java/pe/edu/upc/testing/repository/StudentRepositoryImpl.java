package pe.edu.upc.testing.repository;

import pe.edu.upc.testing.entity.Student;
import pe.edu.upc.testing.util.StudentValidator;

public class StudentRepositoryImpl implements StudentRepository{
    @Override
    public Student findById(Integer id) {
        StudentValidator.validateStudentId(id);
        return new Student(id, "Paterno", "Nombre");
    }
}
