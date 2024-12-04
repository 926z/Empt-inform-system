package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("depts")
@RestController
public class DeptCotroller {
    /**
     *查询部门
     */
    @Autowired
    private DeptService deptService;
    @GetMapping
    public Result list(){
        log.info("成功查询到数据");
//        调用service来查询
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id进行删除部门:{}",id);
        deptService.deleteByid(id);
        return Result.success();

    }

    /**
     * 新增部门
     * @return
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增的部门");
        deptService.add(dept);
        return Result.success();

    }

    /**
     * 查找id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result find(@PathVariable Integer id){
        log.info("成功查找到id");
        Dept dept = deptService.getByID(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result alter(@RequestBody Dept dept){
        log.info("删除部门：{}",dept);
        deptService.updateByid(dept);
        return Result.success();
    }

}
