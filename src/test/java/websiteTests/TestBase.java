
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Slf4j
public class TestBase {
    protected static WebDriver driver;

    @BeforeAll
    static void setUp() {
        final WebDriver driver1 = new ChromeDriver();
        log.debug("Driver initialized");
    }

    @AfterAll
    static void tearDown() {
        driver.quit();
        log.debug("Driver closed");
    }
}
