package de.kqray.chestboat.Events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class BoatSignEvent implements Listener {
    @EventHandler
    public void onSignChange(SignChangeEvent event) {
    //Check if the player is op
        if (!event.getPlayer().isOp() ){
            String s = event.getLine(0);
            if (!s.equalsIgnoreCase("[Boat]"))return;
            event.setLine(0,"");
            event.setLine(1,"");
            event.setLine(2,"");
            event.setLine(3,"");
            event.getPlayer().sendMessage(ChatColor.RED +"Du darsft keine boot schilder erstellen");
        }
        //Check if it says [Boat] on the sign, if yes, rename it
            String s = event.getLine(0);

            if (s.equalsIgnoreCase("[Boat]")) {
                event.setLine(3,"---------------");
                event.setLine(1, "§6Kostenloses");
                event.setLine(2, "§7[§6Boot§7]");
                event.setLine(0,"---------------");
                event.getPlayer().sendMessage(ChatColor.GREEN+"Dein Boot schild wurde erfolgreich erstellt!");

            }

    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
//Check if the sign is empty
        if (event.getClickedBlock() == null) return;
//Check if the Sign is the Right sign
        if (event.getClickedBlock().getState() instanceof Sign) {
            String Boat = ((Sign) event.getClickedBlock().getState()).getLine(1);

            if (Boat.equalsIgnoreCase("§6Kostenloses")) {
                ItemStack i = new ItemStack(Material.OAK_BOAT);
                event.getPlayer().getInventory().addItem(i);

            }
        }
    }
}
