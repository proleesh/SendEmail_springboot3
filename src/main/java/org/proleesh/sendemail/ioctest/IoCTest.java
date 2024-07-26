package org.proleesh.sendemail.ioctest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IoCTest {
    public static void main(String[] args) {
        // 만든 파일 AppConfig.java 로 IoC 컨테이너를 만들기
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        try{
            var user = ctx.getBean(User.class);
            System.out.println(user.getUsername());
            System.out.println(user);
        }finally {
            // IoC 컨테이너를 닫기
            ctx.close();
        }
    }
}
