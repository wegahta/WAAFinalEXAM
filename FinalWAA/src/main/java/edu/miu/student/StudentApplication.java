package edu.miu.student;

import edu.miu.student.controller.formatter.PhoneFormatter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }

//    @Configuration
//    static class MyConfig extends WebMvcConfigurerAdapter {
//        @Override
//        public void addFormatters(FormatterRegistry registry) {
//            registry.addFormatter(new PhoneFormatter());
//        }
//    }
        @Configuration
    static class MyConfig implements WebMvcConfigurer {
        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new PhoneFormatter());
        }
    }


}
