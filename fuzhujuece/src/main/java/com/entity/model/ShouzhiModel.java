package com.entity.model;

import com.entity.ShouzhiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 收支
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShouzhiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 唯一编号
     */
    private String shouzhiUuidNumber;


    /**
     * 收支名称
     */
    private String shouzhiName;


    /**
     * 收支类型
     */
    private Integer shouzhiTypes;


    /**
     * 二级类型
     */
    private Integer shouzhiErjiTypes;


    /**
     * 收支金额
     */
    private Double shouzhiMoney;


    /**
     * 收支详情
     */
    private String shouzhiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 nameShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：唯一编号
	 */
    public String getShouzhiUuidNumber() {
        return shouzhiUuidNumber;
    }


    /**
	 * 设置：唯一编号
	 */
    public void setShouzhiUuidNumber(String shouzhiUuidNumber) {
        this.shouzhiUuidNumber = shouzhiUuidNumber;
    }
    /**
	 * 获取：收支名称
	 */
    public String getShouzhiName() {
        return shouzhiName;
    }


    /**
	 * 设置：收支名称
	 */
    public void setShouzhiName(String shouzhiName) {
        this.shouzhiName = shouzhiName;
    }
    /**
	 * 获取：收支类型
	 */
    public Integer getShouzhiTypes() {
        return shouzhiTypes;
    }


    /**
	 * 设置：收支类型
	 */
    public void setShouzhiTypes(Integer shouzhiTypes) {
        this.shouzhiTypes = shouzhiTypes;
    }
    /**
	 * 获取：二级类型
	 */
    public Integer getShouzhiErjiTypes() {
        return shouzhiErjiTypes;
    }


    /**
	 * 设置：二级类型
	 */
    public void setShouzhiErjiTypes(Integer shouzhiErjiTypes) {
        this.shouzhiErjiTypes = shouzhiErjiTypes;
    }
    /**
	 * 获取：收支金额
	 */
    public Double getShouzhiMoney() {
        return shouzhiMoney;
    }


    /**
	 * 设置：收支金额
	 */
    public void setShouzhiMoney(Double shouzhiMoney) {
        this.shouzhiMoney = shouzhiMoney;
    }
    /**
	 * 获取：收支详情
	 */
    public String getShouzhiContent() {
        return shouzhiContent;
    }


    /**
	 * 设置：收支详情
	 */
    public void setShouzhiContent(String shouzhiContent) {
        this.shouzhiContent = shouzhiContent;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 nameShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 nameShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
