package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class InventoryPage extends BasePage {

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement btnAddCartSauceLabsBackpack;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnShoppingCart;

    @FindBy(css = ".product_sort_container")
    WebElement dropdownOrdenar;

    @FindBy(css = ".inventory_item_price")
    List<WebElement> listaPrecios;


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addCart() {
        btnAddCartSauceLabsBackpack.click();
    }
    public void clickCart() {
        btnShoppingCart.click();
    }

    public void ordenarPorPrecioDesc() {
        Select select = new Select(dropdownOrdenar);
        select.selectByVisibleText("Price (high to low)");
    }

    public List<Double> obtenerPrecios() {
        return listaPrecios.stream()
                .map(WebElement::getText)     // Ej: "$49.99"
                .map(p -> p.replace("$", ""))  // "49.99"
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }
}
