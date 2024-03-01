package me.kire.re.consumption.util.enums;

import lombok.Getter;

@Getter
public enum ConsumptionTypeEnum {
    UNIT("UNIT"),
    PERCENTAGE("PERCENTAGE");

    private final String name;

    ConsumptionTypeEnum(String name) {
        this.name = name;
    }

    public static ConsumptionTypeEnum getConsumptionTypeEnum(String name) {
        for (ConsumptionTypeEnum value : ConsumptionTypeEnum.values()) {
            if (value.getName().equals(name)) return value;
        }
        return null;
    }

}
