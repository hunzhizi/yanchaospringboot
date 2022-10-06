package com.hunzhizi;

import com.hunzhizi.domain.Activity;
import com.hunzhizi.domain.ActivityCommit;
import com.hunzhizi.util.ExcelUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.ArrayList;
import java.util.LinkedList;

@SpringBootApplication
@EnableScheduling
public class YanchaoSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(YanchaoSpringbootApplication.class, args);
    }

}
