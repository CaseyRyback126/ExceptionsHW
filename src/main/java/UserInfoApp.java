import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UserInfoApp {
    public static void main(String[] args) {
        try {
            // Запрос данных у пользователя
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в формате:" +
                    "Фамилия Имя Отчество дата_рождения номер_телефона пол");
            String inputData = scanner.nextLine();

            // Разбиение строки на массив значений
            String[] values = inputData.split(" ");

            // Проверка количества значений
            if (values.length != 6) {
                throw new IllegalArgumentException("Неверное количество значений");
            }

            // Парсинг значений
            String surname = values[0];
            if (!surname.matches("^[a-zA-Zа-яА-Я]+$")) {
                throw new IllegalArgumentException("В фамилии присутствуют цифры или символы");
            }
            String name = values[1];
            if (!name.matches("^[a-zA-Zа-яА-Я]+$")) {
                throw new IllegalArgumentException("В имени присутствуют цифры или символы");
            }
            String patronymic = values[2];
            if (!patronymic.matches("^[a-zA-Zа-яА-Я]+$")) {
                throw new IllegalArgumentException("В отчестве присутствуют цифры или символы");
            }
            LocalDate birthdate = LocalDate.parse(values[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            long phoneNumber;
            try {
                phoneNumber = Long.parseLong(values[4]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Ошибка формата номера телефона: " + e.getMessage());
            }

            char gender = values[5].charAt(0);
            if (gender != 'м' && gender != 'ж') {
                throw new IllegalArgumentException("Пол должен быть м или ж");
            }

            // Запись данных в файл
            try (BufferedWriter writer = new BufferedWriter
                    (new FileWriter(surname + ".txt", true))) {
                writer.write(surname + " " +
                        name + " " +
                        patronymic + " " +
                        birthdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " +
                        phoneNumber + " " +
                        gender);
                writer.newLine();
            } catch (IOException e) {
                System.err.println("Ошибка записи в файл: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (DateTimeParseException e) {
            System.err.println("Ошибка формата даты: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Неизвестная ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
