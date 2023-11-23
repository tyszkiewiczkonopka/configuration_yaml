package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.model.Browser;
import configuration.model.Config;
import configuration.model.Environment;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.InvalidArgumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Slf4j
@Getter
public class ConfigurationReader {
    private static final String FILE_PATH = "src/test/resources/configuration.yml";
    private Environment activeEnvironment;
    private Browser browser;

    public ConfigurationReader() {
        readYamlFile();
    }

    private void readYamlFile() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            Config config = mapper.readValue(new File(FILE_PATH), Config.class);
            List<Environment> environments = config.getEnvironments().values().stream()
                    .filter(Environment::isActive)
                    .toList();
            if (environments.size() != 1) {
                log.error("Error while parsing for active environments.");
                throw new InvalidArgumentException("There can be only one active environment");
            }
            activeEnvironment = environments.get(0);
            browser = config.getBrowser();

        } catch (IOException e) {
            log.error("Error reading YAML file: {}", e.getMessage(), e);
            throw new RuntimeException("Error reading YAML file: " + e.getMessage());
        }
    }

}

