package me.gaurav.craftwars.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ClickListener implements Listener {

    @EventHandler
    public void playerClicked(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (player.getInventory().getItemInMainHand().getType().equals(Material.SNOWBALL)) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLore()) {
                if (action == Action.RIGHT_CLICK_AIR) {
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_AXE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_PICKAXE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_HOE, 1));
                    player.getInventory().addItem(new ItemStack(Material.WOODEN_SHOVEL, 1));
                }
            }
        }
    }
}
