package websiteTests;

import configuration.model.BrowserProperties;
import configuration.ConfigReader;
import configuration.model.EnvironmentProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;


@Slf4j
public class TestBase {
    protected static WebDriver driver;
    protected static ConfigReader config = new ConfigReader("src/test/resources/configuration.yml");
    @BeforeAll
    static void setUp() {
        config.readConfiguration();
        String activeEnvironment = config.getActiveEnvironment();
        config.configureTestsForEnvironment(activeEnvironment);
        BrowserProperties browser = new BrowserProperties(config.getBrowserName());
        driver = browser.getDriver();
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
