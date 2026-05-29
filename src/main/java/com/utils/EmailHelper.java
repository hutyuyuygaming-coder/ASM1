package com.utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailHelper {

    private static final String HOST = "smtp.gmail.com";
    private static final int PORT = 587;
    private static final String USERNAME = "your-email@gmail.com"; // thay bằng email của bạn
    private static final String PASSWORD = "your-app-password";    // thay bằng app password

    // Gửi email đơn giản
    public static void sendEmail(String to, String subject, String content) {
        try {
            // Cấu hình SMTP
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", HOST);
            props.put("mail.smtp.port", PORT);

            // Tạo session
            Session session = Session.getInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(USERNAME, PASSWORD);
                        }
                    });

            // Tạo message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(content);

            // Gửi
            Transport.send(message);
            System.out.println("Email đã được gửi thành công tới " + to);

        } catch (MessagingException e) {
            throw new RuntimeException("Lỗi khi gửi email: " + e.getMessage(), e);
        }
    }
}
