package com.springbootsandbox;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootSandboxApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootSandboxApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Command line runner executed");
    }
}
