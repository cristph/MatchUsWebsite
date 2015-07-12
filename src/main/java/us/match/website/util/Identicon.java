package us.match.website.util;

import com.google.common.base.Charsets;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.math.DoubleMath;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.math.RoundingMode;

/**
 * Created by apple on 2015/7/12.
 */
public class Identicon {
    public static String tohash(String hash){
        String result="";
        Hasher hasher = Hashing.md5().newHasher();
        hasher.putString(hash, Charsets.UTF_8);
        String md5 = hasher.hash().toString();
        return md5;
    }
    public static byte[] creat(String hash,int size){
        byte[] result;
        IBaseGenartor genartor=new IBaseGenartor();
        boolean[][] array = genartor.getBooleanValueArray(hash);
        int ratio = DoubleMath.roundToInt(size / 9, RoundingMode.HALF_UP);
        BufferedImage identicon = new BufferedImage(ratio *9, ratio * 9, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = identicon.getGraphics();
        graphics.setColor(genartor.getBackgroundColor()); // 背景色
        graphics.fillRect(0, 0, identicon.getWidth(), identicon.getHeight());

        graphics.setColor(genartor.getForegroundColor()); // 图案前景色
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 9; j++) {
                if (array[i][j]) {
                    graphics.fillRect(j * ratio, i * ratio, ratio, ratio);
                }
            }
        }
        ByteArrayOutputStream os=new ByteArrayOutputStream();
        try {
            ImageIO.write(identicon, "jpg", os);
            result=os.toByteArray();
        }catch(Exception e){
            result=null;
            e.printStackTrace();
        }
        return result;
    }

}
