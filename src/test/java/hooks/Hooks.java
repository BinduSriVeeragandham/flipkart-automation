package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.DriverSetup;

import java.io.File;
import org.apache.commons.io.FileUtils;

public class Hooks {

    WebDriver driver = DriverSetup.getDriver();

    @After
    public void captureScreenshot(Scenario scenario) {

        if (scenario.isFailed()) {

            try {
                File src = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);

                File dest = new File(
                    "target/screenshots/"
                    + scenario.getName() + ".png");

                FileUtils.copyFile(src, dest);

            } catch (Exception e) {
                System.out.println(
                    "Screenshot capture failed");
            }
        }
    }
}
