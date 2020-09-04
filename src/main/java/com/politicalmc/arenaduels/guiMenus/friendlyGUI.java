package com.politicalmc.arenaduels.guiMenus;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class friendlyGUI {
    public Inventory friendlyGUI(){
        Inventory inv = Bukkit.createInventory(null, 36, "Friendly Duel");

        ItemStack item = new ItemStack(Material.RED_STAINED_GLASS_PANE);


        return inv;
    }


}

