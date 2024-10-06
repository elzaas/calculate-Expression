import static org.junit.jupiter.api.Assertions.*;
import org.example.Project;
import org.junit.jupiter.api.Test;

public class ProjectTest {

    // Тестирование сложения двух чисел
    @Test
    public void testAddition() throws Exception {
        Project rpn = new Project("2,3,+"); // Создаем объект с выражением "2,3,+"
        // Проверяем, что результат равен 5
        assertEquals(5, rpn.calculation(), "2 + 3 should equal 5");
    }

    // Тестирование вычитания
    @Test
    public void testSubtraction() throws Exception {
        Project rpn = new Project("5,3,-"); // Создаем объект с выражением "5,3,-"
        // Проверяем, что результат равен 2
        assertEquals(2, rpn.calculation(), "5 - 3 should equal 2");
    }

    // Тестирование умножения
    @Test
    public void testMultiplication() throws Exception {
        Project rpn = new Project("4,5,*"); // Создаем объект с выражением "4,5,*"
        // Проверяем, что результат равен 20
        assertEquals(20, rpn.calculation(), "4 * 5 should equal 20");
    }

    // Тестирование деления
    @Test
    public void testDivision() throws Exception {
        Project rpn = new Project("10,2,/"); // Создаем объект с выражением "10,2,/":
        // Проверяем, что результат равен 5
        assertEquals(5, rpn.calculation(), "10 / 2 should equal 5");
    }

    // Тестирование сложного выражения
    @Test
    public void testComplexExpression() throws Exception {
        Project rpn = new Project("2,3,+,4,*"); // Создаем объект с выражением "(2 + 3) * 4"
        // Проверяем, что результат равен 20
        assertEquals(20, rpn.calculation(), "(2 + 3) * 4 should equal 20");
    }

    // Тестирование ошибки при недостаточном количестве операндов
    @Test
    public void testErrorOnInsufficientOperands() {
        Project rpn = new Project("1,+"); // Создаем объект с выражением "1,+"
        // Проверяем, что выбрасывается исключение
        Exception exception = assertThrows(Exception.class, () -> {
            rpn.calculation();
        });

        String expectedMessage = "Expression error"; // Ожидаемое сообщение об ошибке
        String actualMessage = exception.getMessage(); // Получаем фактическое сообщение об ошибке

        // Проверяем, что фактическое сообщение содержит ожидаемое
        assertTrue(actualMessage.contains(expectedMessage));
    }

    // Тестирование некорректного выражения
    @Test
    public void testInvalidExpression() {
        Project rpn = new Project("1,2,+,3,+,/"); // Создаем объект с некорректным выражением
        // Проверяем, что выбрасывается исключение
        Exception exception = assertThrows(Exception.class, () -> {
            rpn.calculation();
        });

        String expectedMessage = "Expression error"; // Ожидаемое сообщение об ошибке
        String actualMessage = exception.getMessage(); // Получаем фактическое сообщение об ошибке

        // Проверяем, что фактическое сообщение содержит ожидаемое
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
