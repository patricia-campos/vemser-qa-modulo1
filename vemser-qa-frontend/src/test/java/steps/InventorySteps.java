package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.InventoryPage;
import util.Browser;

public class InventorySteps extends Browser {

    LoginSteps loginSteps = new LoginSteps();

    InventoryPage inventoryPage = new InventoryPage();

    //==================================================================================================================
    //                                               FILTER | A to Z
    //==================================================================================================================

    // BUSCAR A TO Z COM SUCESSO
    @Test
    public void buscarAToZComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterNameAToZ();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaComSucesso(), "$29.99");
    }

    //BUSCAR A TO Z SEM SUCESSO
    @Test
    public void buscarAToZSemSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterNameAToZ();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaSemSucesso(), "");
    }

    //==================================================================================================================
    //                                               FILTER | Z to A
    //==================================================================================================================

    // BUSCAR Z TO A COM SUCESSO
    @Test
    public void buscarZToAComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterNameZToA();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaComSucesso(), "$15.99");
    }

    //BUSCAR Z TO A SEM SUCESSO
    @Test
    public void buscarZToASemSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterNameZToA();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaSemSucesso(), "");
    }

    //==================================================================================================================
    //                                               FILTER | LOW to HIGH
    //==================================================================================================================

    // BUSCAR LOW to HIGH COM SUCESSO
    @Test
    public void buscarLowToHighComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterPriceLowToHigh();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaComSucesso(), "$7.99");
    }

    //BUSCAR LOW to HIGH  SEM SUCESSO
    @Test
    public void buscarLowToHighSemSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterPriceLowToHigh();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaSemSucesso(), "");
    }

    //==================================================================================================================
    //                                               FILTER | HIGH to LOW
    //==================================================================================================================

    // BUSCAR HIGH to LOW COM SUCESSO
    @Test
    public void buscarHighToLowComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterPriceHighToLow();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaComSucesso(), "$49.99");
    }

    //BUSCAR HIGH to LOW  SEM SUCESSO
    @Test
    public void buscarHighToLowSemSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarFilter();
        inventoryPage.clicarFilterPriceHighToLow();

        // Validação:
        Assert.assertEquals(inventoryPage.validarBuscaSemSucesso(), "");
    }

    //==================================================================================================================
    //                                              ADD TO CART
    //==================================================================================================================

    // ADICONAR TODOS OS PRODUTOS AO CARRINHO COM SUCESSO

    @Test
    public void adicionarTodosProdutosComSucesso() {

        loginSteps.logarComSucesso();
        inventoryPage.clicarAddBackpack();
        inventoryPage.clicarAddTShirt();
        inventoryPage.clicarAddOnesie();
        inventoryPage.clicarAddBikeLight();
        inventoryPage.clicarAddJacket();
        inventoryPage.clicarAddRedTShirt();
        inventoryPage.clicarCart();

        // Validação:
        Assert.assertEquals(inventoryPage.validarQuantidadeComSucesso(), "6");
    }

    // ADICONAR TODOS OS PRODUTOS AO CARRINHO SEM SUCESSO
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

        // Validação:
        Assert.assertEquals(inventoryPage.validarQuantidadeSemSucesso(), "");

    }

}
