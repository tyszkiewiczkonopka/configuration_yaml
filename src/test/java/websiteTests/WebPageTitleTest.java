package websiteTests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Slf4j
public class WebPageTitleTest extends TestBase {

    @Test
    @DisplayName("Title")
    @Tag("Title")
    public void website_title_should_be_as_in_configuration_file() {
        log.info(">>>>> STARTING TEST <<<<<");
        driver.get(configurationReader.getActiveEnvironment().getAppUrl());

        final String expectedTitle = activeEnvironment.getWebsiteTitle();
        String actualTitle = driver.getTitle();

        log.info("URL {}", activeEnvironment.getAppUrl());
        log.info("Actual Title {}", actualTitle);
        log.info("Expected Title {}", expectedTitle);

        assertThat(actualTitle, equalTo(expectedTitle));
    }
}
