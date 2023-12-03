package websiteTests;

import configuration.ConfigurationReader;
import configuration.WebDriverSetup;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

@Slf4j
public class TestBase {
    protected static WebDriver driver;

    @BeforeAll
    static void setUp() {
        new ConfigurationReader().readYamlFile();
        WebDriverSetup webDriverSetup = new WebDriverSetup(System.getProperty("browser.name"));
        driver = webDriverSetup.getDriver();
        log.debug("Driver initialized");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
            log.debug("Driver closed");
        }
    }
}
