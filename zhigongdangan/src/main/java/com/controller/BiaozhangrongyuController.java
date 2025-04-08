
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
 * 表彰荣誉档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/biaozhangrongyu")
public class BiaozhangrongyuController {
    private static final Logger logger = LoggerFactory.getLogger(BiaozhangrongyuController.class);

    @Autowired
    private BiaozhangrongyuService biaozhangrongyuService;


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
        PageUtils page = biaozhangrongyuService.queryPage(params);

        //字典表数据转换
        List<BiaozhangrongyuView> list =(List<BiaozhangrongyuView>)page.getList();
        for(BiaozhangrongyuView c:list){
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
        BiaozhangrongyuEntity biaozhangrongyu = biaozhangrongyuService.selectById(id);
        if(biaozhangrongyu !=null){
            //entity转view
            BiaozhangrongyuView view = new BiaozhangrongyuView();
            BeanUtils.copyProperties( biaozhangrongyu , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(biaozhangrongyu.getYonghuId());
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
    public R save(@RequestBody BiaozhangrongyuEntity biaozhangrongyu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,biaozhangrongyu:{}",this.getClass().getName(),biaozhangrongyu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            biaozhangrongyu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BiaozhangrongyuEntity> queryWrapper = new EntityWrapper<BiaozhangrongyuEntity>()
            .eq("yonghu_id", biaozhangrongyu.getYonghuId())
            .eq("biaozhangrongyu_uuid_number", biaozhangrongyu.getBiaozhangrongyuUuidNumber())
            .eq("biaozhangrongyu_name", biaozhangrongyu.getBiaozhangrongyuName())
            .eq("biaozhangrongyu_shijian", biaozhangrongyu.getBiaozhangrongyuShijian())
            .eq("biaozhangrongyu_xuexuiao", biaozhangrongyu.getBiaozhangrongyuXuexuiao())
            .eq("biaozhangrongyu_text", biaozhangrongyu.getBiaozhangrongyuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiaozhangrongyuEntity biaozhangrongyuEntity = biaozhangrongyuService.selectOne(queryWrapper);
        if(biaozhangrongyuEntity==null){
            biaozhangrongyu.setCreateTime(new Date());
            biaozhangrongyuService.insert(biaozhangrongyu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BiaozhangrongyuEntity biaozhangrongyu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,biaozhangrongyu:{}",this.getClass().getName(),biaozhangrongyu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            biaozhangrongyu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BiaozhangrongyuEntity> queryWrapper = new EntityWrapper<BiaozhangrongyuEntity>()
            .notIn("id",biaozhangrongyu.getId())
            .andNew()
            .eq("yonghu_id", biaozhangrongyu.getYonghuId())
            .eq("biaozhangrongyu_uuid_number", biaozhangrongyu.getBiaozhangrongyuUuidNumber())
            .eq("biaozhangrongyu_name", biaozhangrongyu.getBiaozhangrongyuName())
            .eq("biaozhangrongyu_shijian", biaozhangrongyu.getBiaozhangrongyuShijian())
            .eq("biaozhangrongyu_xuexuiao", biaozhangrongyu.getBiaozhangrongyuXuexuiao())
            .eq("biaozhangrongyu_text", biaozhangrongyu.getBiaozhangrongyuText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BiaozhangrongyuEntity biaozhangrongyuEntity = biaozhangrongyuService.selectOne(queryWrapper);
        if("".equals(biaozhangrongyu.getBiaozhangrongyuFile()) || "null".equals(biaozhangrongyu.getBiaozhangrongyuFile())){
                biaozhangrongyu.setBiaozhangrongyuFile(null);
        }
        if(biaozhangrongyuEntity==null){
            biaozhangrongyuService.updateById(biaozhangrongyu);//根据id更新
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
        biaozhangrongyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<BiaozhangrongyuEntity> biaozhangrongyuList = new ArrayList<>();//上传的东西
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
                            BiaozhangrongyuEntity biaozhangrongyuEntity = new BiaozhangrongyuEntity();
//                            biaozhangrongyuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuUuidNumber(data.get(0));                    //档案编号 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuName(data.get(0));                    //档案标题 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuFile(data.get(0));                    //文件上传 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuShijian(data.get(0));                    //原因 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuXuexuiao(data.get(0));                    //表彰荣誉 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuXinzhi(data.get(0));                    //奖金 要改的
//                            biaozhangrongyuEntity.setBiaozhangrongyuText(data.get(0));                    //档案简介 要改的
//                            biaozhangrongyuEntity.setCreateTime(date);//时间
                            biaozhangrongyuList.add(biaozhangrongyuEntity);


                            //把要查询是否重复的字段放入map中
                                //档案编号
                                if(seachFields.containsKey("biaozhangrongyuUuidNumber")){
                                    List<String> biaozhangrongyuUuidNumber = seachFields.get("biaozhangrongyuUuidNumber");
                                    biaozhangrongyuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> biaozhangrongyuUuidNumber = new ArrayList<>();
                                    biaozhangrongyuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("biaozhangrongyuUuidNumber",biaozhangrongyuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //档案编号
                        List<BiaozhangrongyuEntity> biaozhangrongyuEntities_biaozhangrongyuUuidNumber = biaozhangrongyuService.selectList(new EntityWrapper<BiaozhangrongyuEntity>().in("biaozhangrongyu_uuid_number", seachFields.get("biaozhangrongyuUuidNumber")));
                        if(biaozhangrongyuEntities_biaozhangrongyuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BiaozhangrongyuEntity s:biaozhangrongyuEntities_biaozhangrongyuUuidNumber){
                                repeatFields.add(s.getBiaozhangrongyuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        biaozhangrongyuService.insertBatch(biaozhangrongyuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
