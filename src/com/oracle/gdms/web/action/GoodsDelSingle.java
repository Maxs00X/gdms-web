package com.oracle.gdms.web.action;

import com.alibaba.fastjson.JSONObject;
import com.oracle.gdms.service.GoodsService;
import com.oracle.gdms.util.Factory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/goods/delsingle.php")
public class GoodsDelSingle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GoodsService service = (GoodsService) Factory.getInstance().getObj("GoodsService.impl");
        String gid = request.getParameter("goodsid");
        System.out.println(gid);
        String[] str = new String[1];
        str[0] = gid;
        service.delete(str);

        response.setContentType("application/json;charset=utf-8");
        JSONObject j = new JSONObject();
        j.put("code",0);
        j.put("msg","delete success");
        response.getWriter().print(j.toJSONString());
        System.out.println("É¾³ýÁË");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
