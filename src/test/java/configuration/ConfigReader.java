package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import configuration.model.BrowserProperties;
import configuration.model.EnvironmentProperties;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Getter
public class ConfigReader {
    private String browserName;
    private String appUrl;
    private String websiteTitle;

    private final String filePath;
    private Map<String, Object> environmentProperties = new HashMap<>();

    public ConfigReader(String filePath) {
        this.filePath = filePath;
        readConfiguration();
    }

    public void readYamlFile() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        try {
            Map<String, Object> yamlMap = mapper.readValue(new File(filePath), Map.class);

            this.browserName = (String) yamlMap.get("browser.browserName");
            this.appUrl = (String) yamlMap.get("test_data.appUrl");
            this.websiteTitle = (String) yamlMap.get("test_data.websiteTitle");

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error reading YAML file: " + e.getMessage());
        }
    }

    public void readConfiguration() {
        readYamlFile();
    }
    public void configureTestsForEnvironment(String activeEnvironment) {
        if ("test".equalsIgnoreCase(activeEnvironment)) {
        } else if ("prod".equalsIgnoreCase(activeEnvironment)) {
        } else {
            throw new RuntimeException("Unknown active environment: " + activeEnvironment);
        }
    }
    public String getActiveEnvironment() {
        readYamlFile();
        return environmentProperties.getOrDefault("defaultEnvironment", "test").toString();
    }
}

