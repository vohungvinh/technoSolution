/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class RequestDTO implements Serializable, Comparable<RequestDTO>{
    private int status,requestNumber,accountNumber,userId,haveBill,sendBill;
    private String type,bankName,address,modPayment;
    
    @Override
    public String toString() {
        return "RequestDTO{" + "userId=" + userId + ", status=" + status + ", requestNumber=" + requestNumber + ", accountNumber=" + accountNumber + ", type=" + type + ", bankName=" + bankName + ", address=" + address + ", modPayment=" + modPayment + '}';
    }

    public int getRequestNumber() {
        return requestNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getModPayment() {
        return modPayment;
    }

    public void setModPayment(String modPayment) {
        this.modPayment = modPayment;
    }

    public RequestDTO(int status, int accountNumber, int userId, int haveBill, int sendBill, String type, String bankName, String address, String modPayment) {
        this.status = status;
        this.accountNumber = accountNumber;
        this.userId = userId;
        this.haveBill = haveBill;
        this.sendBill = sendBill;
        this.type = type;
        this.bankName = bankName;
        this.address = address;
        this.modPayment = modPayment;
    }


    public RequestDTO() {
    }

    public int getHaveBill() {
        return haveBill;
    }

    public void setHaveBill(int haveBill) {
        this.haveBill = haveBill;
    }

    public int getSendBill() {
        return sendBill;
    }

    public void setSendBill(int sendBill) {
        this.sendBill = sendBill;
    }
    
    @Override
    public int compareTo(RequestDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
