package org.proleesh.sendemail.controller;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@Slf4j
@RequiredArgsConstructor
@RestController
public class EmailController {
    private final JavaMailSender javaMailSender;

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(@RequestParam("email") String email,
                             @RequestParam("text") String text){
        try{
            MimeMessage msg = createMimeMsg(email, text, "static/java.png");
//            SimpleMailMessage msg = createSimpleMailMessage(email, text);
            javaMailSender.send(msg);
        }catch(Exception e){
            log.error("Error msg: ", e);
            return false;
        }
        return true;
    }

    /**
     * 복잡한 메일 생성
     * @return
     */
    private MimeMessage createMimeMsg(String email, String text, String attachmentClassPath)
    throws MessagingException, UnsupportedEncodingException {
        MimeMessage msg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(msg, true);
        mimeMessageHelper.setFrom("merci726@yahoo.com", "proleesh");
        mimeMessageHelper.setCc("merci726@yahoo.com");
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Spring Boot 메일 발신 테스트");
        mimeMessageHelper.setText(text);
        Resource resource = new ClassPathResource(attachmentClassPath);
        mimeMessageHelper.addAttachment("첨부", resource
                );
        return msg;
    }

    private SimpleMailMessage createSimpleMailMessage(String email, String text){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("merci726@yahoo.com");
        msg.setTo(email);
        msg.setBcc("merci726@yahoo.com");
        msg.setSubject("Spring Boot 메일 발신 테스트");
        msg.setText(text);
        return msg;
    }
}
