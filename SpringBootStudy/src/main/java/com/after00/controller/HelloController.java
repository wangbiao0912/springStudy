package com.after00.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiaofan on 2017/3/22.
 */
@RestController
//@RequestMapping("/class") // 给类指定路径
public class HelloController {
    @Value("${fruit.apple}")
    private String fruitApple;
    @Value("${fruits}")
    private String fruits;
  /*  @Autowired
    private CarProperties carProperties;*/

    /**
     * 访问127.0.0.1:8081/hi
     *
     * @return hi
     */
    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
//    @RequestMapping(value = {"/hi","/hello"}, method = RequestMethod.GET)
    public String hi(@PathVariable("id") Integer idParam) {
        String result = "Hi SpringBoot , zxiaofan.com";
        return result + "_" + fruitApple + "_" + fruits + "_car_" +"_(id:"+idParam+")";
    }
//    @RequestMapping(value = "/good",method = RequestMethod.GET)
    @GetMapping(value="/good") // 注解简化
    public String good(@RequestParam(value = "id",required = false,defaultValue = "0") Integer idParam) {
        return "id:"+idParam;
    }
}
