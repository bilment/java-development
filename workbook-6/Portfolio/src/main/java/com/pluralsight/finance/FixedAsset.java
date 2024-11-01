package com.pluralsight.finance;

public abstract class FixedAsset implements Valuable {
     String name;
     double value;

    public FixedAsset(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public abstract double getValue();
}
