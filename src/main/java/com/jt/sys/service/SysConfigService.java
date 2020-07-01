package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.SysConfig;

public interface SysConfigService {
    /**
     * @param name
     * @param pageCurrent
     */
    PageObject<SysConfig> findPageObjects(String name, Integer pageCurrent);





    PageObject<SysConfig> updatePageObjects(String name, Integer pageCurrent);
}
