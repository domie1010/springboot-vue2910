package com.entity.vo;

import com.entity.ZhengshenEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 政审档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhengshen")
public class ZhengshenVO implements Serializable {
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

    @TableField(value = "zhengshen_uuid_number")
    private String zhengshenUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "zhengshen_name")
    private String zhengshenName;


    /**
     * 文件上传
     */

    @TableField(value = "zhengshen_file")
    private String zhengshenFile;


    /**
     * 政审
     */

    @TableField(value = "zhengshen_shijian")
    private String zhengshenShijian;


    /**
     * 政审描述
     */

    @TableField(value = "zhengshen_text")
    private String zhengshenText;


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
    public String getZhengshenUuidNumber() {
        return zhengshenUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setZhengshenUuidNumber(String zhengshenUuidNumber) {
        this.zhengshenUuidNumber = zhengshenUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getZhengshenName() {
        return zhengshenName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setZhengshenName(String zhengshenName) {
        this.zhengshenName = zhengshenName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getZhengshenFile() {
        return zhengshenFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setZhengshenFile(String zhengshenFile) {
        this.zhengshenFile = zhengshenFile;
    }
    /**
	 * 设置：政审
	 */
    public String getZhengshenShijian() {
        return zhengshenShijian;
    }


    /**
	 * 获取：政审
	 */

    public void setZhengshenShijian(String zhengshenShijian) {
        this.zhengshenShijian = zhengshenShijian;
    }
    /**
	 * 设置：政审描述
	 */
    public String getZhengshenText() {
        return zhengshenText;
    }


    /**
	 * 获取：政审描述
	 */

    public void setZhengshenText(String zhengshenText) {
        this.zhengshenText = zhengshenText;
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
