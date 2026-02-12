package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class NavigationPage {

    WebDriver driver;
    WebDriverWait wait;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // ===== Locators =====

    By mobilesCategory =
        By.xpath("//span[text()='Mobiles'] | //a[contains(@href,'mobiles')]");

    By flipkartLogo =
        By.xpath("//img[@title='Flipkart'] | //a[contains(@href,'flipkart.com')]");

    By searchBox =
        By.name("q");

    // ===== Actions =====

    public void openMobilesCategory() {

        WebElement mobile =
            wait.until(ExpectedConditions
                .elementToBeClickable(mobilesCategory));

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].click();", mobile);
    }

    public void clickFlipkartLogo() {

        WebElement logo =
            wait.until(ExpectedConditions
                .elementToBeClickable(flipkartLogo));

        logo.click();
    }

    // ===== Verifications =====

    public boolean isMobilesPageDisplayed() {
        try {
            return driver.getCurrentUrl()
                    .toLowerCase()
                    .contains("mobile");
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isHomePage() {
        try {
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(searchBox));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
