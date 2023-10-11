package com.patrickredding.DEA

class EmailResponse {
    String status
    String message
    String emailContent

    EmailResponse(String status, String message, String emailContent) {
        this.status = status
        this.message = message
        this.emailContent = emailContent
    }
}
