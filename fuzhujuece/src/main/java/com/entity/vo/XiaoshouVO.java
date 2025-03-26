package com.entity.vo;

import com.entity.XiaoshouEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 销售订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("xiaoshou")
public class XiaoshouVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 唯一编号
     */

    @TableField(value = "xiaoshou_uuid_number")
    private String xiaoshouUuidNumber;


    /**
     * 员工
     */

    @TableField(value = "yuangong_id")
    private Integer yuangongId;


    /**
     * 销售名称
     */

    @TableField(value = "xiaoshou_name")
    private String xiaoshouName;


    /**
     * 销售数量
     */

    @TableField(value = "xiaoshou_number")
    private Integer xiaoshouNumber;


    /**
     * 销售类型
     */

    @TableField(value = "xiaoshou_types")
    private Integer xiaoshouTypes;


    /**
     * 销售时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "xiaoshou_time")
    private Date xiaoshouTime;


    /**
     * 销售金额
     */

    @TableField(value = "xiaoshou_jine")
    private Double xiaoshouJine;


    /**
     * 销售备注
     */

    @TableField(value = "xiaoshou_content")
    private String xiaoshouContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：唯一编号
	 */
    public String getXiaoshouUuidNumber() {
        return xiaoshouUuidNumber;
    }


    /**
	 * 获取：唯一编号
	 */

    public void setXiaoshouUuidNumber(String xiaoshouUuidNumber) {
        this.xiaoshouUuidNumber = xiaoshouUuidNumber;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYuangongId() {
        return yuangongId;
    }


    /**
	 * 获取：员工
	 */

    public void setYuangongId(Integer yuangongId) {
        this.yuangongId = yuangongId;
    }
    /**
	 * 设置：销售名称
	 */
    public String getXiaoshouName() {
        return xiaoshouName;
    }


    /**
	 * 获取：销售名称
	 */

    public void setXiaoshouName(String xiaoshouName) {
        this.xiaoshouName = xiaoshouName;
    }
    /**
	 * 设置：销售数量
	 */
    public Integer getXiaoshouNumber() {
        return xiaoshouNumber;
    }


    /**
	 * 获取：销售数量
	 */

    public void setXiaoshouNumber(Integer xiaoshouNumber) {
        this.xiaoshouNumber = xiaoshouNumber;
    }
    /**
	 * 设置：销售类型
	 */
    public Integer getXiaoshouTypes() {
        return xiaoshouTypes;
    }


    /**
	 * 获取：销售类型
	 */

    public void setXiaoshouTypes(Integer xiaoshouTypes) {
        this.xiaoshouTypes = xiaoshouTypes;
    }
    /**
	 * 设置：销售时间
	 */
    public Date getXiaoshouTime() {
        return xiaoshouTime;
    }


    /**
	 * 获取：销售时间
	 */

    public void setXiaoshouTime(Date xiaoshouTime) {
        this.xiaoshouTime = xiaoshouTime;
    }
    /**
	 * 设置：销售金额
	 */
    public Double getXiaoshouJine() {
        return xiaoshouJine;
    }


    /**
	 * 获取：销售金额
	 */

    public void setXiaoshouJine(Double xiaoshouJine) {
        this.xiaoshouJine = xiaoshouJine;
    }
    /**
	 * 设置：销售备注
	 */
    public String getXiaoshouContent() {
        return xiaoshouContent;
    }


    /**
	 * 获取：销售备注
	 */

    public void setXiaoshouContent(String xiaoshouContent) {
        this.xiaoshouContent = xiaoshouContent;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
