package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 收支
 *
 * @author 
 * @email
 */
@TableName("shouzhi")
public class ShouzhiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShouzhiEntity() {

	}

	public ShouzhiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 唯一编号
     */
    @TableField(value = "shouzhi_uuid_number")

    private String shouzhiUuidNumber;


    /**
     * 收支名称
     */
    @TableField(value = "shouzhi_name")

    private String shouzhiName;


    /**
     * 收支类型
     */
    @TableField(value = "shouzhi_types")

    private Integer shouzhiTypes;


    /**
     * 二级类型
     */
    @TableField(value = "shouzhi_erji_types")

    private Integer shouzhiErjiTypes;


    /**
     * 收支金额
     */
    @TableField(value = "shouzhi_money")

    private Double shouzhiMoney;


    /**
     * 收支详情
     */
    @TableField(value = "shouzhi_content")

    private String shouzhiContent;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
    public String getShouzhiUuidNumber() {
        return shouzhiUuidNumber;
    }
    /**
	 * 获取：唯一编号
	 */

    public void setShouzhiUuidNumber(String shouzhiUuidNumber) {
        this.shouzhiUuidNumber = shouzhiUuidNumber;
    }
    /**
	 * 设置：收支名称
	 */
    public String getShouzhiName() {
        return shouzhiName;
    }
    /**
	 * 获取：收支名称
	 */

    public void setShouzhiName(String shouzhiName) {
        this.shouzhiName = shouzhiName;
    }
    /**
	 * 设置：收支类型
	 */
    public Integer getShouzhiTypes() {
        return shouzhiTypes;
    }
    /**
	 * 获取：收支类型
	 */

    public void setShouzhiTypes(Integer shouzhiTypes) {
        this.shouzhiTypes = shouzhiTypes;
    }
    /**
	 * 设置：二级类型
	 */
    public Integer getShouzhiErjiTypes() {
        return shouzhiErjiTypes;
    }
    /**
	 * 获取：二级类型
	 */

    public void setShouzhiErjiTypes(Integer shouzhiErjiTypes) {
        this.shouzhiErjiTypes = shouzhiErjiTypes;
    }
    /**
	 * 设置：收支金额
	 */
    public Double getShouzhiMoney() {
        return shouzhiMoney;
    }
    /**
	 * 获取：收支金额
	 */

    public void setShouzhiMoney(Double shouzhiMoney) {
        this.shouzhiMoney = shouzhiMoney;
    }
    /**
	 * 设置：收支详情
	 */
    public String getShouzhiContent() {
        return shouzhiContent;
    }
    /**
	 * 获取：收支详情
	 */

    public void setShouzhiContent(String shouzhiContent) {
        this.shouzhiContent = shouzhiContent;
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
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shouzhi{" +
            "id=" + id +
            ", shouzhiUuidNumber=" + shouzhiUuidNumber +
            ", shouzhiName=" + shouzhiName +
            ", shouzhiTypes=" + shouzhiTypes +
            ", shouzhiErjiTypes=" + shouzhiErjiTypes +
            ", shouzhiMoney=" + shouzhiMoney +
            ", shouzhiContent=" + shouzhiContent +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
