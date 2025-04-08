package com.entity.model;

import com.entity.BiaozhangrongyuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 表彰荣誉档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BiaozhangrongyuModel implements Serializable {
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
    private String biaozhangrongyuUuidNumber;


    /**
     * 档案标题
     */
    private String biaozhangrongyuName;


    /**
     * 文件上传
     */
    private String biaozhangrongyuFile;


    /**
     * 原因
     */
    private String biaozhangrongyuShijian;


    /**
     * 表彰荣誉
     */
    private String biaozhangrongyuXuexuiao;


    /**
     * 奖金
     */
    private Double biaozhangrongyuXinzhi;


    /**
     * 档案简介
     */
    private String biaozhangrongyuText;


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
    public String getBiaozhangrongyuUuidNumber() {
        return biaozhangrongyuUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setBiaozhangrongyuUuidNumber(String biaozhangrongyuUuidNumber) {
        this.biaozhangrongyuUuidNumber = biaozhangrongyuUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getBiaozhangrongyuName() {
        return biaozhangrongyuName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setBiaozhangrongyuName(String biaozhangrongyuName) {
        this.biaozhangrongyuName = biaozhangrongyuName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getBiaozhangrongyuFile() {
        return biaozhangrongyuFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setBiaozhangrongyuFile(String biaozhangrongyuFile) {
        this.biaozhangrongyuFile = biaozhangrongyuFile;
    }
    /**
	 * 获取：原因
	 */
    public String getBiaozhangrongyuShijian() {
        return biaozhangrongyuShijian;
    }


    /**
	 * 设置：原因
	 */
    public void setBiaozhangrongyuShijian(String biaozhangrongyuShijian) {
        this.biaozhangrongyuShijian = biaozhangrongyuShijian;
    }
    /**
	 * 获取：表彰荣誉
	 */
    public String getBiaozhangrongyuXuexuiao() {
        return biaozhangrongyuXuexuiao;
    }


    /**
	 * 设置：表彰荣誉
	 */
    public void setBiaozhangrongyuXuexuiao(String biaozhangrongyuXuexuiao) {
        this.biaozhangrongyuXuexuiao = biaozhangrongyuXuexuiao;
    }
    /**
	 * 获取：奖金
	 */
    public Double getBiaozhangrongyuXinzhi() {
        return biaozhangrongyuXinzhi;
    }


    /**
	 * 设置：奖金
	 */
    public void setBiaozhangrongyuXinzhi(Double biaozhangrongyuXinzhi) {
        this.biaozhangrongyuXinzhi = biaozhangrongyuXinzhi;
    }
    /**
	 * 获取：档案简介
	 */
    public String getBiaozhangrongyuText() {
        return biaozhangrongyuText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setBiaozhangrongyuText(String biaozhangrongyuText) {
        this.biaozhangrongyuText = biaozhangrongyuText;
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
