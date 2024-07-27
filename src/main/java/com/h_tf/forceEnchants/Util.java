package com.h_tf.forceEnchants;

public class Util {
    public static String stringReplace(String str , String replace, String lvl) {
            // 输入字符串
            String input = str;
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
                        return output;
                    }
                }
            }
        return "Err1";
    }

    public static String stringAppend(String str , String append , String lvl) {
        // 输入字符串
        String input = str;
        // 待增加的附魔名
        String newEnchantment = append;
        // 新的等级
        String newLevel = lvl;
        // 构建新的附魔条目
        String newEnchantmentEntry = "{id:\"minecraft:" + newEnchantment + "\",lvl:" + newLevel + "s}";
        // 查找 "Enchantments[" 的位置
        String marker = "Enchantments:[";
        int insertPosition = input.indexOf(marker);
        // 确保找到了 "Enchantments[" 并且其后有 "["
        if (insertPosition != -1) {
            // 插入位置是 "Enchantments[" 的后面一个字符，也就是 "[" 的位置
            insertPosition += marker.length();
            StringBuilder sb = new StringBuilder(input);
            sb.insert(insertPosition, newEnchantmentEntry + ",");
            String output = sb.toString();
            return output;
        }
        return "Err2";
    }

    public static String stringCreateEnch(String str , String append , String lvl) {
        // 输入字符串
        String input = str;
        // 待增加的附魔名
        String newEnchantment = append;
        // 新的等级
        String newLevel = lvl;
        // 构建新的附魔条目
        String newEnchantmentEntry = "Enchantments:[{id:\"minecraft:" + newEnchantment + "\",lvl:" + newLevel + "s}]";
        // 查找 "tag" 的位置
        String marker = "tag:{";
        int insertPosition = input.indexOf(marker);
        // 确保找到了 "tag" 并且其后有 "{"
        if (insertPosition != -1) {
            // 插入位置是的后面一个字符，也就是 "{" 的位置
            insertPosition += marker.length();
            StringBuilder sb = new StringBuilder(input);
            sb.insert(insertPosition, newEnchantmentEntry + ",");
            String output = sb.toString();
            return output;
        }
        return "Err3";
    }

    public static String createTag(String str, String replace, String lvl) {
        String output;
        try {
            String input = str;
            // 附魔属性名
            String enchantment = replace;
            // 附魔等级
            String level = lvl;
            // 构建附魔属性字符串
            String enchantmentTag = String.format("tag:{Enchantments:[{id:\"minecraft:%s\",lvl:%ss}]}", enchantment, level);
            // 构建最终的字符串
            output = input.substring(0, input.length() - 1) + "," + enchantmentTag + "}";
        } catch (Exception e) {
            return "Err4";
        }
        // 输出结果
        return output;
    }
}







