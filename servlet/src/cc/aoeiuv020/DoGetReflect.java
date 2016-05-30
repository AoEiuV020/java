/* ***************************************************
	^> File Name: DoGetReflect.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/30 - 02:20:59
*************************************************** */
package cc.aoeiuv020;
import cc.aoeiuv020.lang.reflect.MethodUtils;
import java.lang.reflect.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class DoGetReflect extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		doGet(request,response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World!</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Hello World!</h1>");
		out.println("<pre>");
		out.println("request: "+request);
		MethodUtils.output(out,request);
		out.println("response: "+response);
		MethodUtils.output(out,response);
		out.println("</pre>");
		out.println("</body>");
		out.println("</html>");
	}
}
