package com.patrickredding.DEA

class EmailService {
    def generateDynamicEmail(String recipientName) {
        // Generate your dynamic email content here based on recipientName
        def emailContent = "Hello, $recipientName! This is your dynamic email."

        return emailContent
    }
}
