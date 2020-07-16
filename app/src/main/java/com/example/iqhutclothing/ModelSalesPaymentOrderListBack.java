
package com.example.iqhutclothing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelSalesPaymentOrderListBack {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("payment_type_id")
    @Expose
    private Integer paymentTypeId;
    @SerializedName("order_reference")
    @Expose
    private String orderReference;
    @SerializedName("invoice_reference")
    @Expose
    private String invoiceReference;
    @SerializedName("payment_date")
    @Expose
    private String paymentDate;
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("person_id")
    @Expose
    private Integer personId;
    @SerializedName("customer_id")
    @Expose
    private Integer customerId;
    @SerializedName("reference")
    @Expose
    private String reference;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;
    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("pay_type")
    @Expose
    private String payType;
    @SerializedName("invoice_id")
    @Expose
    private Integer invoiceId;
    @SerializedName("order_id")
    @Expose
    private Integer orderId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPaymentTypeId() {
        return paymentTypeId;
    }

    public void setPaymentTypeId(Integer paymentTypeId) {
        this.paymentTypeId = paymentTypeId;
    }

    public String getOrderReference() {
        return orderReference;
    }

    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getInvoiceReference() {
        return invoiceReference;
    }

    public void setInvoiceReference(String invoiceReference) {
        this.invoiceReference = invoiceReference;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

}
