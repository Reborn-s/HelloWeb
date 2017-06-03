import com.rebornJar.vcode.VerifyCode;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/7.
 */
public class Test
{
    public static void main(String[] args) throws IOException
    {
        VerifyCode vc  = new VerifyCode();
        BufferedImage image = vc.getImage();
        VerifyCode.output(image,new FileOutputStream("/vcode/abc.jpg"));
        System.out.print(vc.getText());
    }
}
