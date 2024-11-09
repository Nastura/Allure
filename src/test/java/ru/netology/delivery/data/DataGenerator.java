package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {

    }

    public static String generateDate(int shift) {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate date = today.plusDays(shift);
        return date.format(formatter);
    }

    public static String generateCity(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String city = faker.address().city();
        String[] sityy = new String[]{
                "Ярославль", "Якутск", "Южно-Сахалинск", "Элиста", "Чита", "Челябинск", "Чебоксары", "Херсон",
                "Ханты-Мансийск", "Хабаровск", "Уфа", "Ульяновск", "Улан-Удэ", "Тюмень", "Тула", "Томск", "Тверь",
                "Тамбов", "Сыктывкар", "Ставрополь", "Смоленск", "Симферополь", "Севастополь", "Саратов", "Саранск",
                "Санкт-Петербург", "Самара", "Салехард", "Рязань", "Ростов-на-Дону", "Псков", "Петропавловск-Камчатский", "Петрозаводск",
                "Пермь", "Пенза", "Оренбург", "Орёл", "Омск", "Новосибирск", "Нижний Новгород", "Нарьян-Мар", "Нальчик", "Мурманск", "Москва", "Москва",
                "Мелитополь", "Махачкала", "Майкоп", "Магас", "Магадан", "Луганск", "Липецк", "Кызыл",
                "Курск", "Курган", "Красноярск", "Краснодар", "Кострома", "Киров", "Кемерово", "Калуга",
                "Калининград", "Казань", "Йошкар-Ола", "Иркутск", "Ижевск", "Иваново", "Екатеринбург", "Донецк",
                "Грозный", "Воронеж", "Вологда", "Волгоград", "Владимир", "Владикавказ", "Владивосток", "Великий Новгород",
                "Брянск", "Благовещенск", "Биробиджан", "Белгород"
        };

        return sityy[new Random().nextInt(sityy.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().lastName() + " " + faker.name().firstName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        System.out.println(phone);
        return phone;

    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(
                    generateCity(locale),
                    generateName(locale),
                    generatePhone(locale)
            );

            return user;
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }

    }


}
