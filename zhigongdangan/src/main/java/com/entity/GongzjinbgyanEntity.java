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
 * 工作经历档案
 *
 * @author 
 * @email
 */
@TableName("gongzjinbgyan")
public class GongzjinbgyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzjinbgyanEntity() {

	}

	public GongzjinbgyanEntity(T t) {
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
    @TableField(value = "gongzjinbgyan_uuid_number")

    private String gongzjinbgyanUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "gongzjinbgyan_name")

    private String gongzjinbgyanName;


    /**
     * 文件上传
     */
    @TableField(value = "gongzjinbgyan_file")

    private String gongzjinbgyanFile;


    /**
     * 工作时间
     */
    @TableField(value = "gongzjinbgyan_shijian")

    private String gongzjinbgyanShijian;


    /**
     * 公司
     */
    @TableField(value = "gongzjinbgyan_xuexuiao")

    private String gongzjinbgyanXuexuiao;


    /**
     * 薪资
     */
    @TableField(value = "gongzjinbgyan_xinzhi")

    private Double gongzjinbgyanXinzhi;


    /**
     * 档案简介
     */
    @TableField(value = "gongzjinbgyan_text")

    private String gongzjinbgyanText;


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
    public String getGongzjinbgyanUuidNumber() {
        return gongzjinbgyanUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setGongzjinbgyanUuidNumber(String gongzjinbgyanUuidNumber) {
        this.gongzjinbgyanUuidNumber = gongzjinbgyanUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getGongzjinbgyanName() {
        return gongzjinbgyanName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setGongzjinbgyanName(String gongzjinbgyanName) {
        this.gongzjinbgyanName = gongzjinbgyanName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getGongzjinbgyanFile() {
        return gongzjinbgyanFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setGongzjinbgyanFile(String gongzjinbgyanFile) {
        this.gongzjinbgyanFile = gongzjinbgyanFile;
    }
    /**
	 * 设置：工作时间
	 */
    public String getGongzjinbgyanShijian() {
        return gongzjinbgyanShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setGongzjinbgyanShijian(String gongzjinbgyanShijian) {
        this.gongzjinbgyanShijian = gongzjinbgyanShijian;
    }
    /**
	 * 设置：公司
	 */
    public String getGongzjinbgyanXuexuiao() {
        return gongzjinbgyanXuexuiao;
    }


    /**
	 * 获取：公司
	 */

    public void setGongzjinbgyanXuexuiao(String gongzjinbgyanXuexuiao) {
        this.gongzjinbgyanXuexuiao = gongzjinbgyanXuexuiao;
    }
    /**
	 * 设置：薪资
	 */
    public Double getGongzjinbgyanXinzhi() {
        return gongzjinbgyanXinzhi;
    }


    /**
	 * 获取：薪资
	 */

    public void setGongzjinbgyanXinzhi(Double gongzjinbgyanXinzhi) {
        this.gongzjinbgyanXinzhi = gongzjinbgyanXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getGongzjinbgyanText() {
        return gongzjinbgyanText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setGongzjinbgyanText(String gongzjinbgyanText) {
        this.gongzjinbgyanText = gongzjinbgyanText;
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
        return "Gongzjinbgyan{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongzjinbgyanUuidNumber=" + gongzjinbgyanUuidNumber +
            ", gongzjinbgyanName=" + gongzjinbgyanName +
            ", gongzjinbgyanFile=" + gongzjinbgyanFile +
            ", gongzjinbgyanShijian=" + gongzjinbgyanShijian +
            ", gongzjinbgyanXuexuiao=" + gongzjinbgyanXuexuiao +
            ", gongzjinbgyanXinzhi=" + gongzjinbgyanXinzhi +
            ", gongzjinbgyanText=" + gongzjinbgyanText +
            ", createTime=" + createTime +
        "}";
    }
}
