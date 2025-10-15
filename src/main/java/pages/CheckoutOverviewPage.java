package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnFinish;

    @FindBy(xpath = "//h2[@class='complete-header']")
    WebElement confirmMessage;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void finishBuy() {
        btnFinish.click();
    }

    public String getConfirmMessage() {
        return confirmMessage.getText();
    }
}
