package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class FinishPage {

    //==================================================================================================================
    //                                        Página Finish | FINALIZAR COMPRA
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By finishBtn = By.cssSelector("#finish");
    public static final By msgFinishComSucesso = By.cssSelector("#checkout_complete_container > h2");

    //==================================================================================================================

    // MÉTODOS:

    public void clicarFinishBtn() {
        BaseTest.click(finishBtn);
    }

    // Validação:
    public String validarFinishComSucesso() {
        return BaseTest.getText(msgFinishComSucesso);
    }

    //==================================================================================================================
    //                                       Página Finish | CANCELAR COMPRA
    //==================================================================================================================

    // DECLARAÇÃO DOS CAMPOS:

    public static final By cancelBtn = By.cssSelector("#cancel");

    //==================================================================================================================

    // MÉTODOS:

    public void clicarCancelBtn() {
        BaseTest.click(cancelBtn);
    }


}
