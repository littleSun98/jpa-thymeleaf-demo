package com.fly.controller;

import com.fly.po.User;
import com.fly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    //新增用户
    @RequestMapping("/toAdd")
    public String toAdd(User user){
        return "add";
    }
    //点击保存按钮，保存新增用户数据
    @PostMapping("/add")
    public String add(User user){
        userService.add(user);
        return "redirect:/";
    }

    //跳转到编辑页面
    @GetMapping("/toEdit/{id}")
    public String toEdit(@PathVariable("id") Long id, Model model){
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        return "edit";
    }
    //保存修改数据
    @PostMapping("/update")
    public String update(User user){
        userService.update(user.getId(),user);
        return "redirect:/";
    }

    //删除
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }

    //查询全部
    @GetMapping("/")
    public String findAll(Model model){
        List<User> list = userService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    //测试分支合并
    public void test(){
        System.out.println("啦啦啦啦啦");
    }
}
