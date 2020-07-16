
package com.example.iqhutclothing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSalesPaymentOrderList {

    @SerializedName("menu")
    @Expose
    private String menu;
    @SerializedName("sub_menu")
    @Expose
    private String subMenu;
    @SerializedName("paymentList")
    @Expose
    private PaymentList paymentList;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getSubMenu() {
        return subMenu;
    }

    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }

    public PaymentList getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(PaymentList paymentList) {
        this.paymentList = paymentList;
    }

}
