package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CheckoutPage {

    //==================================================================================================================
    //                                          Página Checkout | CADASTRO
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By firstName = By.cssSelector("#first-name");
    public static final By lastName = By.cssSelector("#last-name");
    public static final By zipCode = By.cssSelector("#postal-code");
    public static final By continueBtn = By.cssSelector("#continue");

    public static final By msgCheckout = By.cssSelector("#header_container > div.header_secondary_container > span");
    public static final By msgCheckoutError = By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3");

    //==================================================================================================================

    // MÉTODOS:

    // Dados válidos:
    public void preencherFirstName() {
        BaseTest.sendKeys(firstName, "Coraline");
    }

    public void preencherLastName() {
        BaseTest.sendKeys(lastName, "Jones");
    }

    public void preencherZipCode() {
        BaseTest.sendKeys(zipCode, "12345");
    }

    // Dados inexistentes:
    public void preencherFirstNameVazio() {
        BaseTest.sendKeys(firstName, "");
    }

    public void preencherLastNameVazio() {
        BaseTest.sendKeys(lastName, "");
    }

    public void preencherZipCodeVazio() {
        BaseTest.sendKeys(zipCode, "");
    }

    // Botão:
    public void clicarContinueBtn() {
        BaseTest.click(continueBtn);
    }

    // Validações:
    public String validarCheckoutComSucesso() {
        return BaseTest.getText(msgCheckout);
    }

    public String validarCheckoutSemSucesso() {
        return BaseTest.getText(msgCheckoutError);
    }

}
