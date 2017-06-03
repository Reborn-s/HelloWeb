package com.rebornJar.vcode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Reborn。 on 2017/5/7.
 * 生成随机验证码图片
 */
public class VerifyCode
{
    private final int width = 70;
    private final int height = 35;
    private Random r;

    private final String[] fontNames = {"宋体", "华文楷体", "黑体", "微软雅黑", "楷体_GB2312"};
    private final String codes = "23456789abcdefghijkmnpqrstuvwxyzABCDEFGHIJKMNPQRSTUVWXYZ";
    private final Color bgColor = new Color(255, 255, 255);

    private String text;
    private final int textLength = 4;

    public VerifyCode()
    {
        this.r = new Random();
        text = "";
    }

    private Color randomColor()
    {
        int red = r.nextInt(150);
        int green = r.nextInt(150);
        int black = r.nextInt(150);
        return new Color(red, green, black);
    }

    private Font randomFont()
    {
        int index = r.nextInt(fontNames.length);
        String fontName = fontNames[index];
        int style = r.nextInt(4);
        int size = r.nextInt(5) + 24;
        return new Font(fontName, style, size);
    }

    private char randomChar()
    {
        int index = r.nextInt(codes.length());
        return codes.charAt(index);
    }

    private void drawLine(BufferedImage image)
    {
        int num = 3;
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        for (int i = 0; i < num; i++)
        {
            int x1 = r.nextInt(width);
            int y1 = r.nextInt(height);
            int x2 = r.nextInt(width);
            int y2 = r.nextInt(height);
            g2.setStroke(new BasicStroke(1.5F));
            g2.setColor(Color.BLUE);
            g2.drawLine(x1, y1, x2, y2);
        }
    }

    private BufferedImage createImage()
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setColor(this.bgColor);
        g2.fillRect(0, 0, width, height);
        return bi;
    }

    public BufferedImage getImage()
    {
        BufferedImage image = createImage();
        Graphics2D g2 = (Graphics2D) image.getGraphics();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.textLength; i++)
        {
            String c = randomChar() + "";
            sb.append(c);
            float x = i * 1.0F * width / 4;
            g2.setFont(randomFont());
            g2.setColor(randomColor());
            g2.drawString(c, x, height - 5);
        }
        this.text = sb.toString();
        drawLine(image);
        return image;
    }

    public String getText()
    {
        return this.text;
    }

    public static void output(BufferedImage bi, OutputStream out) throws IOException
    {
        ImageIO.write(bi,"JPEG",out);
    }
}
