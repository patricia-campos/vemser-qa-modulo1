package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class InventoryPage {

    //==================================================================================================================
    //                                          Página Inventory | FILTER
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By filter = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select");
    public static final By filterNameAToZ = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(1)");
    public static final By filterNameZToA = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(2)");
    public static final By filterPriceLowToHigh = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(3)");
    public static final By filterPriceHighToLow = By.cssSelector("#header_container > div.header_secondary_container > div.right_component > span > select > option:nth-child(4)");

    // Validação através do campo de valor, já que todos os itens tem valores diferentes.
    public static final By produtoBusca = By.cssSelector("#inventory_container > div > div:nth-child(1) > div.inventory_item_description > div.pricebar > div");


    //==================================================================================================================

    // MÉTODOS:

    public void clicarFilter() {
        BaseTest.click(filter);
    }

    public void clicarFilterNameAToZ() {
        BaseTest.click(filterNameAToZ);
    }

    public void clicarFilterNameZToA() {
        BaseTest.click(filterNameZToA);
    }

    public void clicarFilterPriceLowToHigh() {
        BaseTest.click(filterPriceLowToHigh);
    }

    public void clicarFilterPriceHighToLow() {
        BaseTest.click(filterPriceHighToLow);
    }

    // Validações:
    public String validarBuscaComSucesso() {
        return BaseTest.getText(produtoBusca);
    }

    public String validarBuscaSemSucesso() {
        return "";
    }


    //==================================================================================================================
    //                                      Página Inventory | ADD TO CART
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By addBackpackBtn = By.cssSelector("#add-to-cart-sauce-labs-backpack");
    public static final By addTShirtBtn = By.cssSelector("#add-to-cart-sauce-labs-bolt-t-shirt");
    public static final By addOnesieBtn = By.cssSelector("#add-to-cart-sauce-labs-onesie");
    public static final By addBikeLightBtn = By.cssSelector("#add-to-cart-sauce-labs-bike-light");
    public static final By addJacketBtn = By.cssSelector("#add-to-cart-sauce-labs-fleece-jacket");
    public static final By addRedTShirtBtn = By.cssSelector("#add-to-cart-test\\.allthethings\\(\\)-t-shirt-\\(red\\)");
    public static final By cartBtn = By.cssSelector("#shopping_cart_container > a > span");

    // Validação:
    public static final By quantidadeCarrinho = By.cssSelector("#shopping_cart_container > a > span");


    //==================================================================================================================

    // MÉTODOS:

    public void clicarAddBackpack() {
        BaseTest.click(addBackpackBtn);
    }

    public void clicarAddTShirt() {
        BaseTest.click(addTShirtBtn);
    }

    public void clicarAddOnesie() {
        BaseTest.click(addOnesieBtn);
    }

    public void clicarAddBikeLight() {
        BaseTest.click(addBikeLightBtn);
    }

    public void clicarAddJacket() {
        BaseTest.click(addJacketBtn);
    }

    public void clicarAddRedTShirt() {
        BaseTest.click(addRedTShirtBtn);
    }

    public void clicarCart() {
        BaseTest.click(cartBtn);
    }

    // Validação:
    public String validarQuantidadeComSucesso() {
        return BaseTest.getText(quantidadeCarrinho);
    }

    public String validarQuantidadeSemSucesso() {
        return "";
    }

}
