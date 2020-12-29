package com.happy.model;

public class HusbandShopResult {

    public HusbandShopResult(int milk, int eggs) {
        this.milk = milk;
        this.eggs = eggs;
    }

    private int milk;
    private int eggs;

    public int getMilk() {
        return milk;
    }

    public void setMilk(int milk) {
        this.milk = milk;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }
}
