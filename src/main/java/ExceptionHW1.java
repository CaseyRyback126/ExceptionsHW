public class ExceptionHW1 {
    public static void main(String[] args) {
        String[][] arr = {{"1", "2"}, {"3", "4"}, {"1", "6"}};
        System.out.println(sum2d(arr));
    }

    //Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
    public static int divideByZero() {
        int a = 9;
        int b = 0;
        return a / b; // генерирует исключение при попытке делить на 0
    }

    public static int accessOutOfBounds() {
        int[] arr = new int[5];
        return arr[10];
        // генерирует исключение при попытке обратиться к элементу, находящемуся за пределами массива
    }

    public static void typeCast() {
        //Object x = new Integer(0);
        //System.out.println((String) x);
        // генерирует исключение при попытке привести объект к некорректному типу
    }

    //Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) { //NullPointerException
            for (int j = 0; j < 2; j++) { //выход за границы массива
                int val = Integer.parseInt(arr[i][j]); //ошибка парсинга
                sum += val;
            }
        }
        return sum;
    }

    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    //и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух входящих массивов в той же ячейке.
    // Если длины массивов не равны, необходимо как-то оповестить пользователя.

    public static int[] diffArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            System.out.println("Длины массивов не равны");
            return null;
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] - arr2[i];
        }
        return result;
    }

    //Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо как-то оповестить пользователя.
    // Важно: При выполнении метода единственное исключение,
    // которое пользователь может увидеть - RuntimeException, т.е. ваше.

    public static int[] divideArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Arrays have different lengths.");
        }

        int[] result = new int[arr1.length];

        for (int i = 0; i < arr1.length; i++) {
            try {
                result[i] = arr1[i] / arr2[i];
            } catch (ArithmeticException e) {
                throw new RuntimeException("Division by zero in array element.");
            }
        }

        return result;
    }

}
