package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DeptService {
    /**
     * 查询部门数据
     */
    List<Dept> list();

    /**
     * 删除部门
     *
     * @param id
     */
    void deleteByid(Integer id);

    void add(Dept dept);


    void updateByid(Dept dept);

    Dept getByID(Integer id);
}



