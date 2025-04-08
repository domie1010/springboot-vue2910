package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.GongzijishengjinshengEntity;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 工资晋级档案 服务类
 */
public interface GongzijishengjinshengService extends IService<GongzijishengjinshengEntity> {

    /**
    * @param params 查询参数
    * @return 带分页的查询出来的数据
    */
     PageUtils queryPage(Map<String, Object> params);
}