package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;




    //    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        Long count=empMapper.count();
//        Integer start =(page-1)*pageSize;
//        List<Emp> emps=empMapper.page(start,pageSize);
//        PageBean pageBean =new PageBean(count,emps);
//        return pageBean;
//    }
    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
//            1.设置分页查询
        PageHelper.startPage(page, pageSize);
//            2.执行查询
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> pagelist = (Page<Emp>) empList;
//            3.封装PageBean对象
        PageBean pageBean = new PageBean(pagelist.getTotal(), pagelist.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.GetUserNameAndPassord(emp);
    }
}
