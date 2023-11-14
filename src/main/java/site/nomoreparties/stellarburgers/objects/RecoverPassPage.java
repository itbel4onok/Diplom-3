package site.nomoreparties.stellarburgers.objects;

import site.nomoreparties.stellarburgers.base.BaseActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassPage extends BaseActions {
    // Кнопка "Войти"
    private final By loginButton = By.xpath("//a[contains(@href, '/login')]");

    @Step("Recover password page -> click to login button")
    public void clickLoginButton(WebDriver driver){
        click(driver, loginButton);
    }
}
