package com.dao;

import com.entity.ZhiwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhiwuView;

/**
 * 职务档案 Dao 接口
 *
 * @author 
 */
public interface ZhiwuDao extends BaseMapper<ZhiwuEntity> {

   List<ZhiwuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
