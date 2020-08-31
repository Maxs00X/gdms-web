package com.oracle.gdms.web.rest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.entity.GoodsModel;
import com.oracle.gdms.entity.GoodsType;
import com.oracle.gdms.entity.ResponseEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("huazhao")
public class RestTest {

//    @Path("/hello")
//    @GET
//    public void hello(){
//        System.out.println("hello world");
//    }

    @Path("/push/one/{goodsid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoodsModel pushOne(@PathParam("goodsid") int gid){
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return  service.findOne(gid);
    }

    @Path("/push/two")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GoodsModel pushTwo(@QueryParam("goodsid") int gid){
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return  service.findOne(gid);
    }

    @Path("/push/three")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public GoodsModel pushThree(@FormParam("goodsid") int gid){
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return  service.findOne(gid);
    }

    @Path("/push/four")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoodsModel pushFour(GoodsEntity g){
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return  service.findOne(g.getGoodsid());
    }

    @Path("/push/five")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public GoodsModel pushFive(String param){
        System.out.print("参数接收：");
        System.out.println(param);
        JSONObject j = JSONObject.parseObject(param);
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return  service.findOne(Integer.parseInt(j.getString("goodsid")));
    }

    @Path("/push/six")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<GoodsModel> pushSix(String param){
        System.out.print("参数接收：");
        System.out.println(param);
        JSONObject j = JSONObject.parseObject(param);
        JSONArray array = j.getJSONArray("desc");
        String[] params = new String[array.size()];
        for(int i = 0;i<array.size();i++){
            params[i] = array.getString(i);
        }
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        return service.findByDesc(params);
    }
    
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    @Path("/push/goods/bytype")
    public List<GoodsModel> pushGoodsByType(GoodsType type) {
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
//        List<GoodsModel> list = service.findByType(type.getGtid());
//        System.out.println(list.size());
        return service.findByType(type.getGtid());
    }

    @Path("/push/goods/one")
    @POST
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public ResponseEntity pushGoods(String jsonstr) {
        JSONObject j = JSONObject.parseObject(jsonstr);
        GoodsEntity goods = JSONObject.parseObject(j.getString("goods"), GoodsEntity.class);
        System.out.println("goodsid=" + goods.getGoodsid());
        System.out.println("name=" + goods.getName());
        System.out.println("area=" + goods.getArea());
        ResponseEntity rs = new ResponseEntity();
        rs.setCode(0);
        rs.setMessage("推送成功!!");
        rs.setData(null);
        return rs;

    }
}

