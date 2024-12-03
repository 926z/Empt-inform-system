package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.pojo.Dept;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public void deleteByid(Integer id) {
        deptMapper.deleteByid(id);
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    /**
     * 查找id，为修改功能做准备
     * @param
     * @return
     */
    @Override
    public Dept getByID(Integer id) {
        Dept dept = deptMapper.getByID(id);
        return dept;
    }

    @Override
    public void updateByid(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateByid(dept);
    }

}

