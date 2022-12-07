package fr.mimifan.slobby.events;

import net.kyori.adventure.text.ComponentBuilder;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventJoin implements Listener {
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Location loc = new Location(Bukkit.getWorld("world"), 0.5, 11.5, 0.5, 180, 0);
		player.setGameMode(GameMode.ADVENTURE);
		player.setFoodLevel(20);
		player.setHealth(20);
		player.teleport(loc);
	}
	
}
