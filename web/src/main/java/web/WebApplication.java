package web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"system","common","security","web"})
//"system","common","security",
@MapperScan(basePackages = "system.mapper")
public class WebApplication {


    public static void main(String[] args) {

        SpringApplication.run(WebApplication.class, args);

    }
}
