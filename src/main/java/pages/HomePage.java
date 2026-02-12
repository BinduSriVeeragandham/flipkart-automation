package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Locators
    By popupCloseBtn = By.xpath("//button[contains(text(),'✕')]");
    By searchBox = By.name("q");

    // Open site
    public void openSite() {

        driver.get("https://www.flipkart.com");

        // Wait for page load fully
        wait.until(webDriver ->
                ((org.openqa.selenium.JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    // Close login popup safely
    public void closeLoginPopup() {

        try {
            wait.until(ExpectedConditions
                    .elementToBeClickable(popupCloseBtn))
                    .click();

            System.out.println("Popup closed");

        } catch (Exception e) {
            System.out.println("Popup not displayed");
        }
    }

    // Verify search box
    public boolean isSearchVisible() {

        try {
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(searchBox));

            return driver.findElement(searchBox).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }
}
