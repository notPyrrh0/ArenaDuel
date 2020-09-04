package com.politicalmc.arenaduels.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class menuEvents implements Listener {
    @EventHandler
    public void clickEvents(InventoryClickEvent evt) {
        Player p = (Player) evt.getWhoClicked();

        if (evt.getView().getTitle().equalsIgnoreCase("Select Duel Mode")) {
            evt.setCancelled(true);
            switch (evt.getCurrentItem().getType()) {
                case ELYTRA:
                    p.sendMessage("Open the Friendly Mode Menu");
                    p.closeInventory();
                    break;
                case ENCHANTED_GOLDEN_APPLE:
                    p.sendMessage("Open the High Stakes Menu");
                    p.closeInventory();
                    break;
                // More modes to be added in the future
                default:
                    break;
            }
        }


    }
}
