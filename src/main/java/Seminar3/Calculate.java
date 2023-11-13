package Seminar3;

public class Calculate {

    public <T extends Number, S extends Number > double sum(T num1, S num2) {
        return num1.doubleValue() + num2.doubleValue();
    }


    public <T extends Number, S extends Number > double multiply(T num1, S num2) {
return num1.doubleValue() * num2.doubleValue();
    }


    public <T extends Number, S extends Number > double divide(T num1, S num2) throws ArithmeticException {
        if (num2.doubleValue() == 0.0 ){
            throw new ArithmeticException("Деление на ноль");
        }

        return num1.doubleValue() / num2.doubleValue();
    }


    public<T extends Number, S extends Number > double subtract(T num1, S num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
