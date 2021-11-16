package calculator;

import java.util.Arrays;
import java.util.List;


    public class Calculator {
        private int a;
        private int b;  //числа в выражении
        private String operatorInExpression; //оператор в выражении, допускается: + - * /

        //выполнение арифметического выражения (только целые числа в ответе)
        private int calcExp(int a, String operatorInExpression, int b){
            this.a = a;
            this.operatorInExpression = operatorInExpression;
            this.b = b;
            int result;
            if ("+".equals(operatorInExpression)) {
                result = a + b;
            } else if ("-".equals(operatorInExpression)) {
                result = a - b;
            } else if ("*".equals(operatorInExpression)) {
                result = a * b;
            } else if ("/".equals(operatorInExpression)) {
                result = a / b;
            } else {
                throw new AssertionError();
            }
            return result;
        }

        //public метод с проверками и с выводом результата
        public String result(String exp) throws Exception {
            boolean isRomanExp;  //Признак, что числа римские
            Transformation parse = new Transformation();

            //разбиваем исходное выражение String по разделителю " "
            List<String> expItems = Arrays.asList(exp.split(" "));

            //проверка, что создалось 3 элемента: первый операнд, оператор, второй операнд, иначе исключение
            if (expItems.size()!=3){
                throw new Exception("Throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }

            //проверка оператора, верные операторы: + - * /
            if (parse.checkOperator(expItems.get(1))){
                operatorInExpression = expItems.get(1);
            } else {
                throw new Exception("Throws Exception //оператор '" + expItems.get(1) + "' некорректный, верные оперторы: + - * / ");
            }

            //проверка операнд, должны быть от 1 до 10 включительно
            if ((a>=1 && a<=10)){
                throw new Exception("Throws Exception // Первый операнд должен быть от 1 до 10 или от I до X включительно");
            }

            if ((b>=1 && b<=10)){
                throw new Exception("Throws Exception // Второй операнд должен быть от 1 до 10 или от I до X включительно");
            }


            //проверка операнд, должны быть одинаковой системы счисления
            if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))){    //проверяем, что оба числа арабские
                a = Integer.parseInt(expItems.get(0));
                b = Integer.parseInt(expItems.get(2));
                isRomanExp = false;
            } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))){ //проверяем, что оба числа римские
                a = parse.romeToArabConvert(expItems.get(0));
                b = parse.romeToArabConvert(expItems.get(2));
                isRomanExp = true;
            } else {    //числа не соответствуют
                throw new Exception("Throws Exception //т.к. используются одновременно разные системы счисления");
            }


            //получаем результат
            int result = calcExp(a, operatorInExpression, b);

            //если числа римские, то конвертируем в римские и возвращаем результат
            if (isRomanExp){
                String sign = result < 0 ? "-" : "";
                return sign + parse.arabToRomeConvert(Math.abs(result));
            }

            //возвращаем ответ - арабское число
            return String.valueOf(result);
        }

    }

