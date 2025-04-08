package com.dao;

import com.entity.ZhengshenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhengshenView;

/**
 * 政审档案 Dao 接口
 *
 * @author 
 */
public interface ZhengshenDao extends BaseMapper<ZhengshenEntity> {

   List<ZhengshenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
