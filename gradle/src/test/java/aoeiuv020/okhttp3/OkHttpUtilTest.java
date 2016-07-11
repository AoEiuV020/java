package aoeiuv020.okhttp3;
import org.junit.Test;
import org.junit.Assert;
/**
 * @author AoEiuV020
 * @version 1.0, 2016/07/12
 */
public class OkHttpUtilTest{
	@Test
	public void get()throws Exception{
		String result=OkHttpUtil.get("http://aoeiuv020.cc/ip.php");
		System.out.println(result);
	}
}

