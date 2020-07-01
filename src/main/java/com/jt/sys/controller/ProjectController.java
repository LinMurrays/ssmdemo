package com.jt.sys.controller;

import com.jt.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/")
public class ProjectController {
    @Autowired//按类型为属性注入值
    private SysConfigService sysConfigService;

    @RequestMapping("doConfigListUI")
    public String doConfigListUI() {
        //return "config-ajax";
        return "config-jquery-ajax";
    }


}
