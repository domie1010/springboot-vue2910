
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 职务档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhiwu")
public class ZhiwuController {
    private static final Logger logger = LoggerFactory.getLogger(ZhiwuController.class);

    @Autowired
    private ZhiwuService zhiwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("职工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = zhiwuService.queryPage(params);

        //字典表数据转换
        List<ZhiwuView> list =(List<ZhiwuView>)page.getList();
        for(ZhiwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ZhiwuEntity zhiwu = zhiwuService.selectById(id);
        if(zhiwu !=null){
            //entity转view
            ZhiwuView view = new ZhiwuView();
            BeanUtils.copyProperties( zhiwu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhiwu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ZhiwuEntity zhiwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhiwu:{}",this.getClass().getName(),zhiwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            zhiwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhiwuEntity> queryWrapper = new EntityWrapper<ZhiwuEntity>()
            .eq("yonghu_id", zhiwu.getYonghuId())
            .eq("zhiwu_uuid_number", zhiwu.getZhiwuUuidNumber())
            .eq("zhiwu_name", zhiwu.getZhiwuName())
            .eq("zhiwu_shijian", zhiwu.getZhiwuShijian())
            .eq("zhiwu_xuexuiao", zhiwu.getZhiwuXuexuiao())
            .eq("zhiwu_text", zhiwu.getZhiwuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiwuEntity zhiwuEntity = zhiwuService.selectOne(queryWrapper);
        if(zhiwuEntity==null){
            zhiwu.setCreateTime(new Date());
            zhiwuService.insert(zhiwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhiwuEntity zhiwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhiwu:{}",this.getClass().getName(),zhiwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            zhiwu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhiwuEntity> queryWrapper = new EntityWrapper<ZhiwuEntity>()
            .notIn("id",zhiwu.getId())
            .andNew()
            .eq("yonghu_id", zhiwu.getYonghuId())
            .eq("zhiwu_uuid_number", zhiwu.getZhiwuUuidNumber())
            .eq("zhiwu_name", zhiwu.getZhiwuName())
            .eq("zhiwu_shijian", zhiwu.getZhiwuShijian())
            .eq("zhiwu_xuexuiao", zhiwu.getZhiwuXuexuiao())
            .eq("zhiwu_text", zhiwu.getZhiwuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhiwuEntity zhiwuEntity = zhiwuService.selectOne(queryWrapper);
        if("".equals(zhiwu.getZhiwuFile()) || "null".equals(zhiwu.getZhiwuFile())){
                zhiwu.setZhiwuFile(null);
        }
        if(zhiwuEntity==null){
            zhiwuService.updateById(zhiwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        zhiwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhiwuEntity> zhiwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ZhiwuEntity zhiwuEntity = new ZhiwuEntity();
//                            zhiwuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            zhiwuEntity.setZhiwuUuidNumber(data.get(0));                    //档案编号 要改的
//                            zhiwuEntity.setZhiwuName(data.get(0));                    //档案标题 要改的
//                            zhiwuEntity.setZhiwuFile(data.get(0));                    //文件上传 要改的
//                            zhiwuEntity.setZhiwuShijian(data.get(0));                    //工作时间 要改的
//                            zhiwuEntity.setZhiwuXuexuiao(data.get(0));                    //职务 要改的
//                            zhiwuEntity.setZhiwuText(data.get(0));                    //档案简介 要改的
//                            zhiwuEntity.setCreateTime(date);//时间
                            zhiwuList.add(zhiwuEntity);


                            //把要查询是否重复的字段放入map中
                                //档案编号
                                if(seachFields.containsKey("zhiwuUuidNumber")){
                                    List<String> zhiwuUuidNumber = seachFields.get("zhiwuUuidNumber");
                                    zhiwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhiwuUuidNumber = new ArrayList<>();
                                    zhiwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhiwuUuidNumber",zhiwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //档案编号
                        List<ZhiwuEntity> zhiwuEntities_zhiwuUuidNumber = zhiwuService.selectList(new EntityWrapper<ZhiwuEntity>().in("zhiwu_uuid_number", seachFields.get("zhiwuUuidNumber")));
                        if(zhiwuEntities_zhiwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhiwuEntity s:zhiwuEntities_zhiwuUuidNumber){
                                repeatFields.add(s.getZhiwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhiwuService.insertBatch(zhiwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
