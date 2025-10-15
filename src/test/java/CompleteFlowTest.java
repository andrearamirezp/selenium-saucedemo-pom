import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;


public class CompleteFlowTest extends BaseTest {

    @Test
    public void verificarCompraExitosa() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addCart();
        inventoryPage.clickCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.doCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.fillForm("Andrea", "Ramirez", "12345");

        CheckoutOverviewPage overviewPage = new CheckoutOverviewPage(driver);
        overviewPage.finishBuy();

        String mensaje = overviewPage.getConfirmMessage();
        Assert.assertEquals(mensaje, "Thank you for your order!",
                "El mensaje de confirmación no es el esperado.");

        System.out.println("Compra realizada correctamente: " + mensaje);
    }
}
