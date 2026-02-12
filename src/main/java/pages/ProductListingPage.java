package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;


import java.time.Duration;


public class ProductListingPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductListingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Product list
    By products =
    By.xpath("//div[contains(@data-id,'')]");

    // Filters
    By priceFilter =
    		By.xpath("(//div[contains(text(),'₹')])[1]");

    By brandFilter =
    By.xpath("//div[text()='SAMSUNG']");

    By clearFilter =
    By.xpath("//div[text()='Clear all']");

    public int getProductCount() {

        wait.until(ExpectedConditions
            .visibilityOfElementLocated(products));

        List<WebElement> list =
        	    driver.findElements(products);

        return list.size();
    }

    public void applyPriceFilter()
            throws InterruptedException {

        By priceFilter =
        By.xpath("(//div[contains(text(),'₹')])[1]");

        WebElement element =
            wait.until(ExpectedConditions
                .visibilityOfElementLocated(priceFilter));

        ((JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].scrollIntoView(true);",
                element);

        Thread.sleep(1000);

        ((JavascriptExecutor) driver)
            .executeScript(
                "arguments[0].click();",
                element);
    }



    public void applyBrandFilter()
            throws InterruptedException {
    	}


          By appliedFilter =
          By.xpath("//div[contains(text(),'Apple') and contains(@class,'_1Y4Vhm')]");


          public boolean isFilterApplied() {

        	    return driver.getCurrentUrl()
        	        .toLowerCase()
        	        .contains("apple")
        	        ||
        	        driver.findElements(
        	            By.xpath("//div[contains(text(),'Apple')]")
        	        ).size() > 0;
        	}


    public void clearFilters() {
        wait.until(ExpectedConditions
            .elementToBeClickable(clearFilter)).click();
    }
}
