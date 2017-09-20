package com.after00;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/***
 * 项目启动位置
 */
@Controller
@EnableAutoConfiguration
public class App {
        @RequestMapping("/")
        @ResponseBody
        String home() {
            return "Hello World!";
        }

        public static void main(String[] args) throws Exception {
            SpringApplication.run(App.class, args);
        }
}
