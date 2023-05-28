package objects;

import base.BaseActions;
import constants.ExpectedMessage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class PersonalPage extends BaseActions {
    // Текст "Профиль"
    private final By profileText = By.xpath("//a[contains(@href, '/account/profile') " +
            "and text() = 'Профиль']");

    // Кнопка "Выход"
    private final By logoutButton = By.xpath("//button[contains(text(),'Выход')]");

    @Step("Personal page -> check profile text is shown")
    public void checkProfileTextShown(WebDriver driver){
        assertTrue(ExpectedMessage.PROFILE_TEXT_SHOWN, isElementPresent(driver, profileText));
    }

    @Step("Personal page -> wait page loading")
    public void waitForLoadPersonalPage(WebDriver driver) {
        waitForLoadPage(driver, profileText);
    }

    @Step("Personal page -> click to logout button")
    public void clickLogoutButton(WebDriver driver){
        click(driver, logoutButton);
    }
}
