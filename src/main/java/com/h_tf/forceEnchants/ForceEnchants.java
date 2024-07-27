package com.h_tf.forceEnchants;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ForceEnchants extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("强制附魔：plugin is enabled");

        this.getCommand("fenchants").setExecutor(new EnchantCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getConsoleSender().sendMessage("强制附魔：plugin is disabled");
    }
}
