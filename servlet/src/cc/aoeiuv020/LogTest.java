/* ***************************************************
	^> File Name: LogTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 20:07:24
*************************************************** */
package cc.aoeiuv020;
import cc.aoeiuv020.logging.Logger;
import cc.aoeiuv020.lang.reflect.MethodUtils;
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

		Logger logger=Logger.getLogger("AoEiuV020 servlet");
		logger.i(String.format("%s:%d",request.getRemoteAddr(),request.getRemotePort()));

		out.println("end");
    }
}
