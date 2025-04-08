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
 * 学历档案
 *
 * @author 
 * @email
 */
@TableName("xueli")
public class XueliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public XueliEntity() {

	}

	public XueliEntity(T t) {
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
     * 职工
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 档案编号
     */
    @TableField(value = "xueli_uuid_number")

    private String xueliUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "xueli_name")

    private String xueliName;


    /**
     * 文件上传
     */
    @TableField(value = "xueli_file")

    private String xueliFile;


    /**
     * 学历取得时间
     */
    @TableField(value = "xueli_shijian")

    private String xueliShijian;


    /**
     * 学校
     */
    @TableField(value = "xueli_xuexuiao")

    private String xueliXuexuiao;


    /**
     * 学历
     */
    @TableField(value = "xueli_types")

    private Integer xueliTypes;


    /**
     * 档案简介
     */
    @TableField(value = "xueli_text")

    private String xueliText;


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
	 * 设置：职工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：职工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：档案编号
	 */
    public String getXueliUuidNumber() {
        return xueliUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setXueliUuidNumber(String xueliUuidNumber) {
        this.xueliUuidNumber = xueliUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getXueliName() {
        return xueliName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setXueliName(String xueliName) {
        this.xueliName = xueliName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getXueliFile() {
        return xueliFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setXueliFile(String xueliFile) {
        this.xueliFile = xueliFile;
    }
    /**
	 * 设置：学历取得时间
	 */
    public String getXueliShijian() {
        return xueliShijian;
    }


    /**
	 * 获取：学历取得时间
	 */

    public void setXueliShijian(String xueliShijian) {
        this.xueliShijian = xueliShijian;
    }
    /**
	 * 设置：学校
	 */
    public String getXueliXuexuiao() {
        return xueliXuexuiao;
    }


    /**
	 * 获取：学校
	 */

    public void setXueliXuexuiao(String xueliXuexuiao) {
        this.xueliXuexuiao = xueliXuexuiao;
    }
    /**
	 * 设置：学历
	 */
    public Integer getXueliTypes() {
        return xueliTypes;
    }


    /**
	 * 获取：学历
	 */

    public void setXueliTypes(Integer xueliTypes) {
        this.xueliTypes = xueliTypes;
    }
    /**
	 * 设置：档案简介
	 */
    public String getXueliText() {
        return xueliText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setXueliText(String xueliText) {
        this.xueliText = xueliText;
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
        return "Xueli{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", xueliUuidNumber=" + xueliUuidNumber +
            ", xueliName=" + xueliName +
            ", xueliFile=" + xueliFile +
            ", xueliShijian=" + xueliShijian +
            ", xueliXuexuiao=" + xueliXuexuiao +
            ", xueliTypes=" + xueliTypes +
            ", xueliText=" + xueliText +
            ", createTime=" + createTime +
        "}";
    }
}
