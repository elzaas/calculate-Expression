import static org.junit.jupiter.api.Assertions.*;
import org.example.Project;
import org.junit.jupiter.api.Test;

public class ProjectTest {

    // Тестирование сложения двух чисел
    @Test
    public void testAddition() throws Exception {
        assertEquals(5, new Project("2,3,+").calculation(), "2 + 3 should equal 5");
        assertEquals(10, new Project("7,3,+").calculation(), "7 + 3 should equal 10");
        assertEquals(0, new Project("5,-5,+").calculation(), "5 + -5 should equal 0");
        assertEquals(100, new Project("60,40,+").calculation(), "60 + 40 should equal 100");
        assertEquals(15, new Project("10,5,+").calculation(), "10 + 5 should equal 15");
    }

    // Тестирование вычитания
    @Test
    public void testSubtraction() throws Exception {
        assertEquals(2, new Project("5,3,-").calculation(), "5 - 3 should equal 2");
        assertEquals(4, new Project("10,6,-").calculation(), "10 - 6 should equal 4");
        assertEquals(-1, new Project("3,4,-").calculation(), "3 - 4 should equal -1");
        assertEquals(50, new Project("100,50,-").calculation(), "100 - 50 should equal 50");
        assertEquals(0, new Project("5,5,-").calculation(), "5 - 5 should equal 0");
    }

    // Тестирование умножения
    @Test
    public void testMultiplication() throws Exception {
        assertEquals(20, new Project("4,5,*").calculation(), "4 * 5 should equal 20");
        assertEquals(50, new Project("10,5,*").calculation(), "10 * 5 should equal 50");
        assertEquals(0, new Project("0,100,*").calculation(), "0 * 100 should equal 0");
        assertEquals(100, new Project("10,10,*").calculation(), "10 * 10 should equal 100");
        assertEquals(-12, new Project("-3,4,*").calculation(), "-3 * 4 should equal -12");
    }

    // Тестирование деления
    @Test
    public void testDivision() throws Exception {
        assertEquals(5, new Project("10,2,/").calculation(), "10 / 2 should equal 5");
        assertEquals(3, new Project("9,3,/").calculation(), "9 / 3 should equal 3");
        assertEquals(1, new Project("5,5,/").calculation(), "5 / 5 should equal 1");
        assertEquals(-2, new Project("-8,4,/").calculation(), "-8 / 4 should equal -2");
        assertEquals(0, new Project("0,5,/").calculation(), "0 / 5 should equal 0");
    }

    // Тестирование сложного выражения
    @Test
    public void testComplexExpression() throws Exception {
        assertEquals(20, new Project("2,3,+,4,*").calculation(), "(2 + 3) * 4 should equal 20");
        assertEquals(50, new Project("5,5,+,5,*").calculation(), "(5 + 5) * 5 should equal 15");
        assertEquals(25, new Project("2,3,+,5,*").calculation(), "(2 + 3) * 5 should equal 25");
        assertEquals(14, new Project("3,4,+,2,*").calculation(), "(3 + 4) * 2 should equal 14");
        assertEquals(25, new Project("10,2,/,5,*").calculation(), "(10 / 2) * 5 should equal 25");
    }

    // Тестирование ошибки при недостаточном количестве операндов
    @Test
    public void testErrorOnInsufficientOperands() {
        Project rpn = new Project("1,+"); // Создаем объект с выражением "1,+"
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
        Exception exception = assertThrows(Exception.class, () -> {
            rpn.calculation();
        });

        String expectedMessage = "Expression error"; // Ожидаемое сообщение об ошибке
        String actualMessage = exception.getMessage(); // Получаем фактическое сообщение об ошибке

        // Проверяем, что фактическое сообщение содержит ожидаемое
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
