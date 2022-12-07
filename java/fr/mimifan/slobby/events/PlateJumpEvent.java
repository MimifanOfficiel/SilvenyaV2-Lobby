package fr.mimifan.slobby.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class PlateJumpEvent implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getAction() == Action.PHYSICAL){
			if(event.getClickedBlock().getType() == Material.STONE_PRESSURE_PLATE) {
				double x = event.getClickedBlock().getLocation().getX();
				double y = event.getClickedBlock().getLocation().getY();
				double z = event.getClickedBlock().getLocation().getZ();
				Material block_under = Bukkit.getWorld("world").getBlockAt((int) x, (int) (y-2), (int) z).getType();
				Vector unitVector = null;
				if(block_under == Material.DIAMOND_BLOCK){
					 unitVector = new Vector(event.getPlayer().getLocation().getDirection().getX(), 1.5, event.getPlayer().getLocation().getDirection().getZ()-4);
				} else if(block_under == Material.EMERALD_BLOCK){
					unitVector = new Vector(event.getPlayer().getLocation().getDirection().getX()+4, 1.5, event.getPlayer().getLocation().getDirection().getZ());
				} else if(block_under == Material.GOLD_BLOCK){
					unitVector = new Vector(event.getPlayer().getLocation().getDirection().getX(), 1.5, event.getPlayer().getLocation().getDirection().getZ()+4);
				} else if(block_under == Material.IRON_BLOCK){
					unitVector = new Vector(event.getPlayer().getLocation().getDirection().getX()-4, 1.5, event.getPlayer().getLocation().getDirection().getZ());
				}
				unitVector = unitVector.normalize();
				event.getPlayer().setVelocity(unitVector.multiply(3));
			}
		}
	}
}
