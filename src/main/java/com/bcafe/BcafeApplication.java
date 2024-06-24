package com.bcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BcafeApplication {

  public static void main(String[] args) {
    SpringApplication.run(BcafeApplication.class, args);
  }

}
