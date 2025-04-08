package com.entity.vo;

import com.entity.GongzjinbgyanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作经历档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzjinbgyan")
public class GongzjinbgyanVO implements Serializable {
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

    @TableField(value = "gongzjinbgyan_uuid_number")
    private String gongzjinbgyanUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "gongzjinbgyan_name")
    private String gongzjinbgyanName;


    /**
     * 文件上传
     */

    @TableField(value = "gongzjinbgyan_file")
    private String gongzjinbgyanFile;


    /**
     * 工作时间
     */

    @TableField(value = "gongzjinbgyan_shijian")
    private String gongzjinbgyanShijian;


    /**
     * 公司
     */

    @TableField(value = "gongzjinbgyan_xuexuiao")
    private String gongzjinbgyanXuexuiao;


    /**
     * 薪资
     */

    @TableField(value = "gongzjinbgyan_xinzhi")
    private Double gongzjinbgyanXinzhi;


    /**
     * 档案简介
     */

    @TableField(value = "gongzjinbgyan_text")
    private String gongzjinbgyanText;


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
    public String getGongzjinbgyanUuidNumber() {
        return gongzjinbgyanUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setGongzjinbgyanUuidNumber(String gongzjinbgyanUuidNumber) {
        this.gongzjinbgyanUuidNumber = gongzjinbgyanUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getGongzjinbgyanName() {
        return gongzjinbgyanName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setGongzjinbgyanName(String gongzjinbgyanName) {
        this.gongzjinbgyanName = gongzjinbgyanName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getGongzjinbgyanFile() {
        return gongzjinbgyanFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setGongzjinbgyanFile(String gongzjinbgyanFile) {
        this.gongzjinbgyanFile = gongzjinbgyanFile;
    }
    /**
	 * 设置：工作时间
	 */
    public String getGongzjinbgyanShijian() {
        return gongzjinbgyanShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setGongzjinbgyanShijian(String gongzjinbgyanShijian) {
        this.gongzjinbgyanShijian = gongzjinbgyanShijian;
    }
    /**
	 * 设置：公司
	 */
    public String getGongzjinbgyanXuexuiao() {
        return gongzjinbgyanXuexuiao;
    }


    /**
	 * 获取：公司
	 */

    public void setGongzjinbgyanXuexuiao(String gongzjinbgyanXuexuiao) {
        this.gongzjinbgyanXuexuiao = gongzjinbgyanXuexuiao;
    }
    /**
	 * 设置：薪资
	 */
    public Double getGongzjinbgyanXinzhi() {
        return gongzjinbgyanXinzhi;
    }


    /**
	 * 获取：薪资
	 */

    public void setGongzjinbgyanXinzhi(Double gongzjinbgyanXinzhi) {
        this.gongzjinbgyanXinzhi = gongzjinbgyanXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getGongzjinbgyanText() {
        return gongzjinbgyanText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setGongzjinbgyanText(String gongzjinbgyanText) {
        this.gongzjinbgyanText = gongzjinbgyanText;
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
