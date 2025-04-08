package com.entity.model;

import com.entity.ZhengshenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 政审档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhengshenModel implements Serializable {
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
    private String zhengshenUuidNumber;


    /**
     * 档案标题
     */
    private String zhengshenName;


    /**
     * 文件上传
     */
    private String zhengshenFile;


    /**
     * 政审
     */
    private String zhengshenShijian;


    /**
     * 政审描述
     */
    private String zhengshenText;


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
    public String getZhengshenUuidNumber() {
        return zhengshenUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setZhengshenUuidNumber(String zhengshenUuidNumber) {
        this.zhengshenUuidNumber = zhengshenUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getZhengshenName() {
        return zhengshenName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setZhengshenName(String zhengshenName) {
        this.zhengshenName = zhengshenName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getZhengshenFile() {
        return zhengshenFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setZhengshenFile(String zhengshenFile) {
        this.zhengshenFile = zhengshenFile;
    }
    /**
	 * 获取：政审
	 */
    public String getZhengshenShijian() {
        return zhengshenShijian;
    }


    /**
	 * 设置：政审
	 */
    public void setZhengshenShijian(String zhengshenShijian) {
        this.zhengshenShijian = zhengshenShijian;
    }
    /**
	 * 获取：政审描述
	 */
    public String getZhengshenText() {
        return zhengshenText;
    }


    /**
	 * 设置：政审描述
	 */
    public void setZhengshenText(String zhengshenText) {
        this.zhengshenText = zhengshenText;
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
