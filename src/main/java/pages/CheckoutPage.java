package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement inputNombre;

    @FindBy(xpath = "//input[@id='last-name']")
    WebElement inputApellido;

    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement inputCodigoPostal;

    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnContinue;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String nombre, String apellido, String codigoPostal) {
        inputNombre.sendKeys(nombre);
        inputApellido.sendKeys(apellido);
        inputCodigoPostal.sendKeys(codigoPostal);
        btnContinue.click();
    }
}
