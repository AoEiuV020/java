/* ***************************************************
	^> File Name: PropertiesTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/07/02 - 04:14:50
*************************************************** */
package cc.aoeiuv020.java.util;
import java.util.*;
public class PropertiesTest
{
	public static void main(String[] args)
	{
		Properties properties=System.getProperties();
		for(String key:properties.stringPropertyNames())
		{
			String value=properties.getProperty(key);
			System.out.println(String.format("%s -> %s",key,value));
		}
	}
}
