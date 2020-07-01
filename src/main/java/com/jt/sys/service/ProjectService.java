package com.jt.sys.service;

import com.jt.common.vo.PageObject;
import com.jt.sys.entity.Project;

public interface ProjectService {
    /**
     * @param name
     * @param pageCurrent
     */
    PageObject<Project> findPageObjects(String name, Integer pageCurrent);


}
