package com.tcs.ecommerceproductmicroservices.payloads;

import java.time.LocalDateTime;

public class ApiResponse {
    private String message;
    private String details;
    private boolean success;
    private LocalDateTime timestamp;

    public ApiResponse(String userDeletedSuccessfully, boolean b) {
        this.message = userDeletedSuccessfully;
        this.success=  b;
    }

    public ApiResponse(LocalDateTime now, String message, String description) {
        this.timestamp = now;
        this.message = message;
        this.details = description;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }



    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "ApiResponse{" +
                "message='" + message + '\'' +
                ", details='" + details + '\'' +
                ", success=" + success +
                ", timestamp=" + timestamp +
                '}';
    }
}


