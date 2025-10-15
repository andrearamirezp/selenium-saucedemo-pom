package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    WebElement sauceLabBackPackItem;

    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean productInCart() {
        return sauceLabBackPackItem.isDisplayed();
    }

    public void doCheckout() {
        btnCheckout.click();
    }
}
