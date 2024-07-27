package com.h_tf.forceEnchants;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceEnchants extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("§x§0§8§4§c§f§b强§x§1§0§5§4§f§b制§x§1§8§5§c§f§b附§x§2§0§6§4§f§b魔§x§2§7§6§c§f§b：§x§2§f§7§4§f§bp§x§3§7§7§c§f§cl§x§3§f§8§4§f§cu§x§4§7§8§c§f§cg§x§4§f§9§4§f§ci§x§5§7§9§c§f§cn§x§5§e§a§3§f§c §x§6§6§a§b§f§ci§x§6§e§b§3§f§cs§x§7§6§b§b§f§c §x§7§e§c§3§f§ce§x§8§6§c§b§f§dn§x§8§e§d§3§f§da§x§9§5§d§b§f§db§x§9§d§e§3§f§dl§x§a§5§e§b§f§de§x§a§d§f§3§f§dd");

        this.getCommand("fenchants").setExecutor(new EnchantCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("§x§0§8§4§c§f§b强§x§1§0§5§4§f§b制§x§1§7§5§b§f§b附§x§1§f§6§3§f§b魔§x§2§6§6§a§f§b：§x§2§e§7§2§f§bp§x§3§5§7§a§f§cl§x§3§d§8§1§f§cu§x§4§4§8§9§f§cg§x§4§c§9§0§f§ci§x§5§3§9§8§f§cn§x§5§b§a§0§f§c §x§6§2§a§7§f§ci§x§6§a§a§f§f§cs§x§7§1§b§6§f§c §x§7§9§b§e§f§cd§x§8§0§c§5§f§ci§x§8§8§c§d§f§ds§x§8§f§d§5§f§da§x§9§7§d§c§f§db§x§9§e§e§4§f§dl§x§a§6§e§b§f§de§x§a§d§f§3§f§dd");
    }
}
