package com.oracle.gdms.web.action;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.entity.GoodsEntity;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods/update.php")
public class GoodsUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String goodId = request.getParameter("goodid");
        String name = request.getParameter("name");
        String spec = request.getParameter("spec");
        String price = request.getParameter("price");
        String amount = request.getParameter("amount");

        //把数据封装为一个goods对象，传给业务层
        GoodsEntity goods = new GoodsEntity();
        goods.setGoodsid(Integer.parseInt(goodId));
        goods.setName(name);
        goods.setSpec(spec);
//        int i = price.indexOf("￥");
//        System.out.println(i);
        price = price.substring(1);
        System.out.println(price);
        goods.setPrice(Float.parseFloat(price));
        goods.setAmount(Float.parseFloat(amount));

//        System.out.println(goodId);
//        System.out.println(name);
//        System.out.println(spec);
//        System.out.println(price);
//        System.out.println(amount);

        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        int count = service.update(goods); //返回受影响行数
        response.setContentType("application/json;charset=utf-8");
        JSONObject j = new JSONObject();
        if(count >0){
            j.put("code",0);
            j.put("msg","update success");
        }else {
            j.put("code",10882);
            j.put("msg","update failed");
        }
        response.getWriter().print(j.toJSONString());
    }


}
