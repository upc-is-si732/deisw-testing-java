package pe.edu.upc.testing.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pe.edu.upc.testing.entity.Student;
import pe.edu.upc.testing.repository.StudentRepositoryImpl;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepositoryImpl studentRepository;

    @Test
    public void testBuscarPorIdMayorIgual20() {
        // Arrange
        Student expected = new Student(125, "Paterno", "Nombre5");
            // Mock
        Mockito.when( studentRepository.findById(Mockito.anyInt()) )
          .thenReturn( new Student(25, "Paterno", "Nombre") );

        // Act
        Student actual = studentService.buscarPorId(25);

        // Assert
        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());

        Mockito.verify(studentRepository, Mockito.times(1)).findById(Mockito.anyInt());

    }

    @Test
    public void testBuscarPorIdMenor20() {
        // Arrange
        Student expected = new Student(6, "Paterno2", "Nombre");
        // Mock
        Mockito.when( studentRepository.findById(Mockito.anyInt()) )
            .thenReturn( new Student(3, "Paterno", "Nombre") );

        // Act
        Student actual = studentService.buscarPorId(3);

        // Assert
        Assertions.assertEquals(expected.getId(),actual.getId());
        Assertions.assertEquals(expected.getLastName(),actual.getLastName());
        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());

        Mockito.verify(
                studentRepository,
                Mockito.times(1)
        ).findById(Mockito.anyInt());

    }
}








