package com.happy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @Column(name = "storeId")
    private Integer storeId;

    @Column(name = "milkQty")
    private int milkQty;

    @Column(name = "eggQty")
    private int eggQty;

    private Product(ProductBuilder productBuilder) {
        this.storeId = productBuilder.id;
        this.eggQty = productBuilder.eggQty;
        this.milkQty = productBuilder.milkQty;
    }

    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(int id) {
        this.storeId = id;
    }
    public int getMilkQty() { return milkQty; }
    public void setMilkQty(int milkQty) {
        this.milkQty = milkQty;
    }
    public int getEggQty() {
        return eggQty;
    }
    public void setEggQty(int eggQty) {
        this.eggQty = eggQty;
    }

    // Builder Class
    public static class ProductBuilder {
        private int id;
        private int milkQty;
        private int eggQty;

        public ProductBuilder(int id){
            this.id  = id;
        }

        public ProductBuilder setMilkQty(int milkQty){
            this.milkQty = milkQty;
            return this;
        }

        public ProductBuilder setEggQty(int eggQty){
            this.eggQty = eggQty;
            return this;
        }

        public Product build(){
            return new Product(this);
        }
    }
}
