package configuration.model;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import configuration.ConfigReader;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
@Getter
public class EnvironmentProperties {

    private String envName;
    private boolean active;

    Map<String, Object> properties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getProperties() {
        return properties;
    }

    @JsonAnySetter
    void setProperties(String key, Object value) {
        properties.put(key, value);
    }


}
