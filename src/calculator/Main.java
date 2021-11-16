package calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try{
            System.out.println("Калькулятор должен иметь вид: \"Два операнда и один оператор\", "
                   +  "разделенные через пробелы. Допускаются числа от 1 до 10 или от I до X включительно. "
                    + "Доступные операторы: + - * /");
            System.out.print("Введите выражение: ");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calculatorString = bReader.readLine();

            Calculator calc = new Calculator();
            String result = calc.result(calculatorString);
            System.out.println("Ответ: " + result);
        }
        catch(Exception | IOException ignored){

        }

    }

}
