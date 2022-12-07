package fr.mimifan.slobby.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class CanceledEvents implements Listener {

	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if(!event.getPlayer().isOp()) event.setCancelled(true);
		else event.setCancelled(false);
	}

	@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		if(!event.getPlayer().isOp()) event.setCancelled(true);
		else event.setCancelled(false);
	}

	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent event) {
		if(!event.getPlayer().isOp()) event.setCancelled(true);
		else event.setCancelled(false);
	}

	@EventHandler
	public void onItemDrop(PlayerDropItemEvent event) {
		if(!event.getPlayer().isOp()) event.setCancelled(true);
		else event.setCancelled(false);
	}

	@EventHandler
	public void onFoodChange(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void onDamage(EntityDamageEvent event) {
		Entity entity = event.getEntity();
		if(entity instanceof Player) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void onEntitySpawning(EntitySpawnEvent event){
		if(event.getEntity().getType() != EntityType.VILLAGER && event.getEntity().getType() != EntityType.ITEM_FRAME) event.setCancelled(true);
	}
	
}
