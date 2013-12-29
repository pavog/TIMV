package com.evilcodes.timv.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.handlers.MessagesHandler;

public class ShopCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (Game.started) {
				if (Game.Traitors.contains(player)) {
					//TODO ADD ITEMS
					final Inventory inv = Bukkit.createInventory(null, 2 * 9, "§3TraitorShop");
					player.openInventory(inv);
				} else if (Game.Detectives.contains(player)) {
					//TODO ADD ITEMS
					final Inventory inv = Bukkit.createInventory(null, 2 * 9, "§3DetectiveShop");
					player.openInventory(inv);
				} else {
					player.sendMessage(MessagesHandler.convert("NoInnocents"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Shop.OnlyIngame"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
