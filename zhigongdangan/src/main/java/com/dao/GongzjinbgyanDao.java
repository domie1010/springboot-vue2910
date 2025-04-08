package com.dao;

import com.entity.GongzjinbgyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzjinbgyanView;

/**
 * 工作经历档案 Dao 接口
 *
 * @author 
 */
public interface GongzjinbgyanDao extends BaseMapper<GongzjinbgyanEntity> {

   List<GongzjinbgyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
