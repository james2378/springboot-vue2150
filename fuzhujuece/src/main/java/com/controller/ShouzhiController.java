
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
 * 收支
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shouzhi")
public class ShouzhiController {
    private static final Logger logger = LoggerFactory.getLogger(ShouzhiController.class);

    @Autowired
    private ShouzhiService shouzhiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YuangongService yuangongService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yuangongId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shouzhiService.queryPage(params);

        //字典表数据转换
        List<ShouzhiView> list =(List<ShouzhiView>)page.getList();
        for(ShouzhiView c:list){
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
        ShouzhiEntity shouzhi = shouzhiService.selectById(id);
        if(shouzhi !=null){
            //entity转view
            ShouzhiView view = new ShouzhiView();
            BeanUtils.copyProperties( shouzhi , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShouzhiEntity shouzhi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shouzhi:{}",this.getClass().getName(),shouzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShouzhiEntity> queryWrapper = new EntityWrapper<ShouzhiEntity>()
            .eq("shouzhi_uuid_number", shouzhi.getShouzhiUuidNumber())
            .eq("shouzhi_name", shouzhi.getShouzhiName())
            .eq("shouzhi_types", shouzhi.getShouzhiTypes())
            .eq("shouzhi_erji_types", shouzhi.getShouzhiErjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouzhiEntity shouzhiEntity = shouzhiService.selectOne(queryWrapper);
        if(shouzhiEntity==null){
            shouzhi.setInsertTime(new Date());
            shouzhi.setCreateTime(new Date());
            shouzhiService.insert(shouzhi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShouzhiEntity shouzhi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shouzhi:{}",this.getClass().getName(),shouzhi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShouzhiEntity> queryWrapper = new EntityWrapper<ShouzhiEntity>()
            .notIn("id",shouzhi.getId())
            .andNew()
            .eq("shouzhi_uuid_number", shouzhi.getShouzhiUuidNumber())
            .eq("shouzhi_name", shouzhi.getShouzhiName())
            .eq("shouzhi_types", shouzhi.getShouzhiTypes())
            .eq("shouzhi_erji_types", shouzhi.getShouzhiErjiTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShouzhiEntity shouzhiEntity = shouzhiService.selectOne(queryWrapper);
        if(shouzhiEntity==null){
            shouzhiService.updateById(shouzhi);//根据id更新
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
        shouzhiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<ShouzhiEntity> shouzhiList = new ArrayList<>();//上传的东西
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
                            ShouzhiEntity shouzhiEntity = new ShouzhiEntity();
//                            shouzhiEntity.setShouzhiUuidNumber(data.get(0));                    //唯一编号 要改的
//                            shouzhiEntity.setShouzhiName(data.get(0));                    //收支名称 要改的
//                            shouzhiEntity.setShouzhiTypes(Integer.valueOf(data.get(0)));   //收支类型 要改的
//                            shouzhiEntity.setShouzhiErjiTypes(Integer.valueOf(data.get(0)));   //二级类型 要改的
//                            shouzhiEntity.setShouzhiMoney(data.get(0));                    //收支金额 要改的
//                            shouzhiEntity.setShouzhiContent("");//详情和图片
//                            shouzhiEntity.setInsertTime(date);//时间
//                            shouzhiEntity.setCreateTime(date);//时间
                            shouzhiList.add(shouzhiEntity);


                            //把要查询是否重复的字段放入map中
                                //唯一编号
                                if(seachFields.containsKey("shouzhiUuidNumber")){
                                    List<String> shouzhiUuidNumber = seachFields.get("shouzhiUuidNumber");
                                    shouzhiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shouzhiUuidNumber = new ArrayList<>();
                                    shouzhiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shouzhiUuidNumber",shouzhiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //唯一编号
                        List<ShouzhiEntity> shouzhiEntities_shouzhiUuidNumber = shouzhiService.selectList(new EntityWrapper<ShouzhiEntity>().in("shouzhi_uuid_number", seachFields.get("shouzhiUuidNumber")));
                        if(shouzhiEntities_shouzhiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShouzhiEntity s:shouzhiEntities_shouzhiUuidNumber){
                                repeatFields.add(s.getShouzhiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shouzhiService.insertBatch(shouzhiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
