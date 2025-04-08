
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
 * 政审档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/zhengshen")
public class ZhengshenController {
    private static final Logger logger = LoggerFactory.getLogger(ZhengshenController.class);

    @Autowired
    private ZhengshenService zhengshenService;


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
        PageUtils page = zhengshenService.queryPage(params);

        //字典表数据转换
        List<ZhengshenView> list =(List<ZhengshenView>)page.getList();
        for(ZhengshenView c:list){
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
        ZhengshenEntity zhengshen = zhengshenService.selectById(id);
        if(zhengshen !=null){
            //entity转view
            ZhengshenView view = new ZhengshenView();
            BeanUtils.copyProperties( zhengshen , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(zhengshen.getYonghuId());
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
    public R save(@RequestBody ZhengshenEntity zhengshen, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,zhengshen:{}",this.getClass().getName(),zhengshen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            zhengshen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<ZhengshenEntity> queryWrapper = new EntityWrapper<ZhengshenEntity>()
            .eq("yonghu_id", zhengshen.getYonghuId())
            .eq("zhengshen_uuid_number", zhengshen.getZhengshenUuidNumber())
            .eq("zhengshen_name", zhengshen.getZhengshenName())
            .eq("zhengshen_shijian", zhengshen.getZhengshenShijian())
            .eq("zhengshen_text", zhengshen.getZhengshenText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengshenEntity zhengshenEntity = zhengshenService.selectOne(queryWrapper);
        if(zhengshenEntity==null){
            zhengshen.setCreateTime(new Date());
            zhengshenService.insert(zhengshen);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ZhengshenEntity zhengshen, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,zhengshen:{}",this.getClass().getName(),zhengshen.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            zhengshen.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ZhengshenEntity> queryWrapper = new EntityWrapper<ZhengshenEntity>()
            .notIn("id",zhengshen.getId())
            .andNew()
            .eq("yonghu_id", zhengshen.getYonghuId())
            .eq("zhengshen_uuid_number", zhengshen.getZhengshenUuidNumber())
            .eq("zhengshen_name", zhengshen.getZhengshenName())
            .eq("zhengshen_shijian", zhengshen.getZhengshenShijian())
            .eq("zhengshen_text", zhengshen.getZhengshenText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ZhengshenEntity zhengshenEntity = zhengshenService.selectOne(queryWrapper);
        if("".equals(zhengshen.getZhengshenFile()) || "null".equals(zhengshen.getZhengshenFile())){
                zhengshen.setZhengshenFile(null);
        }
        if(zhengshenEntity==null){
            zhengshenService.updateById(zhengshen);//根据id更新
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
        zhengshenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ZhengshenEntity> zhengshenList = new ArrayList<>();//上传的东西
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
                            ZhengshenEntity zhengshenEntity = new ZhengshenEntity();
//                            zhengshenEntity.setYonghuId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            zhengshenEntity.setZhengshenUuidNumber(data.get(0));                    //档案编号 要改的
//                            zhengshenEntity.setZhengshenName(data.get(0));                    //档案标题 要改的
//                            zhengshenEntity.setZhengshenFile(data.get(0));                    //文件上传 要改的
//                            zhengshenEntity.setZhengshenShijian(data.get(0));                    //政审 要改的
//                            zhengshenEntity.setZhengshenText(data.get(0));                    //政审描述 要改的
//                            zhengshenEntity.setCreateTime(date);//时间
                            zhengshenList.add(zhengshenEntity);


                            //把要查询是否重复的字段放入map中
                                //档案编号
                                if(seachFields.containsKey("zhengshenUuidNumber")){
                                    List<String> zhengshenUuidNumber = seachFields.get("zhengshenUuidNumber");
                                    zhengshenUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> zhengshenUuidNumber = new ArrayList<>();
                                    zhengshenUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("zhengshenUuidNumber",zhengshenUuidNumber);
                                }
                        }

                        //查询是否重复
                         //档案编号
                        List<ZhengshenEntity> zhengshenEntities_zhengshenUuidNumber = zhengshenService.selectList(new EntityWrapper<ZhengshenEntity>().in("zhengshen_uuid_number", seachFields.get("zhengshenUuidNumber")));
                        if(zhengshenEntities_zhengshenUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ZhengshenEntity s:zhengshenEntities_zhengshenUuidNumber){
                                repeatFields.add(s.getZhengshenUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        zhengshenService.insertBatch(zhengshenList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
