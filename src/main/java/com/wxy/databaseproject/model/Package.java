package com.wxy.databaseproject.model;

public class Package {
    private Integer packageId;
    private String type;
    private double price;

    public Package(Integer packageId, String type, double price) {
        this.packageId = packageId;
        this.type = type;
        this.price = price;
    }

    public Package() {}

    public Integer getPackageId() {
        return packageId;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Package{" +
                "packageId=" + packageId +
                ", type='" + type + '\'' +
                ", price=" + price +
                '}';
    }
}
