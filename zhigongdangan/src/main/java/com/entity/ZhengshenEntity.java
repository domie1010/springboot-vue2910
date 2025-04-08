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
 * 政审档案
 *
 * @author 
 * @email
 */
@TableName("zhengshen")
public class ZhengshenEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhengshenEntity() {

	}

	public ZhengshenEntity(T t) {
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
    @TableField(value = "zhengshen_uuid_number")

    private String zhengshenUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "zhengshen_name")

    private String zhengshenName;


    /**
     * 文件上传
     */
    @TableField(value = "zhengshen_file")

    private String zhengshenFile;


    /**
     * 政审
     */
    @TableField(value = "zhengshen_shijian")

    private String zhengshenShijian;


    /**
     * 政审描述
     */
    @TableField(value = "zhengshen_text")

    private String zhengshenText;


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
    public String getZhengshenUuidNumber() {
        return zhengshenUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setZhengshenUuidNumber(String zhengshenUuidNumber) {
        this.zhengshenUuidNumber = zhengshenUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getZhengshenName() {
        return zhengshenName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setZhengshenName(String zhengshenName) {
        this.zhengshenName = zhengshenName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getZhengshenFile() {
        return zhengshenFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setZhengshenFile(String zhengshenFile) {
        this.zhengshenFile = zhengshenFile;
    }
    /**
	 * 设置：政审
	 */
    public String getZhengshenShijian() {
        return zhengshenShijian;
    }


    /**
	 * 获取：政审
	 */

    public void setZhengshenShijian(String zhengshenShijian) {
        this.zhengshenShijian = zhengshenShijian;
    }
    /**
	 * 设置：政审描述
	 */
    public String getZhengshenText() {
        return zhengshenText;
    }


    /**
	 * 获取：政审描述
	 */

    public void setZhengshenText(String zhengshenText) {
        this.zhengshenText = zhengshenText;
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
        return "Zhengshen{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhengshenUuidNumber=" + zhengshenUuidNumber +
            ", zhengshenName=" + zhengshenName +
            ", zhengshenFile=" + zhengshenFile +
            ", zhengshenShijian=" + zhengshenShijian +
            ", zhengshenText=" + zhengshenText +
            ", createTime=" + createTime +
        "}";
    }
}
