package com.entity.vo;

import com.entity.NiandukaoheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 年度考核档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("niandukaohe")
public class NiandukaoheVO implements Serializable {
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

    @TableField(value = "niandukaohe_uuid_number")
    private String niandukaoheUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "niandukaohe_name")
    private String niandukaoheName;


    /**
     * 文件上传
     */

    @TableField(value = "niandukaohe_file")
    private String niandukaoheFile;


    /**
     * 考核项目
     */

    @TableField(value = "niandukaohe_shijian")
    private String niandukaoheShijian;


    /**
     * 考核成绩
     */

    @TableField(value = "niandukaohe_chengji")
    private Double niandukaoheChengji;


    /**
     * 详细经过
     */

    @TableField(value = "niandukaohe_text")
    private String niandukaoheText;


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
    public String getNiandukaoheUuidNumber() {
        return niandukaoheUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setNiandukaoheUuidNumber(String niandukaoheUuidNumber) {
        this.niandukaoheUuidNumber = niandukaoheUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getNiandukaoheName() {
        return niandukaoheName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setNiandukaoheName(String niandukaoheName) {
        this.niandukaoheName = niandukaoheName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getNiandukaoheFile() {
        return niandukaoheFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setNiandukaoheFile(String niandukaoheFile) {
        this.niandukaoheFile = niandukaoheFile;
    }
    /**
	 * 设置：考核项目
	 */
    public String getNiandukaoheShijian() {
        return niandukaoheShijian;
    }


    /**
	 * 获取：考核项目
	 */

    public void setNiandukaoheShijian(String niandukaoheShijian) {
        this.niandukaoheShijian = niandukaoheShijian;
    }
    /**
	 * 设置：考核成绩
	 */
    public Double getNiandukaoheChengji() {
        return niandukaoheChengji;
    }


    /**
	 * 获取：考核成绩
	 */

    public void setNiandukaoheChengji(Double niandukaoheChengji) {
        this.niandukaoheChengji = niandukaoheChengji;
    }
    /**
	 * 设置：详细经过
	 */
    public String getNiandukaoheText() {
        return niandukaoheText;
    }


    /**
	 * 获取：详细经过
	 */

    public void setNiandukaoheText(String niandukaoheText) {
        this.niandukaoheText = niandukaoheText;
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
