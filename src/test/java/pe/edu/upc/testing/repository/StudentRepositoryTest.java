package pe.edu.upc.testing.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.testing.entity.Student;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {

    @InjectMocks
    private StudentRepositoryImpl studentRepository;

    @Test
    @DisplayName("Test for find by Id from student")
    public void testFindById() {
        Student espero = new Student(12, "Paterno", "Nombre");

        Student recibo = studentRepository.findById(12);
        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());
    }

    @Test
    @DisplayName("Test for find by Id from student is Less Zero")
    public void testFindByIdIsLessZero() {
        Integer id = -2;
        IllegalArgumentException illegalArgumentException
            = Assertions.assertThrows(IllegalArgumentException.class,
                () -> studentRepository.findById(id));

        Assertions.assertEquals("No hay Id", illegalArgumentException.getMessage());
    }
    @Test
    @DisplayName("Test for find by Id from student is Null")
    public void testFindByIdIsNull() {
        NullPointerException nullPointerException
            = Assertions.assertThrows(NullPointerException.class,
                () -> studentRepository.findById(null));

        Assertions.assertEquals("Is Null", nullPointerException.getMessage());
    }
}
