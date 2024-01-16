package com.example.bth_gk;

public class Product {
    String name;
    double price;
    int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return " - Sản phẩm: " + name + "\n - Giá bán: " + price + " VND\n - Số lượng: " + quantity + "\n - Tổng thành tiền: " + getTotalPrice() + " VND\n ==============================================";
    }
}
