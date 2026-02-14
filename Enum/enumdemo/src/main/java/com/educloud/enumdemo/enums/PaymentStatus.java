package com.educloud.enumdemo.enums;

public enum PaymentStatus {

    SUCCESS(200,"payment completed successfully"),
    Failed(500,"Payment failed"),
    PENDING(300,"payment pending");

    private int code;
    private String message;

    PaymentStatus(int code,String message){
        this.code=code;
        this.message=message;
    }

    public int getCode(){
        return code;
    }

    public String getMessage(){
        return message;
    }
}
