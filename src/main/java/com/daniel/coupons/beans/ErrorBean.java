package com.daniel.coupons.beans;

public class ErrorBean {
    int errorId;
    String errorMessage;

    public ErrorBean(int errorId, String errorMessage) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
    }

    public ErrorBean() {
    }

    public int getErrorId() {
        return errorId;
    }

    public void setErrorId(int errorId) {
        this.errorId = errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "ErrorBean{" +
                "errorId=" + errorId +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
