package br.com.liandro.qafood.utils.enuns;

import java.util.Arrays;

public enum Platform {

    ANDROID("ANDROID"), IOS("IOS"),
    DEVICEFARM_ANDROID("DEVICEFARM_ANDROID"),
    DEVICEFARM_IOS("DEVICEFARM_IOS");

    public final String platformName;

    Platform(String platformName) {
        this.platformName = platformName;
    }

    public String getValue() {
        return this.platformName;
    }

    public static Platform getEnum(String value) {
        return Arrays.stream(values())
                .filter(enumValue -> enumValue.getValue().equalsIgnoreCase(value))
                .findAny()
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("The platform %s isn't a valid platform", value)));
    }

}
