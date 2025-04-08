package com.entity.model;

import com.entity.ZhichengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 职称档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ZhichengModel implements Serializable {
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
    private String zhichengUuidNumber;


    /**
     * 档案标题
     */
    private String zhichengName;


    /**
     * 文件上传
     */
    private String zhichengFile;


    /**
     * 工作时间
     */
    private String zhichengShijian;


    /**
     * 职称
     */
    private String zhichengXuexuiao;


    /**
     * 薪资
     */
    private Double zhichengXinzhi;


    /**
     * 档案简介
     */
    private String zhichengText;


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
    public String getZhichengUuidNumber() {
        return zhichengUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setZhichengUuidNumber(String zhichengUuidNumber) {
        this.zhichengUuidNumber = zhichengUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getZhichengName() {
        return zhichengName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setZhichengName(String zhichengName) {
        this.zhichengName = zhichengName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getZhichengFile() {
        return zhichengFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setZhichengFile(String zhichengFile) {
        this.zhichengFile = zhichengFile;
    }
    /**
	 * 获取：工作时间
	 */
    public String getZhichengShijian() {
        return zhichengShijian;
    }


    /**
	 * 设置：工作时间
	 */
    public void setZhichengShijian(String zhichengShijian) {
        this.zhichengShijian = zhichengShijian;
    }
    /**
	 * 获取：职称
	 */
    public String getZhichengXuexuiao() {
        return zhichengXuexuiao;
    }


    /**
	 * 设置：职称
	 */
    public void setZhichengXuexuiao(String zhichengXuexuiao) {
        this.zhichengXuexuiao = zhichengXuexuiao;
    }
    /**
	 * 获取：薪资
	 */
    public Double getZhichengXinzhi() {
        return zhichengXinzhi;
    }


    /**
	 * 设置：薪资
	 */
    public void setZhichengXinzhi(Double zhichengXinzhi) {
        this.zhichengXinzhi = zhichengXinzhi;
    }
    /**
	 * 获取：档案简介
	 */
    public String getZhichengText() {
        return zhichengText;
    }


    /**
	 * 设置：档案简介
	 */
    public void setZhichengText(String zhichengText) {
        this.zhichengText = zhichengText;
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
