package com.entity.model;

import com.entity.NiandukaoheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 年度考核档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class NiandukaoheModel implements Serializable {
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
    private String niandukaoheUuidNumber;


    /**
     * 档案标题
     */
    private String niandukaoheName;


    /**
     * 文件上传
     */
    private String niandukaoheFile;


    /**
     * 考核项目
     */
    private String niandukaoheShijian;


    /**
     * 考核成绩
     */
    private Double niandukaoheChengji;


    /**
     * 详细经过
     */
    private String niandukaoheText;


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
    public String getNiandukaoheUuidNumber() {
        return niandukaoheUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setNiandukaoheUuidNumber(String niandukaoheUuidNumber) {
        this.niandukaoheUuidNumber = niandukaoheUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getNiandukaoheName() {
        return niandukaoheName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setNiandukaoheName(String niandukaoheName) {
        this.niandukaoheName = niandukaoheName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getNiandukaoheFile() {
        return niandukaoheFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setNiandukaoheFile(String niandukaoheFile) {
        this.niandukaoheFile = niandukaoheFile;
    }
    /**
	 * 获取：考核项目
	 */
    public String getNiandukaoheShijian() {
        return niandukaoheShijian;
    }


    /**
	 * 设置：考核项目
	 */
    public void setNiandukaoheShijian(String niandukaoheShijian) {
        this.niandukaoheShijian = niandukaoheShijian;
    }
    /**
	 * 获取：考核成绩
	 */
    public Double getNiandukaoheChengji() {
        return niandukaoheChengji;
    }


    /**
	 * 设置：考核成绩
	 */
    public void setNiandukaoheChengji(Double niandukaoheChengji) {
        this.niandukaoheChengji = niandukaoheChengji;
    }
    /**
	 * 获取：详细经过
	 */
    public String getNiandukaoheText() {
        return niandukaoheText;
    }


    /**
	 * 设置：详细经过
	 */
    public void setNiandukaoheText(String niandukaoheText) {
        this.niandukaoheText = niandukaoheText;
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
