package pe.edu.upc.testing.service;

import lombok.AllArgsConstructor;
import pe.edu.upc.testing.entity.Student;
import pe.edu.upc.testing.repository.StudentRepository;

@AllArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;


    @Override
    public Student buscarPorId(Integer id) {
        Student student = studentRepository.findById(id);
        if (student.getId() < 20) {
            student.setId(student.getId() * 2);
            student.setLastName(student.getLastName() + "2");
        } else {
            student.setId(student.getId() * 5);
            student.setFirstName(student.getFirstName() + "5");
        }
        return student;
    }
}



