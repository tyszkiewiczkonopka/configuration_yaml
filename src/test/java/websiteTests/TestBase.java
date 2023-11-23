package websiteTests;

import configuration.ConfigurationReader;
import configuration.WebDriverSetup;
import configuration.model.Environment;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

@Slf4j
public class TestBase {
    protected static WebDriver driver;
    protected static ConfigurationReader configurationReader = new ConfigurationReader();
    protected static Environment activeEnvironment;

    @BeforeAll
    static void setUp() {
        activeEnvironment = configurationReader.getActiveEnvironment();
        WebDriverSetup webDriverSetup = new WebDriverSetup(configurationReader.getBrowser().getBrowserName());
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
