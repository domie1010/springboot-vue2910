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
 * 社会保险档案
 *
 * @author 
 * @email
 */
@TableName("shehuibaoxian")
public class ShehuibaoxianEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShehuibaoxianEntity() {

	}

	public ShehuibaoxianEntity(T t) {
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
    @TableField(value = "shehuibaoxian_uuid_number")

    private String shehuibaoxianUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "shehuibaoxian_name")

    private String shehuibaoxianName;


    /**
     * 文件上传
     */
    @TableField(value = "shehuibaoxian_file")

    private String shehuibaoxianFile;


    /**
     * 保险名称
     */
    @TableField(value = "shehuibaoxian_shijian")

    private String shehuibaoxianShijian;


    /**
     * 保险描述
     */
    @TableField(value = "shehuibaoxian_text")

    private String shehuibaoxianText;


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
    public String getShehuibaoxianUuidNumber() {
        return shehuibaoxianUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setShehuibaoxianUuidNumber(String shehuibaoxianUuidNumber) {
        this.shehuibaoxianUuidNumber = shehuibaoxianUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getShehuibaoxianName() {
        return shehuibaoxianName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setShehuibaoxianName(String shehuibaoxianName) {
        this.shehuibaoxianName = shehuibaoxianName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getShehuibaoxianFile() {
        return shehuibaoxianFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setShehuibaoxianFile(String shehuibaoxianFile) {
        this.shehuibaoxianFile = shehuibaoxianFile;
    }
    /**
	 * 设置：保险名称
	 */
    public String getShehuibaoxianShijian() {
        return shehuibaoxianShijian;
    }


    /**
	 * 获取：保险名称
	 */

    public void setShehuibaoxianShijian(String shehuibaoxianShijian) {
        this.shehuibaoxianShijian = shehuibaoxianShijian;
    }
    /**
	 * 设置：保险描述
	 */
    public String getShehuibaoxianText() {
        return shehuibaoxianText;
    }


    /**
	 * 获取：保险描述
	 */

    public void setShehuibaoxianText(String shehuibaoxianText) {
        this.shehuibaoxianText = shehuibaoxianText;
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
        return "Shehuibaoxian{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", shehuibaoxianUuidNumber=" + shehuibaoxianUuidNumber +
            ", shehuibaoxianName=" + shehuibaoxianName +
            ", shehuibaoxianFile=" + shehuibaoxianFile +
            ", shehuibaoxianShijian=" + shehuibaoxianShijian +
            ", shehuibaoxianText=" + shehuibaoxianText +
            ", createTime=" + createTime +
        "}";
    }
}
