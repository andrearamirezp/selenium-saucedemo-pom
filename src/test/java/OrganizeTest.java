import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

import java.util.List;


public class OrganizeTest extends BaseTest {

    @Test
    public void verificarOrdenamientoPorPrecioDesc(){
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.ordenarPorPrecioDesc();

        List<Double> precios = inventoryPage.obtenerPrecios();

        double primerPrecio = precios.get(0);
        double ultimoPrecio = precios.get(precios.size() - 1);

        Assert.assertTrue(primerPrecio > ultimoPrecio,
                "Los productos no están ordenados de mayor a menor precio");

        System.out.println("Los productos están correctamente ordenados (de mayor a menor precio).");
    }
}
