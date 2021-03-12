package ru.geekbrains.service;

import ru.geekbrains.persist.Product;

import java.util.Objects;

public class LineItem {

    private ProductRepr productRepr;

    private UserRepr userRepr;

    private Integer qty;

    public LineItem() {
    }

    public LineItem(long productId, long userId) {
        this.productRepr = new ProductRepr();
        this.productRepr.setId(productId);
        this.userRepr = new UserRepr();
        this.userRepr.setId(userId);
    }

    public LineItem(ProductRepr product, UserRepr user, Integer qty) {
        this.productRepr = product;
        this.userRepr = user;
        this.qty = qty;
    }

    public ProductRepr getProductRepr() {
        return productRepr;
    }

    public void setProductRepr(ProductRepr productRepr) {
        this.productRepr = productRepr;
    }

    public UserRepr getUser() {
        return userRepr;
    }

    public void setUser(UserRepr user) {
        this.userRepr = user;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return productRepr.getId().equals(lineItem.productRepr.getId()) && userRepr.getId().equals(lineItem.userRepr.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(productRepr.getId(), productRepr.getId());
    }
}
