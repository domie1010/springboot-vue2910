package com.dao;

import com.entity.GongzijishengjinshengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.GongzijishengjinshengView;

/**
 * 工资晋级档案 Dao 接口
 *
 * @author 
 */
public interface GongzijishengjinshengDao extends BaseMapper<GongzijishengjinshengEntity> {

   List<GongzijishengjinshengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
