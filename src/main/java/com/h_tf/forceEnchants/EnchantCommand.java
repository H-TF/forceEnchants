package com.h_tf.forceEnchants;

import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.iface.ReadWriteNBT;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;



public class EnchantCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 0 || strings[0].equals("help")){
            commandSender.sendMessage("强制附魔ForceEnchants");
            commandSender.sendMessage("");
            commandSender.sendMessage("/forceEnchants help    查看此帮助列表");
            commandSender.sendMessage("/forceEnchants <附魔名称> <附魔等级>    为玩家手中物品附魔");
            return true;
        } else if (commandSender instanceof Player && strings.length == 2) {
            Player player = (Player) commandSender;
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();


            ReadWriteNBT nbti = NBT.itemStackToNBT(itemInMainHand);
            commandSender.sendMessage(nbti.toString());
//            commandSender.sendMessage(String.valueOf(nbti.getCompound("tag").toString()));
            if (nbti.toString().contains("sharpness")){
                commandSender.sendMessage("fengli");
                String json = nbti.toString();
                String enchjson = Util.stringReplace(json,strings[0]);
                commandSender.sendMessage(enchjson);


//                itemInMainHand = NBT.itemStackFromNBT((ReadableNBT) enchantments);
//                NBT.modify(itemInMainHand, nbt ->{nbt.mergeCompound(NBT.parseNBT(json));});
            }

//            String jsoncustom = "Enchantments:{id:\""+strings[0]+"\",lvl:"+strings[1]+"s}";
//            ReadWriteNBT nbtcustom = NBT.parseNBT(jsoncustom);
//
//            if(json.contains("sharpness")){
//                commandSender.sendMessage("fengli");
//
//            } else {
//                NBT.modify(itemInMainHand, nbt -> {nbt.mergeCompound(nbtcustom);});
//            }







            return true;
        }
        return false;

    }


}
