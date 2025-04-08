
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
 * 职称档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhicheng")
public class ZhichengController {
    private static final Logger logger = LoggerFactory.getLogger(ZhichengController.class);

    @Autowired
    private ZhichengService zhichengService;


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
        PageUtils page = zhichengService.queryPage(params);

        //字典表数据转换
        List<ZhichengView> list =(List<ZhichengView>)page.getList();
        for(ZhichengView c:list){
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
        ZhichengEntity zhicheng = zhichengService.selectById(id);
        if(zhicheng !=null){
            //entity转view
            ZhichengView view = new ZhichengView();
            BeanUtils.copyProperties( zhicheng , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhicheng.getYonghuId());
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
    public R save(@RequestBody ZhichengEntity zhicheng, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhicheng:{}",this.getClass().getName(),zhicheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            zhicheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhichengEntity> queryWrapper = new EntityWrapper<ZhichengEntity>()
            .eq("yonghu_id", zhicheng.getYonghuId())
            .eq("zhicheng_uuid_number", zhicheng.getZhichengUuidNumber())
            .eq("zhicheng_name", zhicheng.getZhichengName())
            .eq("zhicheng_shijian", zhicheng.getZhichengShijian())
            .eq("zhicheng_xuexuiao", zhicheng.getZhichengXuexuiao())
            .eq("zhicheng_text", zhicheng.getZhichengText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichengEntity zhichengEntity = zhichengService.selectOne(queryWrapper);
        if(zhichengEntity==null){
            zhicheng.setCreateTime(new Date());
            zhichengService.insert(zhicheng);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhichengEntity zhicheng, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhicheng:{}",this.getClass().getName(),zhicheng.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            zhicheng.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhichengEntity> queryWrapper = new EntityWrapper<ZhichengEntity>()
            .notIn("id",zhicheng.getId())
            .andNew()
            .eq("yonghu_id", zhicheng.getYonghuId())
            .eq("zhicheng_uuid_number", zhicheng.getZhichengUuidNumber())
            .eq("zhicheng_name", zhicheng.getZhichengName())
            .eq("zhicheng_shijian", zhicheng.getZhichengShijian())
            .eq("zhicheng_xuexuiao", zhicheng.getZhichengXuexuiao())
            .eq("zhicheng_text", zhicheng.getZhichengText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhichengEntity zhichengEntity = zhichengService.selectOne(queryWrapper);
        if("".equals(zhicheng.getZhichengFile()) || "null".equals(zhicheng.getZhichengFile())){
                zhicheng.setZhichengFile(null);
        }
        if(zhichengEntity==null){
            zhichengService.updateById(zhicheng);//根据id更新
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
        zhichengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhichengEntity> zhichengList = new ArrayList<>();//上传的东西
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
                            ZhichengEntity zhichengEntity = new ZhichengEntity();
//                            zhichengEntity.setYonghuId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            zhichengEntity.setZhichengUuidNumber(data.get(0));                    //档案编号 要改的
//                            zhichengEntity.setZhichengName(data.get(0));                    //档案标题 要改的
//                            zhichengEntity.setZhichengFile(data.get(0));                    //文件上传 要改的
//                            zhichengEntity.setZhichengShijian(data.get(0));                    //工作时间 要改的
//                            zhichengEntity.setZhichengXuexuiao(data.get(0));                    //职称 要改的
//                            zhichengEntity.setZhichengXinzhi(data.get(0));                    //薪资 要改的
//                            zhichengEntity.setZhichengText(data.get(0));                    //档案简介 要改的
//                            zhichengEntity.setCreateTime(date);//时间
                            zhichengList.add(zhichengEntity);


                            //把要查询是否重复的字段放入map中
                                //档案编号
                                if(seachFields.containsKey("zhichengUuidNumber")){
                                    List<String> zhichengUuidNumber = seachFields.get("zhichengUuidNumber");
                                    zhichengUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhichengUuidNumber = new ArrayList<>();
                                    zhichengUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhichengUuidNumber",zhichengUuidNumber);
                                }
                        }

                        //查询是否重复
                         //档案编号
                        List<ZhichengEntity> zhichengEntities_zhichengUuidNumber = zhichengService.selectList(new EntityWrapper<ZhichengEntity>().in("zhicheng_uuid_number", seachFields.get("zhichengUuidNumber")));
                        if(zhichengEntities_zhichengUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhichengEntity s:zhichengEntities_zhichengUuidNumber){
                                repeatFields.add(s.getZhichengUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhichengService.insertBatch(zhichengList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
