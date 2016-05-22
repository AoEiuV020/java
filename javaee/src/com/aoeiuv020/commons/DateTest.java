/* ***************************************************
	^> File Name: DateTest.java
	^> Author: AoEiuV020
	^> Mail: 490674483@qq.com
	^> Created Time: 2016/05/23 - 01:02:31
*************************************************** */
package cc.aoeiuv020.commons;
import java.util.Date;
import java.util.Calendar;
import org.apache.commons.lang.time.DateUtils;
import org.apache.commons.lang.time.DateFormatUtils;
public class DateTest
{
	public static void main(String[] args)
	{
		Date date=new Date();
		System.out.println(""+DateUtils.round(date,Calendar.HOUR));
	}
}
