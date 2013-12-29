package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.game.Lobby;
import com.evilcodes.timv.handlers.DatabaseHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class MapCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (DatabaseHandler.isAdmin(player)) {
				if (args.length == 1) {
					final String mapID = args[0];
					Lobby.forcedMap = mapID;
					player.sendMessage(MessagesHandler.convert("Map.Success").replace("%map%", mapID));
				} else {
					player.sendMessage(MessagesHandler.convert("Map.Syntax"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Map.OnlyAdmin"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
