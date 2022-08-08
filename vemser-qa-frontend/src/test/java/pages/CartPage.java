package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CartPage {

    //==================================================================================================================
    //                                        Página Cart | REMOVE FROM CART
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By removeBackpackBtn = By.cssSelector("#remove-sauce-labs-backpack");
    public static final By removeTShirtBtn = By.cssSelector("#remove-sauce-labs-bolt-t-shirt");
    public static final By removeOnesieBtn = By.cssSelector("#remove-sauce-labs-onesie");
    public static final By removeBikeLightBtn = By.cssSelector("#remove-sauce-labs-bike-light");
    public static final By removeJacketBtn = By.cssSelector("#remove-sauce-labs-fleece-jacket");

    public static final By cartBtn = By.cssSelector("#shopping_cart_container > a > span");

    // Validação:
    public static final By quantidadeCarrinho = By.cssSelector("#shopping_cart_container > a > span");

    //==================================================================================================================

    // MÉTODOS:

    public void clicarRemoveBackpack() {
        BaseTest.click(removeBackpackBtn);
    }

    public void clicarRemoveTShirt() {
        BaseTest.click(removeTShirtBtn);
    }

    public void clicarRemoveOnesie() {
        BaseTest.click(removeOnesieBtn);
    }

    public void clicarRemoveBikeLight() {
        BaseTest.click(removeBikeLightBtn);
    }

    public void clicarRemoveJacket() {
        BaseTest.click(removeJacketBtn);
    }

    public void clicarCart() {
        BaseTest.click(cartBtn);
    }

    // Validação:
    public String validarQuantidadeRemovidaComSucesso() {
        return BaseTest.getText(quantidadeCarrinho);
    }

    public String validarQuantidadeRemovidaSemSucesso() {
        return "6";
    }


    //==================================================================================================================
    //                                       Página Cart | CONTINUE SHOPPING
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By continueShoppingBtn = By.cssSelector("#continue-shopping");

    //==================================================================================================================

    // MÉTODOS:

    public void clicarContinueShoppingBtn() {
        BaseTest.click(continueShoppingBtn);
    }


    //==================================================================================================================
    //                                       Página Cart | EFETUAR CHECKOUT
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By checkoutBtn = By.cssSelector("#checkout");
    public static final By msgCheckoutComSucesso = By.cssSelector("#header_container > div.header_secondary_container > span");

    //==================================================================================================================

    // MÉTODOS:

    public void clicarCheckoutBtn() {
        BaseTest.click(checkoutBtn);
    }

    // Validação:
    public String validarCheckoutComSucesso() {
        return BaseTest.getText(msgCheckoutComSucesso);
    }

}
