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
    public void testBuscarPorId() {
        Student espero = new Student(125, "Paterno", "Nombre");
        Mockito.when( studentRepository.findById(Mockito.anyInt()) )
          .thenReturn( new Student(25, "Paterno", "Nombre") );

        Student recibo = studentService.buscarPorId(25);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());

        Mockito.verify(studentRepository, Mockito.times(1)).findById(Mockito.anyInt());

    }
    @Test
    public void testBuscarPorIdMenor20() {
        Student espero = new Student(6, "Paterno", "Nombre");
        Mockito.when( studentRepository.findById(Mockito.anyInt()) )
                .thenReturn( new Student(3, "Paterno", "Nombre") );

        Student recibo = studentService.buscarPorId(3);

        Assertions.assertEquals(espero.getId(),recibo.getId());
        Assertions.assertEquals(espero.getLastName(),recibo.getLastName());
        Assertions.assertEquals(espero.getFirstName(),recibo.getFirstName());

        Mockito.verify(
                studentRepository,
                Mockito.times(1)
        ).findById(Mockito.anyInt());

    }
}








