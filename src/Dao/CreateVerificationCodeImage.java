package Dao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.PortUnreachableException;
import java.nio.Buffer;
import java.util.Random;

public class CreateVerificationCodeImage {
    private static final int WIDTH=100;//图片宽度
    private static final int HIGHT=30;//图片高度
    private static final int LENGTH=4;//设置验证码长度
    private static final int  LINECHOND=20;//设置干扰线的数目

    //设置随机数
    private static final String str="23456789"+"ABCDEFGHJKLMNPQRSTUVMXYZ"+"abcdefghijklmnpqrstuvwxyz";

    private static Random random=new Random();
    //通过随机获取4位验证码
    public String createCode()
    {
        String code="";
        for (int i=0;i<LENGTH;i++)
        {
            char c=str.charAt(random.nextInt(str.length()));
            code=code + c;
        }
        return code;
    }

    //获取不同颜色
    public Color getColor()
    {
    return  new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
    }
    //获取字体样式
    public Font getFont()
    {
        return new Font("Fixedsys",Font.CENTER_BASELINE,22);
    }
    //绘制字符
    public void drawChar(Graphics g,String code) {
        g.setFont(getFont());
        for (int i = 0; i < LENGTH; i++) {
           char c=code.charAt(i);
           g.setColor(getColor());
           g.drawString(c+"",20*i+10,20);
        }
    }
    //绘制随机线
    public void drawLine(Graphics g)
    {
        int x=random.nextInt(WIDTH);
        int y=random.nextInt(HIGHT);
        int x1=random.nextInt(13);
        int y1=random.nextInt(15);
        g.setColor(getColor());
        g.drawLine(x,y,x+x1,y+y1);
    }

    //绘制验证图片
    public BufferedImage CreateImage(String code)
    {
        BufferedImage image =new BufferedImage(WIDTH,HIGHT,BufferedImage.TYPE_3BYTE_BGR);
        Graphics g=image.getGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH,HIGHT);
        drawChar(g,code);
        for (int i=0;i<LENGTH;i++)
        {
            drawLine(g);
        }
        g.dispose();
        return image;
    }
}
