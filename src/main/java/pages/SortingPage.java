package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.util.*;

public class SortingPage {

    WebDriver driver;
    WebDriverWait wait;

    public SortingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,
                Duration.ofSeconds(15));
    }

    // Sorting locators
    By lowToHigh =
    By.xpath("//div[contains(text(),'Low to High')]");

    By highToLow =
    By.xpath("//div[contains(text(),'High to Low')]");

    By popularity =
    By.xpath("//div[contains(text(),'Popularity')]");

    // STRICT product price locator
    By productPrices =
    By.xpath("//div[@data-id]//div[contains(@class,'hZ3P6w')]");


    // ---------- SORT ACTIONS ---------- //

    public void sortLowToHigh() {

        // Capture old first product
        WebElement firstProduct =
            driver.findElements(productPrices).get(0);

        wait.until(ExpectedConditions
            .elementToBeClickable(lowToHigh))
            .click();

        // Wait for old grid to disappear
        wait.until(ExpectedConditions
            .stalenessOf(firstProduct));
    }


    public void sortHighToLow() {

        WebElement firstProduct =
            driver.findElements(productPrices).get(0);

        wait.until(ExpectedConditions
            .elementToBeClickable(highToLow))
            .click();

        wait.until(ExpectedConditions
            .stalenessOf(firstProduct));
    }


    public void sortPopularity() {

        wait.until(ExpectedConditions
            .elementToBeClickable(popularity))
            .click();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {}
    }

    // ---------- PRICE EXTRACTION ---------- //

    public List<Integer> getPrices() {

        List<WebElement> elements =
            wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(productPrices));

        List<Integer> prices = new ArrayList<>();

        int limit = Math.min(elements.size(), 10);

        for (int i = 0; i < limit; i++) {

            String price =
                elements.get(i)
                    .getText()
                    .replaceAll("[^0-9]", "");

            if (!price.isEmpty()) {
                prices.add(Integer.parseInt(price));
            }
        }

        return prices;
    }

}
