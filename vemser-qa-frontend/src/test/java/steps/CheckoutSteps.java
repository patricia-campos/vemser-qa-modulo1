package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import util.Browser;

public class CheckoutSteps extends Browser {

    LoginSteps loginSteps = new LoginSteps();

    InventoryPage inventoryPage = new InventoryPage();

    CartPage cartPage = new CartPage();

    CheckoutPage checkoutPage = new CheckoutPage();

    //==================================================================================================================
    //                                                 CADASTRO CHECKOUT
    //==================================================================================================================

    // CADASTRO CHECKOUT COM SUCESSO
    @Test
    public void efetuarCheckoutComSucesso() {
        loginSteps.logarComSucesso();

        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        cartPage.clicarCheckoutBtn();

        checkoutPage.preencherFirstName();
        checkoutPage.preencherLastName();
        checkoutPage.preencherZipCode();
        checkoutPage.clicarContinueBtn();

        // Validação:
        Assert.assertEquals(checkoutPage.validarCheckoutComSucesso(), "CHECKOUT: OVERVIEW");
    }

    //==================================================================================================================

    // CADASTRO CHECKOUT SEM SUCESSO
    @Test
    public void efetuarCheckoutSemSucesso() {
        loginSteps.logarComSucesso();

        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        cartPage.clicarCheckoutBtn();

        checkoutPage.preencherFirstNameVazio();
        checkoutPage.preencherLastNameVazio();
        checkoutPage.preencherZipCodeVazio();
        checkoutPage.clicarContinueBtn();

        // Validação:
        Assert.assertEquals(checkoutPage.validarCheckoutSemSucesso(), "Error: First Name is required");
    }


}
