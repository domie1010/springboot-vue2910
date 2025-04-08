package com.dao;

import com.entity.ZhichengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhichengView;

/**
 * 职称档案 Dao 接口
 *
 * @author 
 */
public interface ZhichengDao extends BaseMapper<ZhichengEntity> {

   List<ZhichengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
