package com.zb.backstage.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "user_label")
public class UserLabel {
    @Id
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "lable_id")
    private String lableId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return lable_id
     */
    public String getLableId() {
        return lableId;
    }

    /**
     * @param lableId
     */
    public void setLableId(String lableId) {
        this.lableId = lableId == null ? null : lableId.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}