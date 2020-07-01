package com.jt.sys.dao;

import com.jt.sys.entity.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysConfigDao {
    /**
     * 依据条件进行分页查询
     *
     * @param name       查询条件
     * @param startIndex 查询的起始位置
     * @param pageSize   每页最多显示多少条记录
     * @return
     */
    List<SysConfig> findPageObjects(@Param("name") String name, @Param("startIndex") Integer startIndex,
                                    @Param("pageSize") Integer pageSize);

    /**
     * 依据条件统计记录总数
     *
     * @param name
     * @return
     */
    int getRowCount(@Param("name") String name);

    void insert();

    void update();
}
