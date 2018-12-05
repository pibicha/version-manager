package com.git.poan.exception;


import com.git.poan.common.FinalReturnCode;

public class ValidateException extends Exception {

    private static final long serialVersionUID = 1L;

    protected String description;
    private FinalReturnCode finalReturnCode;


    public ValidateException() {
        super();
    }

    public ValidateException(String message) {
        super(message);
    }

    public FinalReturnCode getFinalReturnCode() {
        return finalReturnCode;
    }

    public void setFinalReturnCode(FinalReturnCode finalReturnCode) {
        this.finalReturnCode = finalReturnCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
