package com.happy.model;

/**
 * Created by Hung on 22/9/16.
 */
public class EggsQtyResult {

    public EggsQtyResult(int qty) {
        eggs = qty;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    private int eggs;
}
