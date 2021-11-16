package calculator;

    public class Exception extends java.lang.Exception {
        public Exception() {
            System.out.println("Неверно задано выражение");
        }

        public Exception(String message){
            this();
            System.out.println(message);
        }
    }

