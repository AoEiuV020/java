/* ***************************************************
	^> File Name: LogTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 20:07:24
*************************************************** */
package cc.aoeiuv020;
import cc.aoeiuv020.lang.reflect.MethodUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LogTest extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		doGet(request,response);
	}
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/plant");
        PrintWriter out = response.getWriter();
		ServletContext context=getServletContext();
		out.println("ServletContext method");
		MethodUtils.output(out,context);

		out.println("javax.servlet.ServletContext.log failed");
		context.log("ServletContext.log llllog");

		out.println("System.out failed");
		System.out.println("System.out lllog");
		System.out.flush();

		out.println("System.err failed");
		System.err.println("System.err lllog");
		System.err.flush();

		out.println("org.apache.logging.log4j.Logger failed");
		Logger logger=LogManager.getLogger("AoEiuV020 servlet");
		logger.info("log4j lllog");

		out.println("end");
    }
}
