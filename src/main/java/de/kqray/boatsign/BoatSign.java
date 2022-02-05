package de.kqray.boatsign;

import de.kqray.boatsign.Events.BoatSignEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class BoatSign extends JavaPlugin {
    private static BoatSign instance;
    @Override
    public void onEnable() {
        instance = this;
        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new BoatSignEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    public static BoatSign getInstance() {
        return instance;
    }

}
