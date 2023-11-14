package site.nomoreparties.stellarburgers.base;

import site.nomoreparties.stellarburgers.constants.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSettings {
    protected WebDriver SetDriver(String browser) {
        if (browser.equals(TestData.CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(TestData.YA)) {
            ChromeOptions options = new ChromeOptions();
            options.setBinary(TestData.YA_LOCATION);
            return new ChromeDriver(options);
        }
        return null;
    }
}
