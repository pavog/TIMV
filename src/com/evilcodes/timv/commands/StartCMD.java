package com.evilcodes.timv.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.handlers.DatabaseHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class StartCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (DatabaseHandler.isAdmin(player)) {
				Game.start();
			} else {
				player.sendMessage(MessagesHandler.convert("Start.OnlyAdmin"));
			}
		} else {
			Bukkit.broadcastMessage(MessagesHandler.convert("Start.ByConsole"));
			Game.start();
		}
		return true;
	}

}
