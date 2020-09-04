package com.politicalmc.arenaduels;

import com.politicalmc.arenaduels.commands.opengui;
import com.politicalmc.arenaduels.events.menuEvents;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ArenaDuels extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ArenaDuels has been enabled");
        getCommand("opengui").setExecutor(new opengui());

        //Registering Events
        PluginManager manager = getServer().getPluginManager();
        manager.registerEvents(new menuEvents(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("ArenaDuels has been disabled");
    }
}
