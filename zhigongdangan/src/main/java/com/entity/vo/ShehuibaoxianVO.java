package com.entity.vo;

import com.entity.ShehuibaoxianEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 社会保险档案
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shehuibaoxian")
public class ShehuibaoxianVO implements Serializable {
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

    @TableField(value = "shehuibaoxian_uuid_number")
    private String shehuibaoxianUuidNumber;


    /**
     * 档案标题
     */

    @TableField(value = "shehuibaoxian_name")
    private String shehuibaoxianName;


    /**
     * 文件上传
     */

    @TableField(value = "shehuibaoxian_file")
    private String shehuibaoxianFile;


    /**
     * 保险名称
     */

    @TableField(value = "shehuibaoxian_shijian")
    private String shehuibaoxianShijian;


    /**
     * 保险描述
     */

    @TableField(value = "shehuibaoxian_text")
    private String shehuibaoxianText;


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
    public String getShehuibaoxianUuidNumber() {
        return shehuibaoxianUuidNumber;
    }


    /**
	 * 获取：档案编号
	 */

    public void setShehuibaoxianUuidNumber(String shehuibaoxianUuidNumber) {
        this.shehuibaoxianUuidNumber = shehuibaoxianUuidNumber;
    }
    /**
	 * 设置：档案标题
	 */
    public String getShehuibaoxianName() {
        return shehuibaoxianName;
    }


    /**
	 * 获取：档案标题
	 */

    public void setShehuibaoxianName(String shehuibaoxianName) {
        this.shehuibaoxianName = shehuibaoxianName;
    }
    /**
	 * 设置：文件上传
	 */
    public String getShehuibaoxianFile() {
        return shehuibaoxianFile;
    }


    /**
	 * 获取：文件上传
	 */

    public void setShehuibaoxianFile(String shehuibaoxianFile) {
        this.shehuibaoxianFile = shehuibaoxianFile;
    }
    /**
	 * 设置：保险名称
	 */
    public String getShehuibaoxianShijian() {
        return shehuibaoxianShijian;
    }


    /**
	 * 获取：保险名称
	 */

    public void setShehuibaoxianShijian(String shehuibaoxianShijian) {
        this.shehuibaoxianShijian = shehuibaoxianShijian;
    }
    /**
	 * 设置：保险描述
	 */
    public String getShehuibaoxianText() {
        return shehuibaoxianText;
    }


    /**
	 * 获取：保险描述
	 */

    public void setShehuibaoxianText(String shehuibaoxianText) {
        this.shehuibaoxianText = shehuibaoxianText;
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
