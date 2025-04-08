package com.entity.model;

import com.entity.ShehuibaoxianEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 社会保险档案
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShehuibaoxianModel implements Serializable {
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
    private String shehuibaoxianUuidNumber;


    /**
     * 档案标题
     */
    private String shehuibaoxianName;


    /**
     * 文件上传
     */
    private String shehuibaoxianFile;


    /**
     * 保险名称
     */
    private String shehuibaoxianShijian;


    /**
     * 保险描述
     */
    private String shehuibaoxianText;


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
    public String getShehuibaoxianUuidNumber() {
        return shehuibaoxianUuidNumber;
    }


    /**
	 * 设置：档案编号
	 */
    public void setShehuibaoxianUuidNumber(String shehuibaoxianUuidNumber) {
        this.shehuibaoxianUuidNumber = shehuibaoxianUuidNumber;
    }
    /**
	 * 获取：档案标题
	 */
    public String getShehuibaoxianName() {
        return shehuibaoxianName;
    }


    /**
	 * 设置：档案标题
	 */
    public void setShehuibaoxianName(String shehuibaoxianName) {
        this.shehuibaoxianName = shehuibaoxianName;
    }
    /**
	 * 获取：文件上传
	 */
    public String getShehuibaoxianFile() {
        return shehuibaoxianFile;
    }


    /**
	 * 设置：文件上传
	 */
    public void setShehuibaoxianFile(String shehuibaoxianFile) {
        this.shehuibaoxianFile = shehuibaoxianFile;
    }
    /**
	 * 获取：保险名称
	 */
    public String getShehuibaoxianShijian() {
        return shehuibaoxianShijian;
    }


    /**
	 * 设置：保险名称
	 */
    public void setShehuibaoxianShijian(String shehuibaoxianShijian) {
        this.shehuibaoxianShijian = shehuibaoxianShijian;
    }
    /**
	 * 获取：保险描述
	 */
    public String getShehuibaoxianText() {
        return shehuibaoxianText;
    }


    /**
	 * 设置：保险描述
	 */
    public void setShehuibaoxianText(String shehuibaoxianText) {
        this.shehuibaoxianText = shehuibaoxianText;
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
