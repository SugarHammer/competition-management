package com.example.entity;

import javax.persistence.*;

@Table(name = "comment_info")
public class CommentInfo {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 评价内容
     */
    private String content;

    /**
     * 所属商品
     */
    @Column(name = "shujuid")
    private Long shujuid;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private String createTime;

    @Column(name = "userId")
    private Long userId;

    @Column(name = "level")
    private String level;

    @Column(name = "biao")
    private String biao;

    @Transient
    private String goodsName;

    @Transient
    private String userName;

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取评价内容
     *
     * @return content - 评价内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评价内容
     *
     * @param content 评价内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取所属商品
     *
     * @return goodsId - 所属商品
     */
    public Long getShujuid() {
        return shujuid;
    }

    /**
     * 设置所属商品
     *
     * @param goodsId 所属商品
     */
    public void setShujuid(Long shujuid) {
        this.shujuid = shujuid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBiao() {
        return biao;
    }

    public void setBiao(String biao) {
        this.biao = biao;
    }
}