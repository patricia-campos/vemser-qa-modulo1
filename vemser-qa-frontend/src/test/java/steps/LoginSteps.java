package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import util.Browser;

public class LoginSteps extends Browser {

    LoginPage loginPage = new LoginPage();

    //==================================================================================================================
    //                                                 LOGIN
    //==================================================================================================================

    // LOGIN COM SUCESSO:
    @Test
    public void logarComSucesso() {

        loginPage.preencherUsernameCorreto();
        loginPage.preencherPasswordCorreto();
        loginPage.clicarLoginBtn();

        // Validação:
        Assert.assertEquals(loginPage.validarLoginComSucesso(), "PRODUCTS");
    }

    //==================================================================================================================

    // LOGIN SEM SUCESSO | Username incorreto
    @Test
    public void logarSemSucessoUsernameIncorreto() {

        loginPage.preencherUsernameIncorreto();
        loginPage.preencherPasswordCorreto();
        loginPage.clicarLoginBtn();

        // Validação:
        Assert.assertEquals(loginPage.validarLoginSemSucesso(), "Epic sadface: Username and password do not match any user in this service");
    }

    //==================================================================================================================

    // LOGIN SEM SUCESSO | Password incorreto
    @Test
    public void logarSemSucessoPasswordIncorreto() {

        loginPage.preencherUsernameCorreto();
        loginPage.preencherPasswordIncorreto();
        loginPage.clicarLoginBtn();

        // Validação:
        Assert.assertEquals(loginPage.validarLoginSemSucesso(), "Epic sadface: Username and password do not match any user in this service");
    }

    //==================================================================================================================

    // LOGIN SEM SUCESSO | Username vazio
    @Test
    public void logarSemSucessoUsernameVazio() {

        loginPage.preencherUsernameVazio();
        loginPage.preencherPasswordCorreto();
        loginPage.clicarLoginBtn();

        // Validação:
        Assert.assertEquals(loginPage.validarLoginSemSucesso(), "Epic sadface: Username is required");
    }

    //==================================================================================================================

    // LOGIN SEM SUCESSO | Password vazio
    @Test
    public void logarSemSucessoPasswordVazio() {

        loginPage.preencherUsernameCorreto();
        loginPage.preencherPasswordVazio();
        loginPage.clicarLoginBtn();

        // Validação:
        Assert.assertEquals(loginPage.validarLoginSemSucesso(), "Epic sadface: Password is required");
    }

}
