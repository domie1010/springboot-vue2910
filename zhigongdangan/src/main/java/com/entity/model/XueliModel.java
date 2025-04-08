package com.entity.model;

import com.entity.XueliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 学历档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class XueliModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 职工
     */
    private Integer yonghuId;


    /**
     * 档案编号
     */
    private String xueliUuidNumber;


    /**
     * 档案标题
     */
    private String xueliName;


    /**
     * 文件上传
     */
    private String xueliFile;


    /**
     * 学历取得时间
     */
    private String xueliShijian;


    /**
     * 学校
     */
    private String xueliXuexuiao;


    /**
     * 学历
     */
    private Integer xueliTypes;


    /**
     * 档案简介
     */
    private String xueliText;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：职工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：职工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：档案编号
	 */
    public String getXueliUuidNumber() {
        return xueliUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setXueliUuidNumber(String xueliUuidNumber) {
        this.xueliUuidNumber = xueliUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getXueliName() {
        return xueliName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setXueliName(String xueliName) {
        this.xueliName = xueliName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getXueliFile() {
        return xueliFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setXueliFile(String xueliFile) {
        this.xueliFile = xueliFile;
    }
    /**
	 * 获取：学历取得时间
	 */
    public String getXueliShijian() {
        return xueliShijian;
    }


    /**
	 * 设置：学历取得时间
	 */
    public void setXueliShijian(String xueliShijian) {
        this.xueliShijian = xueliShijian;
    }
    /**
	 * 获取：学校
	 */
    public String getXueliXuexuiao() {
        return xueliXuexuiao;
    }


    /**
	 * 设置：学校
	 */
    public void setXueliXuexuiao(String xueliXuexuiao) {
        this.xueliXuexuiao = xueliXuexuiao;
    }
    /**
	 * 获取：学历
	 */
    public Integer getXueliTypes() {
        return xueliTypes;
    }


    /**
	 * 设置：学历
	 */
    public void setXueliTypes(Integer xueliTypes) {
        this.xueliTypes = xueliTypes;
    }
    /**
	 * 获取：档案简介
	 */
    public String getXueliText() {
        return xueliText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setXueliText(String xueliText) {
        this.xueliText = xueliText;
    }
    /**
	 * 获取：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
