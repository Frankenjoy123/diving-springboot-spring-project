package com.joey.segmentment.lessson20starter.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/10/28.
 */
@WebServlet(urlPatterns = "/my/servlets" ,asyncSupported=true)
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().print("hello,wolrd");


        // async
        AsyncContext asyncContext  = req.startAsync();
        asyncContext.start(() -> {
            try {
                resp.getWriter().print("hello,wolrd");

                //标注完成
                asyncContext.complete();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
