package aoeiuv020;
import org.junit.Test;
import org.junit.Assert;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
/**
 * 
 * @author AoEiuV020
 * @version 1.0, 2016/07/12
 */
public class HelloTest{
	@Test
	public void hello()throws Exception{
		PrintStream stdout=System.out;
		ByteArrayOutputStream buf=new ByteArrayOutputStream();
		PrintStream out=new PrintStream(buf,true,"UTF-8");
		System.setOut(out);
		Hello.hello();
		System.setOut(stdout);
		assertEquals("你好\n",buf.toString());
	}
}

