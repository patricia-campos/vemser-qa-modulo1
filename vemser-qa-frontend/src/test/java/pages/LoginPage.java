package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {

    //==================================================================================================================
    //                                          Página Login | LOGIN
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By username = By.cssSelector("#user-name");
    public static final By password = By.cssSelector("#password");
    public static final By loginBtn = By.cssSelector("#login-button");

    // Validações:
    public static final By msgLoginEfetuado = By.cssSelector("#header_container > div.header_secondary_container > span");
    public static final By msgLoginIncorreto = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");


    //==================================================================================================================

    // MÉTODOS:

    // Preencher com dados válidos:
    public void preencherUsernameCorreto() {
        BaseTest.sendKeys(username, "standard_user");
    }

    public void preencherPasswordCorreto() {
        BaseTest.sendKeys(password, "secret_sauce");
    }

    // Preencher com dados incorretos:
    public void preencherUsernameIncorreto() {
        BaseTest.sendKeys(username, "UsernameIncorreto");
    }

    public void preencherPasswordIncorreto() {
        BaseTest.sendKeys(password, "PasswordIncorreto");
    }

    // Dados vazio:
    public void preencherUsernameVazio() {
        BaseTest.sendKeys(username, "");
    }

    public void preencherPasswordVazio() {
        BaseTest.sendKeys(password, "");
    }

    // Efetuar Login:
    public void clicarLoginBtn() {
        BaseTest.click(loginBtn);
    }

    // Validações:
    public String validarLoginComSucesso() {
        return BaseTest.getText(msgLoginEfetuado);
    }

    public String validarLoginSemSucesso() {
        return BaseTest.getText(msgLoginIncorreto);
    }

}
