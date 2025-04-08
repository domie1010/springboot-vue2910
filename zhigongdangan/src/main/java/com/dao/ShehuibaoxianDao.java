package com.dao;

import com.entity.ShehuibaoxianEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShehuibaoxianView;

/**
 * 社会保险档案 Dao 接口
 *
 * @author 
 */
public interface ShehuibaoxianDao extends BaseMapper<ShehuibaoxianEntity> {

   List<ShehuibaoxianView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
