package configuration.model;

import lombok.Getter;

@Getter
public class Environment {

    private String envName;
    private boolean active;
    private String appUrl;
    private String websiteTitle;

    public Environment() {
    }

}
