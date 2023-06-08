import java.util.Scanner;

public class ExceptionHW2 {
    public static void main(String[] args) {
        readFloat();
        nullStringInput();
    }

    // Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
    // и возвращает введенное значение. Ввод текста вместо числа не должен приводить
    // к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

    public static void readFloat() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите дробное число: ");
            try {
                String input = scanner.nextLine();
                System.out.println(Float.parseFloat(input));
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Некорректный ввод. Попробуйте ещё раз.");
            }
        }
    }

    //Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
    //Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    public static void nullStringInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) try {
            System.out.print("Введите строку: ");
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                throw new Exception("Вы ввели пустую строку");
            }
            System.out.println("Вы ввели: " + input);
            break;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //Задание 2 Если необходимо, исправьте данный код
       /*
       try {
        int d = 0;
        double catchedRes1 = intArray[8] / d;
        System.out.println("catchedRes1 = " + catchedRes1);
    } catch (ArithmeticException e) {
        System.out.println("Catching exception: " + e);
    }
      */
    public static void correctedCode() {
        int[] intArray = {0, 1, 2, 3, 4, 5, 6, 1, 8, 9};


        int d = 1;
        if (intArray.length - 1 < 8) {
            System.out.println("Массив содержит недостаточно элементов");
        } else if (d == 0) {
            System.out.println("Деление на 0");
        } else {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }

    }

    //Задание 3 Дан следующий код, исправьте его там, где требуется
    /*
    public static void main(String[] args) throws Exception {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = {1, 2};
            abc[3] = 9;
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        }
    }

    public static void printSum(Integer a, Integer b) throws FileNotFoundException {
        System.out.println(a + b);
    }
    */
    public static void repairedCode() {
        int a = 90;
        int b = 3;
        if (b != 0) {
            System.out.println(a / b);
        }

        printSum(23, 234);
        int[] abc = {1, 2};
        if (3 < abc.length) abc[3] = 9;
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}


