package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.FinishPage;
import pages.InventoryPage;
import util.Browser;

public class FinishSteps extends Browser {

    LoginSteps loginSteps = new LoginSteps();

    InventoryPage inventoryPage = new InventoryPage();

    CartPage cartPage = new CartPage();

    CheckoutPage checkoutPage = new CheckoutPage();

    FinishPage finishPage = new FinishPage();

    //==================================================================================================================
    //                                                  FINISH
    //==================================================================================================================

    // CADASTRO CHECKOUT COM SUCESSO
    @Test
    public void finalizarCompraComSucesso() {

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

        finishPage.clicarFinishBtn();

        // Validação:
        Assert.assertEquals(finishPage.validarFinishComSucesso(), "THANK YOU FOR YOUR ORDER");
    }

}

