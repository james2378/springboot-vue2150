package com.entity.view;

import com.entity.ShouzhiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 收支
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shouzhi")
public class ShouzhiView extends ShouzhiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 收支类型的值
		*/
		private String shouzhiValue;
		/**
		* 二级类型的值
		*/
		private String shouzhiErjiValue;



	public ShouzhiView() {

	}

	public ShouzhiView(ShouzhiEntity shouzhiEntity) {
		try {
			BeanUtils.copyProperties(this, shouzhiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 收支类型的值
			*/
			public String getShouzhiValue() {
				return shouzhiValue;
			}
			/**
			* 设置： 收支类型的值
			*/
			public void setShouzhiValue(String shouzhiValue) {
				this.shouzhiValue = shouzhiValue;
			}
			/**
			* 获取： 二级类型的值
			*/
			public String getShouzhiErjiValue() {
				return shouzhiErjiValue;
			}
			/**
			* 设置： 二级类型的值
			*/
			public void setShouzhiErjiValue(String shouzhiErjiValue) {
				this.shouzhiErjiValue = shouzhiErjiValue;
			}









}
