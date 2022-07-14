package com.daniel.coupons.exceptions;

import com.daniel.coupons.enums.ErrorType;

public class ApplicationException extends Exception{

    private ErrorType errorType;
    private String metaDataForTroubleshooting;

    public ApplicationException(ErrorType errorType) {
        super(errorType.getErrorMessage());
        this.errorType = errorType;;
    }

    public ApplicationException(ErrorType errorType, String metaDataForTroubleshooting){
        super(errorType.getErrorMessage());
        this.errorType = errorType;
        this.metaDataForTroubleshooting = metaDataForTroubleshooting;
    }

    public ApplicationException(ErrorType errorType, Exception e){
        super(errorType.getErrorMessage(), e);
        this.errorType = errorType;
    }

    public ApplicationException(ErrorType errorType, Exception e, String metaDataForTroubleshooting){
        super(errorType.getErrorMessage(), e);
        this.errorType = errorType;
        this.metaDataForTroubleshooting = metaDataForTroubleshooting;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getMetaDataForTroubleshooting() {
        return metaDataForTroubleshooting;
    }

    public void setMetaDataForTroubleshooting(String metaDataForTroubleshooting) {
        this.metaDataForTroubleshooting = metaDataForTroubleshooting;
    }
}
