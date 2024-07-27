package com.h_tf.forceEnchants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String stringReplace(String str , String replace, String lvl) {
            // 输入字符串
            String input = "Enchantments[{id:\"minecraft:"+str+"\",lvl:3s},{id:\"minecraft:bind\"},lvl:3s]";
            // 待替换处的标识
            String replaceIdentifier = replace;
            // 替换的数字
            String newLevel = lvl;

            // 查找标识符所在的位置
            int index = input.indexOf(replaceIdentifier);
            if (index != -1) {
                // 查找lvl的位置
                int lvlIndex = input.indexOf("lvl:", index);
                if (lvlIndex != -1) {
                    // 查找lvl值的结束位置
                    int endIndex = input.indexOf('s', lvlIndex);
                    if (endIndex != -1) {
                        // 构建新的字符串
                        StringBuilder sb = new StringBuilder(input);
                        sb.replace(lvlIndex + 4, endIndex, newLevel); // +4 是为了跳过 "lvl:"
                        String output = sb.toString();
                        System.out.println(output);
                        return output;
                    } else {
                        System.out.println("未找到's'结束符");
                    }
                } else {
                    System.out.println("未找到'lvl:'标识");
                }
            } else {
                System.out.println("未找到指定的标识符");
            }

    }
}







