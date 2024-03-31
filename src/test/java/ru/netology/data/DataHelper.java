package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;


import java.time.LocalDate;
import java.util.Locale;


public class DataHelper {

    private DataHelper() {
    }


    private static Faker faker = new Faker(new Locale("ru"));

    public static CardInfo getFirstCardNumberAndStatus() {
        return new CardInfo("1111 2222 3333 4444", "APPROVED");
    }

    public static CardInfo getSecondCardNumberAndStatus() {
        return new CardInfo("5555 6666 7777 8888", "DECLINED");
    }

    public static LocalDate generateValidDate() {
        return LocalDate.now().plusMonths(13);
    }

    public static String generateRandomMonth() {
        String text = String.valueOf((generateValidDate()));
        char charAtFive = text.charAt(5);
        char charAtSix = text.charAt(6);
        return charAtFive + String.valueOf(charAtSix);
    }

    public static String generateRandomYear() {
        String text = String.valueOf((generateValidDate()));
        char charAtTwo = text.charAt(2);
        char charAtThree = text.charAt(3);
        return charAtTwo + String.valueOf(charAtThree);
    }

    public static String generateFullName() {
        return faker.name().firstName().replaceAll("ё", "е") + " "
                + faker.name().lastName().replaceAll("ё", "е");
    }

    public static String generateCvc() {
        return faker.number().digits(3);
    }

    public static String generateCardNumber() {
        return faker.business().creditCardNumber();
    }


    @Value
    public static class CardInfo {
        private String cardNumber;
        private String status;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserData {

        public String cardNumber;
        private String month;
        private String year;
        private String nameSurname;
        private String cvc;

    }

    @Value
    public static class SQL {
        private String cardNumber;
        private String status;
    }

}