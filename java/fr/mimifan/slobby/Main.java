package fr.mimifan.slobby;

import fr.mimifan.slobby.events.CanceledEvents;
import fr.mimifan.slobby.events.EventJoin;
import fr.mimifan.slobby.events.PlateJumpEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Starting Lobby plugin.");
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EventJoin(), this);
        pm.registerEvents(new CanceledEvents(), this);
        pm.registerEvents(new PlateJumpEvent(), this);
    }

    @Override
    public void onDisable() {

    }

}
