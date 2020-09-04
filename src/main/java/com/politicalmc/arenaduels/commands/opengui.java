package com.politicalmc.arenaduels.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class opengui implements CommandExecutor {

    private String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }


    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is only accessible to players");
            return true;
        }

        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("opengui") && args.length == 0) {
            Inventory inv = Bukkit.createInventory(null, 36, "Select Duel Mode");

            // Friendly Mode
            ItemStack item = new ItemStack(Material.ELYTRA);
            ItemMeta meta = item.getItemMeta();
            List<String> lore = new ArrayList<String>();


            meta.setDisplayName(color("&4&lFriendly Duel"));

            lore.add(color("&7Just a friendly duel between rivals where"));
            lore.add(color("&7both players will have the same kits and no "));
            lore.add(color("&7personal items will be lost. Except your"));
            lore.add(color("&7reputation of course!"));
            meta.setLore(lore);
            item.setItemMeta(meta);

            lore.clear();
            inv.setItem(11, item);

            // High Stakes
            item.setType(Material.ENCHANTED_GOLDEN_APPLE);
            meta.setDisplayName(color("&5&lHigh Stakes"));

            lore.add(color("&7Think you're good, huh? Well time to put your"));
            lore.add(color("&7money where your mouth is and risk some of those"));
            lore.add(color("&7precious items you've been hoarding all this time"));
            meta.setLore(lore);
            item.setItemMeta(meta);

            lore.clear();
            inv.setItem(11, item);

            // Exit
            item.setType(Material.BARRIER);
            meta.setDisplayName(color("&7Exit"));
            meta.setLore(null);

            inv.setItem(35, item);

            // Fill whitespace with Gray Panes
            item.setType(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
            meta.setDisplayName("");
            meta.setLore(null);

            for (int i = 0; i < inv.getSize(); i++) {
                if (inv.getItem(i) == null) {
                    inv.setItem(i, item);
                }

            }
            player.openInventory(inv);

        }
        return false;
    }
}
