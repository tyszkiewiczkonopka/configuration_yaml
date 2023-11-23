package configuration.model;

import lombok.Getter;

import java.util.Map;

@Getter
public class Config {
    private Map<String, Environment> environments;
    private Browser browser;

    public Config() {
    }

}
