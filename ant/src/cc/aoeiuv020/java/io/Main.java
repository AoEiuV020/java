/* ***************************************************
	^> File Name: Main.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/22 - 22:02:18
*************************************************** */
package cc.aoeiuv020.java.io;
import java.io.File;
public class Main
{
	public static void main (String[] args)
	{
		//ant 默认目录在build.xml所在目录，
		File f=new File(".");
		System.out.println(""+f.getAbsolutePath());
	}
}
