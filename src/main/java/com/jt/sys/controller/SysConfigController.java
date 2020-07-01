package com.jt.sys.controller;

import com.jt.common.vo.JsonResult;
import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;
import com.jt.sys.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/config/")
public class SysConfigController {
    @Autowired//按类型为属性注入值
    private SysConfigService sysConfigService;

    @RequestMapping("doConfigListUI")
    public String doConfigListUI() {
        //return "config-ajax";
        return "config-jquery-ajax";
    }

    @RequestMapping(value = "doFindPageObjects", produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
        PageObject<SysConfig> pageObject = sysConfigService.findPageObjects(name, pageCurrent);
        System.out.println(pageObject.getRecords());
        return new JsonResult(pageObject);
    }

    @RequestMapping(value = "updatePageObjects", produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult updatePageObjects(String name, Integer pageCurrent) {
        sysConfigService.updatePageObjects(name, pageCurrent);
        return null;
    }


}
