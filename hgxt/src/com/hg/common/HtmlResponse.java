package com.hg.common;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HtmlResponse {
    public static void pageTextResponse(HttpServletResponse response, String data) throws Exception {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache");
        PrintWriter out = response.getWriter(); //输出中文，这一句一定要放到response.setContentType("text/html;charset=utf-8"),  response.setHeader("Cache-Control", "no-cache")后面，否则中文返回到页面是乱码
        out.print(data);
        out.flush();
        out.close();
    }
}
