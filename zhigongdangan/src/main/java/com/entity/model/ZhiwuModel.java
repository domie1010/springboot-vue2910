package com.entity.model;

import com.entity.ZhiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 职务档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhiwuModel implements Serializable {
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
    private String zhiwuUuidNumber;


    /**
     * 档案标题
     */
    private String zhiwuName;


    /**
     * 文件上传
     */
    private String zhiwuFile;


    /**
     * 工作时间
     */
    private String zhiwuShijian;


    /**
     * 职务
     */
    private String zhiwuXuexuiao;


    /**
     * 档案简介
     */
    private String zhiwuText;


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
    public String getZhiwuUuidNumber() {
        return zhiwuUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setZhiwuUuidNumber(String zhiwuUuidNumber) {
        this.zhiwuUuidNumber = zhiwuUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getZhiwuName() {
        return zhiwuName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setZhiwuName(String zhiwuName) {
        this.zhiwuName = zhiwuName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getZhiwuFile() {
        return zhiwuFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setZhiwuFile(String zhiwuFile) {
        this.zhiwuFile = zhiwuFile;
    }
    /**
	 * 获取：工作时间
	 */
    public String getZhiwuShijian() {
        return zhiwuShijian;
    }


    /**
	 * 设置：工作时间
	 */
    public void setZhiwuShijian(String zhiwuShijian) {
        this.zhiwuShijian = zhiwuShijian;
    }
    /**
	 * 获取：职务
	 */
    public String getZhiwuXuexuiao() {
        return zhiwuXuexuiao;
    }


    /**
	 * 设置：职务
	 */
    public void setZhiwuXuexuiao(String zhiwuXuexuiao) {
        this.zhiwuXuexuiao = zhiwuXuexuiao;
    }
    /**
	 * 获取：档案简介
	 */
    public String getZhiwuText() {
        return zhiwuText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setZhiwuText(String zhiwuText) {
        this.zhiwuText = zhiwuText;
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
