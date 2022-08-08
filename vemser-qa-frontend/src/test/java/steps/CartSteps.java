package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CartPage;
import pages.InventoryPage;
import util.Browser;

public class CartSteps extends Browser {

    LoginSteps loginSteps = new LoginSteps();

    CartPage cartPage = new CartPage();

    InventoryPage inventoryPage = new InventoryPage();

    //==================================================================================================================
    //                                              REMOVE FROM CART
    //==================================================================================================================

    // REMOVER 5 PRODUTOS DO CARRINHO COM SUCESSO

    @Test
    public void RemoverProdutosComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        cartPage.clicarRemoveBackpack();
        cartPage.clicarRemoveTShirt();
        cartPage.clicarRemoveOnesie();
        cartPage.clicarRemoveBikeLight();
        cartPage.clicarRemoveJacket();

        cartPage.clicarCart();

        // Validação:
        Assert.assertEquals(cartPage.validarQuantidadeRemovidaComSucesso(), "1");
    }

    //==================================================================================================================

    // REMOVER PRODUTOS DO CARRINHO SEM SUCESSO
    @Test
    public void adicionarTodosProdutosSemSucesso() {

        loginSteps.logarComSucesso();

        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        cartPage.clicarRemoveBackpack();
        cartPage.clicarRemoveTShirt();
        cartPage.clicarRemoveOnesie();
        cartPage.clicarRemoveBikeLight();
        cartPage.clicarRemoveJacket();

        cartPage.clicarCart();

        // Validação:
        Assert.assertEquals(cartPage.validarQuantidadeRemovidaSemSucesso(), "6");
    }

    //==================================================================================================================
    //                                  SEGUE A COMPRA COM A QUANTIDADE SELECIONADA
    //==================================================================================================================

    // SEGUE A COMPRA COM SUCESSO:
    @Test
    public void ProcedeCheckoutComSucesso() {

        loginSteps.logarComSucesso();

        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        cartPage.clicarCheckoutBtn();

        // Validação:
        Assert.assertEquals(cartPage.validarCheckoutComSucesso(), "CHECKOUT: YOUR INFORMATION");

    }

}
