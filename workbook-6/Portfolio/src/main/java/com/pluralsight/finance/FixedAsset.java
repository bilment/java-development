package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable {
    public String name;
    public double value;

    public FixedAsset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }
}
