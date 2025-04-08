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
 * 工资晋级档案
 *
 * @author 
 * @email
 */
@TableName("gongzijishengjinsheng")
public class GongzijishengjinshengEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public GongzijishengjinshengEntity() {

	}

	public GongzijishengjinshengEntity(T t) {
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
    @TableField(value = "gongzijishengjinsheng_uuid_number")

    private String gongzijishengjinshengUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "gongzijishengjinsheng_name")

    private String gongzijishengjinshengName;


    /**
     * 文件上传
     */
    @TableField(value = "gongzijishengjinsheng_file")

    private String gongzijishengjinshengFile;


    /**
     * 原工资
     */
    @TableField(value = "gongzijishengjinsheng_shijian")

    private String gongzijishengjinshengShijian;


    /**
     * 晋级后工作
     */
    @TableField(value = "gongzijishengjinsheng_xuexuiao")

    private String gongzijishengjinshengXuexuiao;


    /**
     * 晋升原因
     */
    @TableField(value = "gongzijishengjinsheng_xinzhi")

    private Double gongzijishengjinshengXinzhi;


    /**
     * 档案简介
     */
    @TableField(value = "gongzijishengjinsheng_text")

    private String gongzijishengjinshengText;


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
    public String getGongzijishengjinshengUuidNumber() {
        return gongzijishengjinshengUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setGongzijishengjinshengUuidNumber(String gongzijishengjinshengUuidNumber) {
        this.gongzijishengjinshengUuidNumber = gongzijishengjinshengUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getGongzijishengjinshengName() {
        return gongzijishengjinshengName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setGongzijishengjinshengName(String gongzijishengjinshengName) {
        this.gongzijishengjinshengName = gongzijishengjinshengName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getGongzijishengjinshengFile() {
        return gongzijishengjinshengFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setGongzijishengjinshengFile(String gongzijishengjinshengFile) {
        this.gongzijishengjinshengFile = gongzijishengjinshengFile;
    }
    /**
	 * 设置：原工资
	 */
    public String getGongzijishengjinshengShijian() {
        return gongzijishengjinshengShijian;
    }


    /**
	 * 获取：原工资
	 */

    public void setGongzijishengjinshengShijian(String gongzijishengjinshengShijian) {
        this.gongzijishengjinshengShijian = gongzijishengjinshengShijian;
    }
    /**
	 * 设置：晋级后工作
	 */
    public String getGongzijishengjinshengXuexuiao() {
        return gongzijishengjinshengXuexuiao;
    }


    /**
	 * 获取：晋级后工作
	 */

    public void setGongzijishengjinshengXuexuiao(String gongzijishengjinshengXuexuiao) {
        this.gongzijishengjinshengXuexuiao = gongzijishengjinshengXuexuiao;
    }
    /**
	 * 设置：晋升原因
	 */
    public Double getGongzijishengjinshengXinzhi() {
        return gongzijishengjinshengXinzhi;
    }


    /**
	 * 获取：晋升原因
	 */

    public void setGongzijishengjinshengXinzhi(Double gongzijishengjinshengXinzhi) {
        this.gongzijishengjinshengXinzhi = gongzijishengjinshengXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getGongzijishengjinshengText() {
        return gongzijishengjinshengText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setGongzijishengjinshengText(String gongzijishengjinshengText) {
        this.gongzijishengjinshengText = gongzijishengjinshengText;
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
        return "Gongzijishengjinsheng{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", gongzijishengjinshengUuidNumber=" + gongzijishengjinshengUuidNumber +
            ", gongzijishengjinshengName=" + gongzijishengjinshengName +
            ", gongzijishengjinshengFile=" + gongzijishengjinshengFile +
            ", gongzijishengjinshengShijian=" + gongzijishengjinshengShijian +
            ", gongzijishengjinshengXuexuiao=" + gongzijishengjinshengXuexuiao +
            ", gongzijishengjinshengXinzhi=" + gongzijishengjinshengXinzhi +
            ", gongzijishengjinshengText=" + gongzijishengjinshengText +
            ", createTime=" + createTime +
        "}";
    }
}
