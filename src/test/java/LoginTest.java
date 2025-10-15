import base.BaseTest;
import org.testng.Assert;
import pages.CartPage;
import pages.InventoryPage;
import pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void testLoginCorrecto() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/inventory.html", "La URL no es la esperada");

        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addCart();
        inventoryPage.clickCart();

        CartPage carrito = new CartPage(driver);
        boolean productoPresente = carrito.productInCart();
        Assert.assertTrue(productoPresente, "El producto 'Sauce Labs Backpack' no está en el carrito");
        System.out.println("El producto 'Sauce Labs Backpack' está presente en el carrito.");

    }

    @Test
    public void loginErroneo() {
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("locked_out_user", "secret_sauce");

        String mensajeError = loginPage.getErrorMessage();

        Assert.assertTrue(mensajeError.contains("Epic sadface: Sorry, this user has been locked out."),
                "El mensaje de error no es el esperado. Se obtuvo: " + mensajeError);
        System.out.println("Login erróneo: se mostró el mensaje de error correctamente.");
    }
}
