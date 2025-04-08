package com.entity.vo;

import com.entity.GongzijishengjinshengEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工资晋级档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("gongzijishengjinsheng")
public class GongzijishengjinshengVO implements Serializable {
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

    @TableField(value = "gongzijishengjinsheng_uuid_number")
    private String gongzijishengjinshengUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "gongzijishengjinsheng_name")
    private String gongzijishengjinshengName;


    /**
     * 文件上传
     */

    @TableField(value = "gongzijishengjinsheng_file")
    private String gongzijishengjinshengFile;


    /**
     * 原工资
     */

    @TableField(value = "gongzijishengjinsheng_shijian")
    private String gongzijishengjinshengShijian;


    /**
     * 晋级后工作
     */

    @TableField(value = "gongzijishengjinsheng_xuexuiao")
    private String gongzijishengjinshengXuexuiao;


    /**
     * 晋升原因
     */

    @TableField(value = "gongzijishengjinsheng_xinzhi")
    private Double gongzijishengjinshengXinzhi;


    /**
     * 档案简介
     */

    @TableField(value = "gongzijishengjinsheng_text")
    private String gongzijishengjinshengText;


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
    public String getGongzijishengjinshengUuidNumber() {
        return gongzijishengjinshengUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setGongzijishengjinshengUuidNumber(String gongzijishengjinshengUuidNumber) {
        this.gongzijishengjinshengUuidNumber = gongzijishengjinshengUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getGongzijishengjinshengName() {
        return gongzijishengjinshengName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setGongzijishengjinshengName(String gongzijishengjinshengName) {
        this.gongzijishengjinshengName = gongzijishengjinshengName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getGongzijishengjinshengFile() {
        return gongzijishengjinshengFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setGongzijishengjinshengFile(String gongzijishengjinshengFile) {
        this.gongzijishengjinshengFile = gongzijishengjinshengFile;
    }
    /**
	 * 设置：原工资
	 */
    public String getGongzijishengjinshengShijian() {
        return gongzijishengjinshengShijian;
    }


    /**
	 * 获取：原工资
	 */

    public void setGongzijishengjinshengShijian(String gongzijishengjinshengShijian) {
        this.gongzijishengjinshengShijian = gongzijishengjinshengShijian;
    }
    /**
	 * 设置：晋级后工作
	 */
    public String getGongzijishengjinshengXuexuiao() {
        return gongzijishengjinshengXuexuiao;
    }


    /**
	 * 获取：晋级后工作
	 */

    public void setGongzijishengjinshengXuexuiao(String gongzijishengjinshengXuexuiao) {
        this.gongzijishengjinshengXuexuiao = gongzijishengjinshengXuexuiao;
    }
    /**
	 * 设置：晋升原因
	 */
    public Double getGongzijishengjinshengXinzhi() {
        return gongzijishengjinshengXinzhi;
    }


    /**
	 * 获取：晋升原因
	 */

    public void setGongzijishengjinshengXinzhi(Double gongzijishengjinshengXinzhi) {
        this.gongzijishengjinshengXinzhi = gongzijishengjinshengXinzhi;
    }
    /**
	 * 设置：档案简介
	 */
    public String getGongzijishengjinshengText() {
        return gongzijishengjinshengText;
    }


    /**
	 * 获取：档案简介
	 */

    public void setGongzijishengjinshengText(String gongzijishengjinshengText) {
        this.gongzijishengjinshengText = gongzijishengjinshengText;
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
