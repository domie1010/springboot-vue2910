package com.entity.model;

import com.entity.GongzjinbgyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工作经历档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzjinbgyanModel implements Serializable {
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
    private String gongzjinbgyanUuidNumber;


    /**
     * 档案标题
     */
    private String gongzjinbgyanName;


    /**
     * 文件上传
     */
    private String gongzjinbgyanFile;


    /**
     * 工作时间
     */
    private String gongzjinbgyanShijian;


    /**
     * 公司
     */
    private String gongzjinbgyanXuexuiao;


    /**
     * 薪资
     */
    private Double gongzjinbgyanXinzhi;


    /**
     * 档案简介
     */
    private String gongzjinbgyanText;


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
    public String getGongzjinbgyanUuidNumber() {
        return gongzjinbgyanUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setGongzjinbgyanUuidNumber(String gongzjinbgyanUuidNumber) {
        this.gongzjinbgyanUuidNumber = gongzjinbgyanUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getGongzjinbgyanName() {
        return gongzjinbgyanName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setGongzjinbgyanName(String gongzjinbgyanName) {
        this.gongzjinbgyanName = gongzjinbgyanName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getGongzjinbgyanFile() {
        return gongzjinbgyanFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setGongzjinbgyanFile(String gongzjinbgyanFile) {
        this.gongzjinbgyanFile = gongzjinbgyanFile;
    }
    /**
	 * 获取：工作时间
	 */
    public String getGongzjinbgyanShijian() {
        return gongzjinbgyanShijian;
    }


    /**
	 * 设置：工作时间
	 */
    public void setGongzjinbgyanShijian(String gongzjinbgyanShijian) {
        this.gongzjinbgyanShijian = gongzjinbgyanShijian;
    }
    /**
	 * 获取：公司
	 */
    public String getGongzjinbgyanXuexuiao() {
        return gongzjinbgyanXuexuiao;
    }


    /**
	 * 设置：公司
	 */
    public void setGongzjinbgyanXuexuiao(String gongzjinbgyanXuexuiao) {
        this.gongzjinbgyanXuexuiao = gongzjinbgyanXuexuiao;
    }
    /**
	 * 获取：薪资
	 */
    public Double getGongzjinbgyanXinzhi() {
        return gongzjinbgyanXinzhi;
    }


    /**
	 * 设置：薪资
	 */
    public void setGongzjinbgyanXinzhi(Double gongzjinbgyanXinzhi) {
        this.gongzjinbgyanXinzhi = gongzjinbgyanXinzhi;
    }
    /**
	 * 获取：档案简介
	 */
    public String getGongzjinbgyanText() {
        return gongzjinbgyanText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setGongzjinbgyanText(String gongzjinbgyanText) {
        this.gongzjinbgyanText = gongzjinbgyanText;
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
