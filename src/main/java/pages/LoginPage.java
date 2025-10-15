package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='user-name']")
    WebElement inputUsuario;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement errorLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String usuario, String clave) {
        inputUsuario.sendKeys(usuario);
        inputPassword.sendKeys(clave);
        btnLogin.click();
    }

    public String getErrorMessage() {
        return errorLogin.getText();
    }
}
