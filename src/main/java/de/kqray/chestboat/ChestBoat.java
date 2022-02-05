package de.kqray.chestboat;

import de.kqray.chestboat.Events.BoatSignEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChestBoat extends JavaPlugin {

    @Override
    public void onEnable() {
        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new BoatSignEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
