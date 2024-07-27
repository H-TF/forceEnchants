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
            commandSender.sendMessage("§x§f§f§f§0§0§0§l/§x§f§f§f§0§0§0§lf§x§f§f§f§0§0§0§lc§x§f§f§f§0§0§0§lh§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§lh§x§f§f§f§0§0§0§le§x§f§f§f§0§0§0§ll§x§f§f§f§0§0§0§lp§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l查§x§f§f§f§0§0§0§l看§x§f§f§f§0§0§0§l此§x§f§f§f§0§0§0§l帮§x§f§f§f§0§0§0§l助§x§f§f§f§0§0§0§l列§x§f§f§f§0§0§0§l表");
            commandSender.sendMessage("§x§f§f§f§0§0§0§l/§x§f§f§f§0§0§0§lf§x§f§f§f§0§0§0§lc§x§f§f§f§0§0§0§lh§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l<§x§f§f§f§0§0§0§l附§x§f§f§f§0§0§0§l魔§x§f§f§f§0§0§0§l名§x§f§f§f§0§0§0§l称§x§f§f§f§0§0§0§l>§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l<§x§f§f§f§0§0§0§l附§x§f§f§f§0§0§0§l魔§x§f§f§f§0§0§0§l等§x§f§f§f§0§0§0§l级§x§f§f§f§0§0§0§l>§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l为§x§f§f§f§0§0§0§l玩§x§f§f§f§0§0§0§l家§x§f§f§f§0§0§0§l手§x§f§f§f§0§0§0§l中§x§f§f§f§0§0§0§l物§x§f§f§f§0§0§0§l品§x§f§f§f§0§0§0§l附§x§f§f§f§0§0§0§l魔");
            commandSender.sendMessage("§x§f§f§f§0§0§0§l/§x§f§f§f§0§0§0§lf§x§f§f§f§0§0§0§lc§x§f§f§f§0§0§0§lh§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§ln§x§f§f§f§0§0§0§lb§x§f§f§f§0§0§0§lt§x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l §x§f§f§f§0§0§0§l查§x§f§f§f§0§0§0§l看§x§f§f§f§0§0§0§l手§x§f§f§f§0§0§0§l中§x§f§f§f§0§0§0§l物§x§f§f§f§0§0§0§l品§x§f§f§f§0§0§0§ln§x§f§f§f§0§0§0§lb§x§f§f§f§0§0§0§lt§x§f§f§f§0§0§0§l标§x§f§f§f§0§0§0§l签");
            return true;
        }
        else if(strings[0].equals("nbt")) {
            commandSender.sendMessage(json);
            return true;
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
