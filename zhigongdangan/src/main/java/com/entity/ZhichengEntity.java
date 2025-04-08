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
 * 职称档案
 *
 * @author 
 * @email
 */
@TableName("zhicheng")
public class ZhichengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ZhichengEntity() {

	}

	public ZhichengEntity(T t) {
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
    @TableField(value = "zhicheng_uuid_number")

    private String zhichengUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "zhicheng_name")

    private String zhichengName;


    /**
     * 文件上传
     */
    @TableField(value = "zhicheng_file")

    private String zhichengFile;


    /**
     * 工作时间
     */
    @TableField(value = "zhicheng_shijian")

    private String zhichengShijian;


    /**
     * 职称
     */
    @TableField(value = "zhicheng_xuexuiao")

    private String zhichengXuexuiao;


    /**
     * 薪资
     */
    @TableField(value = "zhicheng_xinzhi")

    private Double zhichengXinzhi;


    /**
     * 档案简介
     */
    @TableField(value = "zhicheng_text")

    private String zhichengText;


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
    public String getZhichengUuidNumber() {
        return zhichengUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setZhichengUuidNumber(String zhichengUuidNumber) {
        this.zhichengUuidNumber = zhichengUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getZhichengName() {
        return zhichengName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setZhichengName(String zhichengName) {
        this.zhichengName = zhichengName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getZhichengFile() {
        return zhichengFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setZhichengFile(String zhichengFile) {
        this.zhichengFile = zhichengFile;
    }
    /**
	 * 设置：工作时间
	 */
    public String getZhichengShijian() {
        return zhichengShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setZhichengShijian(String zhichengShijian) {
        this.zhichengShijian = zhichengShijian;
    }
    /**
	 * 设置：职称
	 */
    public String getZhichengXuexuiao() {
        return zhichengXuexuiao;
    }


    /**
	 * 获取：职称
	 */

    public void setZhichengXuexuiao(String zhichengXuexuiao) {
        this.zhichengXuexuiao = zhichengXuexuiao;
    }
    /**
	 * 设置：薪资
	 */
    public Double getZhichengXinzhi() {
        return zhichengXinzhi;
    }


    /**
	 * 获取：薪资
	 */

    public void setZhichengXinzhi(Double zhichengXinzhi) {
        this.zhichengXinzhi = zhichengXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getZhichengText() {
        return zhichengText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setZhichengText(String zhichengText) {
        this.zhichengText = zhichengText;
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
        return "Zhicheng{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", zhichengUuidNumber=" + zhichengUuidNumber +
            ", zhichengName=" + zhichengName +
            ", zhichengFile=" + zhichengFile +
            ", zhichengShijian=" + zhichengShijian +
            ", zhichengXuexuiao=" + zhichengXuexuiao +
            ", zhichengXinzhi=" + zhichengXinzhi +
            ", zhichengText=" + zhichengText +
            ", createTime=" + createTime +
        "}";
    }
}
