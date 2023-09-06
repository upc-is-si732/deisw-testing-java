package pe.edu.upc.testing.util;

public class StudentValidator {
  public static boolean validateStudentId(Integer id) {
    if (id == null) {
      throw new NullPointerException("Is Null");
    }
    else if (id <= 0) {
      throw new IllegalArgumentException("No hay Id");
    }
    // Happy Path
    return true;
  }

}
