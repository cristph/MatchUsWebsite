package us.match.website.util;

import us.match.website.service.serviceImpl.IdentifyingCode;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by WH on 2015/7/13.
 */
public class CheckCodeImage {
    BufferedImage image;
    String codeString;
    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public String getCodeString() {
        return codeString;
    }

    public void setCodeString(String codeString) {
        this.codeString = codeString;
    }

    public CheckCodeImage(){
        IdentifyingCode idCode = new IdentifyingCode();
        image =new BufferedImage(idCode.getWidth() , idCode.getHeight() , BufferedImage.TYPE_INT_BGR) ;
        Graphics2D g = image.createGraphics() ;
        //定义字体样式
        Font myFont = new Font("黑体" , Font.BOLD , 20) ;
        //设置字体
        g.setFont(myFont) ;

        g.setColor(idCode.getRandomColor(200, 250)) ;
        //绘制背景
        g.fillRect(0, 0, idCode.getWidth(), idCode.getHeight()) ;

        g.setColor(idCode.getRandomColor(180, 200)) ;
        idCode.drawRandomLines(g, 30) ;
        codeString=idCode.drawRandomString(4, g) ;
        g.dispose() ;
    }
}
