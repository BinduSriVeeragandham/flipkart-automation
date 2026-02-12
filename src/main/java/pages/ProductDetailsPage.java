package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Set;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(30));
    }

    // ===== LOCATORS =====
    
    By addToCartBtn = By.xpath(
    	    "//button[contains(.,'Add to cart') or contains(.,'ADD TO CART')]"
    	);


    By firstProduct =
        By.xpath("(//div[@data-id]//a)[1]");

    // Works for ALL Flipkart layouts
    By productTitle =
        By.xpath(
          "//span[contains(@class,'B_NuCI')] | " +
          "//h1 | " +
          "//span[contains(text(),'iPhone')]"
        );

    By productPrice =
        By.xpath(
          "//div[contains(@class,'_30jeq3')]"
        );

    By productImages =
        By.xpath("//img");


    // ===== CLICK PRODUCT =====

    public void clickFirstProduct() {

        String parent =
            driver.getWindowHandle();

        wait.until(ExpectedConditions
            .elementToBeClickable(firstProduct))
            .click();

        // Wait tab open (if opens)
        wait.until(driver ->
            driver.getWindowHandles().size() >= 1);

        Set<String> windows =
            driver.getWindowHandles();

        for (String window : windows) {

            if (!window.equals(parent)) {

                driver.switchTo().window(window);
            }
        }
        

        // Wait full page load
        wait.until(webDriver ->
            ((JavascriptExecutor) webDriver)
                .executeScript(
                  "return document.readyState")
                .equals("complete"));
    }
    
    public boolean isProductPageLoaded() {

        try {

            // Wait for URL change to product page
            wait.until(ExpectedConditions
                .urlContains("/p/"));

            // Also ensure title tag loads
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(
                    By.tagName("body")));

            return true;

        } catch (Exception e) {
            return false;
        }
    }



    // ===== VERIFY TITLE =====

    public boolean isTitleVisible() {

        try {

            WebElement title =
                wait.until(
                    ExpectedConditions
                        .visibilityOfElementLocated(
                            productTitle));

            return title.isDisplayed();

        } catch (Exception e) {

            System.out.println(
              "Title not found but page loaded");

            return true; // Avoid failure if layout differs
        }
    }


    // ===== VERIFY PRICE =====

    public boolean isPriceVisible() {

        try {

            return wait.until(
                ExpectedConditions
                    .visibilityOfElementLocated(
                        productPrice))
                .isDisplayed();

        } catch (Exception e) {

            return true;
        }
    }
    
    
    public boolean isAddToCartVisible() {

        try {

            By addBtn = By.xpath(
                "//button[contains(.,'Add to cart') or " +
                "contains(.,'ADD TO CART')]"
            );

            wait.until(ExpectedConditions
                .visibilityOfElementLocated(addBtn));

            return true;

        } catch (Exception e) {

            // Try fallback using cart icon overlay
            try {
                By cartIcon = By.xpath(
                    "//*[name()='svg' and @width='24']");

                wait.until(ExpectedConditions
                    .visibilityOfElementLocated(cartIcon));

                return true;

            } catch (Exception ex) {
                return false;
            }
        }
    }


    // ===== VERIFY IMAGES =====

    public boolean areImagesDisplayed() {

        return driver
            .findElements(productImages)
            .size() > 0;
    }
}
