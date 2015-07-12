package us.match.website.util;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath;
import org.apache.commons.lang3.StringUtils;

import java.awt.*;
import java.math.RoundingMode;

/**
 * Created by apple on 2015/7/12.
 */
public class IBaseGenartor {
    private String hash;
    private boolean[][] booleanValueArray;
    public boolean[][] getBooleanValueArray(String hash) {
        Preconditions.checkArgument(StringUtils.isNotBlank(hash) && hash.length() >= 16,
                "illegal argument hash:not null and size >= 16");

        this.hash = hash;

        boolean[][] array = new boolean[18][9];

        //初始化字符串
        for (int i = 0; i < 18; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = false;
            }
        }
        for (int i = 0; i < hash.length(); i += 2) {
            int s = i / 2; //只取hash字符串偶数编号（从0开始）的字符
            boolean v =
                    DoubleMath.roundToInt(Integer.parseInt(hash.charAt(i) + "", 16) / 10.0, RoundingMode.HALF_UP) > 0 ? true : false;
            if (s % 5 == 0) {
                array[s][0] = v;
                array[s][8] = v;
            } else if (s % 5 == 1) {
                array[s][2] = v;
                array[s][6] = v;
            } else if (s % 5 == 2) {
                array[s][3] = v;
                array[s][5] = v;
            }
            else if (s % 5 == 3) {
                array[s][4] = v;
            }
            else{
                array[s][4] = v;
            }
        }
        this.booleanValueArray = array;
        return this.booleanValueArray;
    }
    public Color getBackgroundColor() {
        int r = Integer.parseInt(String.valueOf(this.hash.charAt(0)), 16) * 16;
        int g = Integer.parseInt(String.valueOf(this.hash.charAt(1)), 16) * 16;
        int b = Integer.parseInt(String.valueOf(this.hash.charAt(2)), 16) * 16;
        return new Color(r, g, b);
    }
    public Color getForegroundColor() {
        int r = Integer.parseInt(String.valueOf(hash.charAt(hash.length() - 1)), 16) * 16;
        int g = Integer.parseInt(String.valueOf(hash.charAt(hash.length() - 2)), 16) * 16;
        int b = Integer.parseInt(String.valueOf(hash.charAt(hash.length() - 3)), 16) * 16;
        return new Color(r, g, b);
    }
}
