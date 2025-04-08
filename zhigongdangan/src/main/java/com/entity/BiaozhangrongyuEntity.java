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
 * 表彰荣誉档案
 *
 * @author 
 * @email
 */
@TableName("biaozhangrongyu")
public class BiaozhangrongyuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BiaozhangrongyuEntity() {

	}

	public BiaozhangrongyuEntity(T t) {
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
    @TableField(value = "biaozhangrongyu_uuid_number")

    private String biaozhangrongyuUuidNumber;


    /**
     * 档案标题
     */
    @TableField(value = "biaozhangrongyu_name")

    private String biaozhangrongyuName;


    /**
     * 文件上传
     */
    @TableField(value = "biaozhangrongyu_file")

    private String biaozhangrongyuFile;


    /**
     * 原因
     */
    @TableField(value = "biaozhangrongyu_shijian")

    private String biaozhangrongyuShijian;


    /**
     * 表彰荣誉
     */
    @TableField(value = "biaozhangrongyu_xuexuiao")

    private String biaozhangrongyuXuexuiao;


    /**
     * 奖金
     */
    @TableField(value = "biaozhangrongyu_xinzhi")

    private Double biaozhangrongyuXinzhi;


    /**
     * 档案简介
     */
    @TableField(value = "biaozhangrongyu_text")

    private String biaozhangrongyuText;


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
    public String getBiaozhangrongyuUuidNumber() {
        return biaozhangrongyuUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setBiaozhangrongyuUuidNumber(String biaozhangrongyuUuidNumber) {
        this.biaozhangrongyuUuidNumber = biaozhangrongyuUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getBiaozhangrongyuName() {
        return biaozhangrongyuName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setBiaozhangrongyuName(String biaozhangrongyuName) {
        this.biaozhangrongyuName = biaozhangrongyuName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getBiaozhangrongyuFile() {
        return biaozhangrongyuFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setBiaozhangrongyuFile(String biaozhangrongyuFile) {
        this.biaozhangrongyuFile = biaozhangrongyuFile;
    }
    /**
	 * 设置：原因
	 */
    public String getBiaozhangrongyuShijian() {
        return biaozhangrongyuShijian;
    }


    /**
	 * 获取：原因
	 */

    public void setBiaozhangrongyuShijian(String biaozhangrongyuShijian) {
        this.biaozhangrongyuShijian = biaozhangrongyuShijian;
    }
    /**
	 * 设置：表彰荣誉
	 */
    public String getBiaozhangrongyuXuexuiao() {
        return biaozhangrongyuXuexuiao;
    }


    /**
	 * 获取：表彰荣誉
	 */

    public void setBiaozhangrongyuXuexuiao(String biaozhangrongyuXuexuiao) {
        this.biaozhangrongyuXuexuiao = biaozhangrongyuXuexuiao;
    }
    /**
	 * 设置：奖金
	 */
    public Double getBiaozhangrongyuXinzhi() {
        return biaozhangrongyuXinzhi;
    }


    /**
	 * 获取：奖金
	 */

    public void setBiaozhangrongyuXinzhi(Double biaozhangrongyuXinzhi) {
        this.biaozhangrongyuXinzhi = biaozhangrongyuXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getBiaozhangrongyuText() {
        return biaozhangrongyuText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setBiaozhangrongyuText(String biaozhangrongyuText) {
        this.biaozhangrongyuText = biaozhangrongyuText;
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
        return "Biaozhangrongyu{" +
            "id=" + id +
            ", yonghuId=" + yonghuId +
            ", biaozhangrongyuUuidNumber=" + biaozhangrongyuUuidNumber +
            ", biaozhangrongyuName=" + biaozhangrongyuName +
            ", biaozhangrongyuFile=" + biaozhangrongyuFile +
            ", biaozhangrongyuShijian=" + biaozhangrongyuShijian +
            ", biaozhangrongyuXuexuiao=" + biaozhangrongyuXuexuiao +
            ", biaozhangrongyuXinzhi=" + biaozhangrongyuXinzhi +
            ", biaozhangrongyuText=" + biaozhangrongyuText +
            ", createTime=" + createTime +
        "}";
    }
}
