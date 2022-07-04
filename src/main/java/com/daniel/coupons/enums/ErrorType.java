package com.daniel.coupons.enums;

public enum ErrorType {
    GENERAL_ERROR(601, "General error", true),
    FAILED_TO_CREATE_ID(602, "Failed to generate id", false),
    INVALID_CATEGORY_NAME(603, "Invalid category name", false),
    COMPANY_ALREADY_EXIST(604, "Company already exist", false),
    INVALID_COMPANY_NAME(605, "Invalid company name", false),
    INVALID_COMPANY_PHONE_NUMBER(606, "Invalid company phone number", false),
    COMPANY_DOESNT_EXIST(607, "Company doesn't exist", false),
    COMPANY_NAME_CANT_BE_CHANGED(608, "Company name can't be changed", false),
    USERNAME_ALREADY_EXIST(609, "Username already exist", false),
    INVALID_USERNAME(610, "Invalid username", false),
    INVALID_PASSWORD(611, "Invalid password", false),
    INVALID_USER_TYPE(612, "Invalid user type", false),
    USER_DOESNT_EXIST(613, "User doesn't exist", false),
    COUPON_TITLE_ALREADY_EXIST(614, "A coupon with the same title already exist in the company", false),
    INVALID_COUPON_TITLE(615, "Invalid coupon title", false),
    INVALID_COMPANY_ID(616, "Invalid company ID", false),
    INVALID_CATEGORY_ID(617, "Invalid category ID", false),
    INVALID_COUPON_DESCRIPTION(618, "Invalid coupon description", false),
    INVALID_COUPON_DATE(619, "Invalid coupon date", false),
    INVALID_COUPON_AMOUNT(620, "Invalid coupon amount", false),
    INVALID_COUPON_PRICE(621, "Invalid coupon price", false),
    COUPON_DOESNT_EXIST(622, "Coupon doesnt exist", false),
    COUPON_COMPANY_ID_CANT_BE_CHANGED(623, "Company ID can't be changed", false),
    CUSTOMER_DOESNT_EXIST(624, "Customer doesn't exist", false),
    INVALID_COUPON(625, "Invalid coupon", false),
    INVALID_CUSTOMER(625, "Invalid coupon", false),
    COUPON_EXPIRED(626, "Coupon expired", false),
    CATEGORY_DOESNT_EXIST(627, "Category doesn't exist", false),
    COUPON_OUT_OF_STOCK(628, "Coupon out of stock", false),
    CATEGORY_ALREADY_EXIST(629, "Category already exist", false)
    ;

    private int errorId;
    private String errorMessage;
    private boolean isPrintStackTrace;

    ErrorType(int errorId, String errorMessage, boolean isPrintStackTrace) {
        this.errorId = errorId;
        this.errorMessage = errorMessage;
        this.isPrintStackTrace = isPrintStackTrace;
    }

    public int getErrorId() {
        return errorId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isPrintStackTrace() {
        return isPrintStackTrace;
    }

}
