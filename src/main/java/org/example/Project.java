package org.example;
public class Project{
    private String expression;

    public Project(String expr) {
        this.expression = expr; // Инициализация выражения
    }

    public int calculation() throws Exception {
        String[] exprs = expression.split(","); // Разделяем выражение по запятой
        int[] operands = new int[exprs.length]; // Массив для хранения операндов
        int count = 0; // Счетчик операндов

        for (String token : exprs) {
            if (isOperator(token)) {
                // Проверяем, есть ли достаточно операндов для выполнения операции
                if (count < 2) {
                    throw new Exception("Expression error");
                }

                // Берем последние два операнда из массива
                int op2 = operands[--count]; // Второй операнд
                int op1 = operands[--count]; // Первый операнд
                // Выполняем вычисление и сохраняем результат обратно в массив
                operands[count++] = doCalculation(op1, op2, token);
            } else {
                // Если это число, добавляем его в массив
                operands[count++] = Integer.parseInt(token);
            }
        }

        // Возвращаем последний элемент как результат вычисления
        return operands[0];
    }

    private boolean isOperator(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/");
    }

    private int doCalculation(int op1, int op2, String operator) {
        switch (operator) {
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                return op1 / op2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
