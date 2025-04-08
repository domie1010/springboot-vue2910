package com.entity.vo;

import com.entity.ZhiwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 职务档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhiwu")
public class ZhiwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "zhiwu_uuid_number")
    private String zhiwuUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "zhiwu_name")
    private String zhiwuName;


    /**
     * 文件上传
     */

    @TableField(value = "zhiwu_file")
    private String zhiwuFile;


    /**
     * 工作时间
     */

    @TableField(value = "zhiwu_shijian")
    private String zhiwuShijian;


    /**
     * 职务
     */

    @TableField(value = "zhiwu_xuexuiao")
    private String zhiwuXuexuiao;


    /**
     * 档案简介
     */

    @TableField(value = "zhiwu_text")
    private String zhiwuText;


    /**
     * 创建时间 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
    public String getZhiwuUuidNumber() {
        return zhiwuUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setZhiwuUuidNumber(String zhiwuUuidNumber) {
        this.zhiwuUuidNumber = zhiwuUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getZhiwuName() {
        return zhiwuName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setZhiwuName(String zhiwuName) {
        this.zhiwuName = zhiwuName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getZhiwuFile() {
        return zhiwuFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setZhiwuFile(String zhiwuFile) {
        this.zhiwuFile = zhiwuFile;
    }
    /**
	 * 设置：工作时间
	 */
    public String getZhiwuShijian() {
        return zhiwuShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setZhiwuShijian(String zhiwuShijian) {
        this.zhiwuShijian = zhiwuShijian;
    }
    /**
	 * 设置：职务
	 */
    public String getZhiwuXuexuiao() {
        return zhiwuXuexuiao;
    }


    /**
	 * 获取：职务
	 */

    public void setZhiwuXuexuiao(String zhiwuXuexuiao) {
        this.zhiwuXuexuiao = zhiwuXuexuiao;
    }
    /**
	 * 设置：档案简介
	 */
    public String getZhiwuText() {
        return zhiwuText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setZhiwuText(String zhiwuText) {
        this.zhiwuText = zhiwuText;
    }
    /**
	 * 设置：创建时间 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
