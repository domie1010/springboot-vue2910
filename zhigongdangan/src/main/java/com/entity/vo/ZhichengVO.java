package com.entity.vo;

import com.entity.ZhichengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 职称档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("zhicheng")
public class ZhichengVO implements Serializable {
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

    @TableField(value = "zhicheng_uuid_number")
    private String zhichengUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "zhicheng_name")
    private String zhichengName;


    /**
     * 文件上传
     */

    @TableField(value = "zhicheng_file")
    private String zhichengFile;


    /**
     * 工作时间
     */

    @TableField(value = "zhicheng_shijian")
    private String zhichengShijian;


    /**
     * 职称
     */

    @TableField(value = "zhicheng_xuexuiao")
    private String zhichengXuexuiao;


    /**
     * 薪资
     */

    @TableField(value = "zhicheng_xinzhi")
    private Double zhichengXinzhi;


    /**
     * 档案简介
     */

    @TableField(value = "zhicheng_text")
    private String zhichengText;


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
    public String getZhichengUuidNumber() {
        return zhichengUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setZhichengUuidNumber(String zhichengUuidNumber) {
        this.zhichengUuidNumber = zhichengUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getZhichengName() {
        return zhichengName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setZhichengName(String zhichengName) {
        this.zhichengName = zhichengName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getZhichengFile() {
        return zhichengFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setZhichengFile(String zhichengFile) {
        this.zhichengFile = zhichengFile;
    }
    /**
	 * 设置：工作时间
	 */
    public String getZhichengShijian() {
        return zhichengShijian;
    }


    /**
	 * 获取：工作时间
	 */

    public void setZhichengShijian(String zhichengShijian) {
        this.zhichengShijian = zhichengShijian;
    }
    /**
	 * 设置：职称
	 */
    public String getZhichengXuexuiao() {
        return zhichengXuexuiao;
    }


    /**
	 * 获取：职称
	 */

    public void setZhichengXuexuiao(String zhichengXuexuiao) {
        this.zhichengXuexuiao = zhichengXuexuiao;
    }
    /**
	 * 设置：薪资
	 */
    public Double getZhichengXinzhi() {
        return zhichengXinzhi;
    }


    /**
	 * 获取：薪资
	 */

    public void setZhichengXinzhi(Double zhichengXinzhi) {
        this.zhichengXinzhi = zhichengXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getZhichengText() {
        return zhichengText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setZhichengText(String zhichengText) {
        this.zhichengText = zhichengText;
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
