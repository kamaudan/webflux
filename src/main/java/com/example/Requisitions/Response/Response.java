package com.example.Requisitions.Response;


import com.example.Requisitions.models.Status;

public enum Response {

    SUCCESS(1, "Success"),
    USER_NOT_FOUND(2, "User not found");


    private Status status;

    Response(final int code, final String message){
        status = new Status(code,message);

    }
    public Status status() {
        return status;
    }




}
