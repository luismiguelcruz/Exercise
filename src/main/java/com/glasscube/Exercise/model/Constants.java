package com.glasscube.Exercise.model;

public enum Constants {
    APPLICATION_PROPERTIES_REL_PATH("/application.properties"),
    PRODUCT_QUANTITY_KEY("productQuantityRelativePath"),
    PRODUCT_PRICE_KEY("productPriceRelativePath");

    private String value;

    Constants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}