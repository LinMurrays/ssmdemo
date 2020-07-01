package com.jt.sys.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * pojo
 *
 * @author we are young
 */
public class Project implements Serializable {
    private static final long serialVersionUID = 6787816067025596323L;
    private Integer id;
    /**
     * 参数名
     */
    private String name;

    /**
     * 参数备注
     */
    private String note;
    /**
     * 创建时间
     */
    private Date createdTime;
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
