
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
 * 年度考核档案
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/niandukaohe")
public class NiandukaoheController {
    private static final Logger logger = LoggerFactory.getLogger(NiandukaoheController.class);

    @Autowired
    private NiandukaoheService niandukaoheService;


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
        PageUtils page = niandukaoheService.queryPage(params);

        //字典表数据转换
        List<NiandukaoheView> list =(List<NiandukaoheView>)page.getList();
        for(NiandukaoheView c:list){
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
        NiandukaoheEntity niandukaohe = niandukaoheService.selectById(id);
        if(niandukaohe !=null){
            //entity转view
            NiandukaoheView view = new NiandukaoheView();
            BeanUtils.copyProperties( niandukaohe , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(niandukaohe.getYonghuId());
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
    public R save(@RequestBody NiandukaoheEntity niandukaohe, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,niandukaohe:{}",this.getClass().getName(),niandukaohe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("职工".equals(role))
            niandukaohe.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<NiandukaoheEntity> queryWrapper = new EntityWrapper<NiandukaoheEntity>()
            .eq("yonghu_id", niandukaohe.getYonghuId())
            .eq("niandukaohe_uuid_number", niandukaohe.getNiandukaoheUuidNumber())
            .eq("niandukaohe_name", niandukaohe.getNiandukaoheName())
            .eq("niandukaohe_shijian", niandukaohe.getNiandukaoheShijian())
            .eq("niandukaohe_text", niandukaohe.getNiandukaoheText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NiandukaoheEntity niandukaoheEntity = niandukaoheService.selectOne(queryWrapper);
        if(niandukaoheEntity==null){
            niandukaohe.setCreateTime(new Date());
            niandukaoheService.insert(niandukaohe);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NiandukaoheEntity niandukaohe, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,niandukaohe:{}",this.getClass().getName(),niandukaohe.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("职工".equals(role))
//            niandukaohe.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<NiandukaoheEntity> queryWrapper = new EntityWrapper<NiandukaoheEntity>()
            .notIn("id",niandukaohe.getId())
            .andNew()
            .eq("yonghu_id", niandukaohe.getYonghuId())
            .eq("niandukaohe_uuid_number", niandukaohe.getNiandukaoheUuidNumber())
            .eq("niandukaohe_name", niandukaohe.getNiandukaoheName())
            .eq("niandukaohe_shijian", niandukaohe.getNiandukaoheShijian())
            .eq("niandukaohe_text", niandukaohe.getNiandukaoheText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NiandukaoheEntity niandukaoheEntity = niandukaoheService.selectOne(queryWrapper);
        if("".equals(niandukaohe.getNiandukaoheFile()) || "null".equals(niandukaohe.getNiandukaoheFile())){
                niandukaohe.setNiandukaoheFile(null);
        }
        if(niandukaoheEntity==null){
            niandukaoheService.updateById(niandukaohe);//根据id更新
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
        niandukaoheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<NiandukaoheEntity> niandukaoheList = new ArrayList<>();//上传的东西
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
                            NiandukaoheEntity niandukaoheEntity = new NiandukaoheEntity();
//                            niandukaoheEntity.setYonghuId(Integer.valueOf(data.get(0)));   //职工 要改的
//                            niandukaoheEntity.setNiandukaoheUuidNumber(data.get(0));                    //档案编号 要改的
//                            niandukaoheEntity.setNiandukaoheName(data.get(0));                    //档案标题 要改的
//                            niandukaoheEntity.setNiandukaoheFile(data.get(0));                    //文件上传 要改的
//                            niandukaoheEntity.setNiandukaoheShijian(data.get(0));                    //考核项目 要改的
//                            niandukaoheEntity.setNiandukaoheChengji(data.get(0));                    //考核成绩 要改的
//                            niandukaoheEntity.setNiandukaoheText(data.get(0));                    //详细经过 要改的
//                            niandukaoheEntity.setCreateTime(date);//时间
                            niandukaoheList.add(niandukaoheEntity);


                            //把要查询是否重复的字段放入map中
                                //档案编号
                                if(seachFields.containsKey("niandukaoheUuidNumber")){
                                    List<String> niandukaoheUuidNumber = seachFields.get("niandukaoheUuidNumber");
                                    niandukaoheUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> niandukaoheUuidNumber = new ArrayList<>();
                                    niandukaoheUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("niandukaoheUuidNumber",niandukaoheUuidNumber);
                                }
                        }

                        //查询是否重复
                         //档案编号
                        List<NiandukaoheEntity> niandukaoheEntities_niandukaoheUuidNumber = niandukaoheService.selectList(new EntityWrapper<NiandukaoheEntity>().in("niandukaohe_uuid_number", seachFields.get("niandukaoheUuidNumber")));
                        if(niandukaoheEntities_niandukaoheUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NiandukaoheEntity s:niandukaoheEntities_niandukaoheUuidNumber){
                                repeatFields.add(s.getNiandukaoheUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [档案编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        niandukaoheService.insertBatch(niandukaoheList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
