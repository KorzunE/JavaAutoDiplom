package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.MainPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayCreditTest {

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    void shouldSuccessPayAppCard() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.validPayCard(CardInfo);
        PaymentPage.verifySuccessPayVisibility();
    }

    @Test
    void shouldShowErrorDecCard() {
        var CardInfo = DataHelper.getSecondCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.validPayCard(CardInfo);
        PaymentPage.verifyDeclinePayVisibility();
    }


    @Test
    void shouldSuccessРayСreditAppCard() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var CreditPage = MainPage.openCreditPage(CardInfo);
        CreditPage.validPayCard(CardInfo);
        CreditPage.verifySuccessPayVisibility();
    }

    @Test
    void shouldShowErrorPayDecCard() {
        var CardInfo = DataHelper.getSecondCardNumberAndStatus();
        var CreditPage = MainPage.openCreditPage(CardInfo);
        CreditPage.validPayCard(CardInfo);
        CreditPage.verifyDeclinePayVisibility();
    }


    @Test
    void shouldShowErrorEmptyCardNumber() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.emptyField(CardInfo);
        PaymentPage.verifyEmptyField();
    }

    @Test
    void shouldErrorEmptyCreditCardField() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var CreditPage = MainPage.openCreditPage(CardInfo);
        CreditPage.emptyField(CardInfo);
        CreditPage.verifyEmptyField();
    }

    @Test
    void shouldErrorInvalidCardNumber() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.inValidPayCard(CardInfo);
        PaymentPage.verifyDeclinePayVisibility();
    }

    @Test
    void shouldErrorInvalidCreditCardNumber() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var CreditPage = MainPage.openCreditPage(CardInfo);
        CreditPage.inValidPayCard(CardInfo);
        CreditPage.verifyDeclinePayVisibility();
    }

    @Test
    void shouldGetMySQLStatusAppCard() {
        var CardInfo = DataHelper.getFirstCardNumberAndStatus();
        var PaymentPage = MainPage.openPaymentPage(CardInfo);
        PaymentPage.validPayCard(CardInfo);
        String PaymentStatus;
        PaymentStatus = SQLHelper.getLastPayUserStatusMySQL();
        assertEquals("APPROVED", PaymentStatus);

    }

}