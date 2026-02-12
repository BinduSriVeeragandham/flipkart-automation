package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.Set;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators (multiple fallbacks)
    By addToCartBtn = By.xpath(
            "//button[contains(.,'Add to cart') or contains(.,'ADD TO CART')]"
    );

    By goToCartBtn = By.xpath(
            "//span[text()='Go to Cart'] | //button[contains(.,'Go to Cart')]"
    );

    By cartIcon = By.xpath("//a[contains(@href,'viewcart')]");

    By removeBtn = By.xpath("//div[text()='Remove']");
    By emptyCartMsg = By.xpath("//*[contains(text(),'Missing Cart items')]");



    // 🔹 Switch to product tab
    public void switchToProductTab() {

        Set<String> windows = driver.getWindowHandles();

        for (String win : windows) {
            driver.switchTo().window(win);
        }
    }



    // 🔹 Add product to cart
    public void addProductToCart() {

        switchToProductTab();

        try {

            WebElement addBtn = wait.until(
                    ExpectedConditions.presenceOfElementLocated(addToCartBtn)
            );

            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", addBtn);

        } catch (Exception e) {

            System.out.println("Add button not clickable → trying cart icon");

            WebElement cart = wait.until(
                    ExpectedConditions.elementToBeClickable(cartIcon)
            );
            cart.click();
        }


        // Wait cart page load
        wait.until(ExpectedConditions.urlContains("cart"));
    }



    // 🔹 Verify cart page
    public boolean isCartPageDisplayed() {
        return driver.getCurrentUrl().contains("cart");
    }



    // 🔹 Open cart manually
    public void openCart() {

        WebElement cart = wait.until(
                ExpectedConditions.elementToBeClickable(cartIcon)
        );
        cart.click();
    }



    // 🔹 Remove product
    public void removeProduct() {

        try {

            // Step 1 — Click Remove link/button
        	By removeLink = By.xpath(
        		    "//*[text()='Remove' or contains(text(),'Remove')]"
        		);

            WebElement removeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(removeLink)
            );

            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", removeBtn);


            // Step 2 — Confirm Remove in popup
            By confirmRemove = By.xpath(
                "//div[text()='Remove'] | //button[text()='Remove']"
            );

            WebElement confirmBtn = wait.until(
                ExpectedConditions.elementToBeClickable(confirmRemove)
            );

            ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", confirmBtn);


            // Step 3 — Wait cart empty / item gone
            wait.until(ExpectedConditions.or(

                ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(),'Missing Cart items')]")
                ),

                ExpectedConditions.invisibilityOfElementLocated(removeLink)
            ));

        } catch (Exception e) {
            System.out.println("Remove failed → item may not exist");
        }
    }



    // 🔹 Verify empty cart
    public boolean isCartEmpty() {

        try {
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(emptyCartMsg)
            );
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
