package com.h_tf.forceEnchants;

import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.iface.ReadWriteNBT;
import de.tr7zw.nbtapi.iface.ReadableNBT;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;



public class EnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ReadWriteNBT nbti = NBT.itemStackToNBT(itemInMainHand);
        String json = nbti.toString();
        if(strings.length == 0 || strings[0].equals("help")) {
            commandSender.sendMessage("§x§f§f§0§0§0§0§l强§x§f§f§0§0§0§0§l制§x§f§f§0§0§0§0§l附§x§f§f§0§0§0§0§l魔§x§f§f§0§0§0§0§lF§x§f§f§0§0§0§0§lo§x§f§f§0§0§0§0§lr§x§f§f§0§0§0§0§lc§x§f§f§0§0§0§0§le§x§f§f§0§0§0§0§lE§x§f§f§0§0§0§0§ln§x§f§f§0§0§0§0§lc§x§f§f§0§0§0§0§lh§x§f§f§0§0§0§0§la§x§f§f§0§0§0§0§ln§x§f§f§0§0§0§0§lt§x§f§f§0§0§0§0§ls");
            commandSender.sendMessage("V1.0");
            commandSender.sendMessage("§f§f§f§0§0§0§l/fch help    查看此帮助列表");
            commandSender.sendMessage("§f§f§f§0§0§0§l/fch <附魔名称> <附魔等级>    为玩家手中物品附魔");
            commandSender.sendMessage("§f§f§f§0§0§0§l/fch nbt    查看手中物品nbt标签");
            return true;
        }
        else if(strings[0].equals("nbt")) {
            commandSender.sendMessage(json);

        }
        else if (commandSender instanceof Player && strings.length == 2) {
            if (nbti.toString().contains(strings[0])){
                String enchjson = Util.stringReplace(json,strings[0],strings[1]);
                if(enchjson.equals("Err")){
                    commandSender.sendMessage("Err1");
                    return false;
                }
                ReadableNBT enchNBT = NBT.parseNBT(enchjson);
                itemInMainHand = NBT.itemStackFromNBT(enchNBT);
                player.getInventory().setItemInMainHand(itemInMainHand);
                commandSender.sendMessage("附魔成功，已替换原有附魔");
                return true;
            }
            else if (nbti.toString().contains("Enchantments")){
                String enchjson = Util.stringAppend(json,strings[0],strings[1]);
                if(enchjson.equals("Err")){
                    commandSender.sendMessage("Err2");
                    return false;
                }
                ReadableNBT enchNBT = NBT.parseNBT(enchjson);
                itemInMainHand = NBT.itemStackFromNBT(enchNBT);
                player.getInventory().setItemInMainHand(itemInMainHand);
                commandSender.sendMessage("附魔成功，已追加附魔");
                return true;
            }
            else if (nbti.toString().contains("tag")) {
                String enchjson = Util.stringCreateEnch(json,strings[0],strings[1]);
                if(enchjson.equals("Err")){
                    commandSender.sendMessage("Err3");
                    return false;
                }
                ReadableNBT enchNBT = NBT.parseNBT(enchjson);
                itemInMainHand = NBT.itemStackFromNBT(enchNBT);
                player.getInventory().setItemInMainHand(itemInMainHand);
                commandSender.sendMessage("附魔成功，已添加附魔");
                return true;
            }
            else {
                String enchjson = Util.createTag(json,strings[0],strings[1]);
                if(enchjson.equals("Err")){
                    commandSender.sendMessage("Err4");
                    return false;
                }
                ReadableNBT enchNBT = NBT.parseNBT(enchjson);
                itemInMainHand = NBT.itemStackFromNBT(enchNBT);
                player.getInventory().setItemInMainHand(itemInMainHand);
                commandSender.sendMessage("附魔成功，已添加附魔");
                return true;
            }
        }
        return false;

    }


}
