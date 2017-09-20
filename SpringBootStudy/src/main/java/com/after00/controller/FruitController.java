package com.after00.controller;

import com.after00.common.Result;
import com.after00.common.ResultUtil;
import com.after00.dao.IFruitDao;
import com.after00.dao.impl.FruitDaoImpl;
import com.after00.model.Fruit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by xiaofan on 2017/4/4.
 */
@RestController
public class FruitController {
    private final static Logger logger = LoggerFactory.getLogger(FruitController.class);

    @Autowired
    private IFruitDao fruitDao;
    @Autowired
    private FruitDaoImpl fruitDaoImpl;

    /**
     * Get请求查询所有fruit列表
     *
     * @return fruits
     */
    @GetMapping(value = "/fruits")
    public List<Fruit> fruitList() {
        logger.info("fruitList");
        return fruitDao.findAll();
    }

    /**
     * Post请求添加一条Fruit数据
     * 验证结果存放于BindingResult
     *
     * @return
     */
    @PostMapping(value = "/fruits")
//    public Fruit fruitAdd(@RequestParam("color") String color, @RequestParam("size") Integer size) {
    public Result<Fruit> fruitAdd(@Valid Fruit fruit, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String msg = bindingResult.getFieldError().getDefaultMessage();
            return ResultUtil.error(0, msg);
        }
        Fruit save = fruitDao.save(fruit);
        return ResultUtil.success(save);
    }

    /**
     * 通过ID查询数据（数据库无数据将返回null）
     */
    @GetMapping(value = "/fruits/{id}")
    public Fruit fruitFindOne(@PathVariable("id") Integer id) {
        logger.info("fruitFindOne");
        return fruitDao.findOne(id);
    }

    /**
     * 通过ID更新数据
     */
    @PutMapping(value = "/fruits/{id}")
    public Fruit fruitUpdate(@PathVariable("id") Integer id, @RequestParam("color") String color, @RequestParam("size") Integer size) {
        Fruit fruit = new Fruit(color, size);
        fruit.setId(id);
        return fruitDao.save(fruit);
    }

    /**
     * 通过ID删除数据
     */
    @DeleteMapping(value = "/fruits/{id}")
    public void fruitDelete(@PathVariable("id") Integer id) {
        fruitDao.delete(id);
    }

    /**
     * 通过size查询数据(url:port/fruits/size/22)
     */
    @GetMapping(value = "/fruits/size/{size}")
    public List<Fruit> fruitListBySize(@PathVariable("size") Integer size) {
        return fruitDao.findBySize(size);
    }

    @PostMapping(value = "/fruits/insertList")
    public void insertList() {
        fruitDaoImpl.insertList();
    }

    @GetMapping(value = "/fruits/getSize/{id}")
    public void getSize(@PathVariable("id") Integer id) throws Exception {
        fruitDaoImpl.getSize(id);
    }

}
