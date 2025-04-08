package com.dao;

import com.entity.NiandukaoheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.NiandukaoheView;

/**
 * 年度考核档案 Dao 接口
 *
 * @author 
 */
public interface NiandukaoheDao extends BaseMapper<NiandukaoheEntity> {

   List<NiandukaoheView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
