package com.entity.model;

import com.entity.GongzijishengjinshengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 工资晋级档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class GongzijishengjinshengModel implements Serializable {
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
    private String gongzijishengjinshengUuidNumber;


    /**
     * 档案标题
     */
    private String gongzijishengjinshengName;


    /**
     * 文件上传
     */
    private String gongzijishengjinshengFile;


    /**
     * 原工资
     */
    private String gongzijishengjinshengShijian;


    /**
     * 晋级后工作
     */
    private String gongzijishengjinshengXuexuiao;


    /**
     * 晋升原因
     */
    private Double gongzijishengjinshengXinzhi;


    /**
     * 档案简介
     */
    private String gongzijishengjinshengText;


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
    public String getGongzijishengjinshengUuidNumber() {
        return gongzijishengjinshengUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setGongzijishengjinshengUuidNumber(String gongzijishengjinshengUuidNumber) {
        this.gongzijishengjinshengUuidNumber = gongzijishengjinshengUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getGongzijishengjinshengName() {
        return gongzijishengjinshengName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setGongzijishengjinshengName(String gongzijishengjinshengName) {
        this.gongzijishengjinshengName = gongzijishengjinshengName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getGongzijishengjinshengFile() {
        return gongzijishengjinshengFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setGongzijishengjinshengFile(String gongzijishengjinshengFile) {
        this.gongzijishengjinshengFile = gongzijishengjinshengFile;
    }
    /**
	 * 获取：原工资
	 */
    public String getGongzijishengjinshengShijian() {
        return gongzijishengjinshengShijian;
    }


    /**
	 * 设置：原工资
	 */
    public void setGongzijishengjinshengShijian(String gongzijishengjinshengShijian) {
        this.gongzijishengjinshengShijian = gongzijishengjinshengShijian;
    }
    /**
	 * 获取：晋级后工作
	 */
    public String getGongzijishengjinshengXuexuiao() {
        return gongzijishengjinshengXuexuiao;
    }


    /**
	 * 设置：晋级后工作
	 */
    public void setGongzijishengjinshengXuexuiao(String gongzijishengjinshengXuexuiao) {
        this.gongzijishengjinshengXuexuiao = gongzijishengjinshengXuexuiao;
    }
    /**
	 * 获取：晋升原因
	 */
    public Double getGongzijishengjinshengXinzhi() {
        return gongzijishengjinshengXinzhi;
    }


    /**
	 * 设置：晋升原因
	 */
    public void setGongzijishengjinshengXinzhi(Double gongzijishengjinshengXinzhi) {
        this.gongzijishengjinshengXinzhi = gongzijishengjinshengXinzhi;
    }
    /**
	 * 获取：档案简介
	 */
    public String getGongzijishengjinshengText() {
        return gongzijishengjinshengText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setGongzijishengjinshengText(String gongzijishengjinshengText) {
        this.gongzijishengjinshengText = gongzijishengjinshengText;
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
