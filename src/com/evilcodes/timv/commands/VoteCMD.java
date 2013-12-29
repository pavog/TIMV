package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.game.Lobby;
import com.evilcodes.timv.handlers.MessagesHandler;

public class VoteCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (args.length == 1) {
				final int mapid = Integer.parseInt(args[0]);
				if (mapid == 1 || mapid == 2 || mapid == 3) {
					if (mapid == 1) {
						Lobby.map1votes = Lobby.map1votes + 1;
						player.sendMessage(MessagesHandler.convert("Vote.Voted").replace("%mapid%", "1"));
					} else if (mapid == 2) {
						Lobby.map2votes = Lobby.map2votes + 1;
						player.sendMessage(MessagesHandler.convert("Vote.Voted").replace("%mapid%", "2"));
					} else if (mapid == 3) {
						Lobby.map3votes = Lobby.map3votes + 1;
						player.sendMessage(MessagesHandler.convert("Vote.Voted").replace("%mapid%", "3"));
					} else {
						//Wrong number
						//If this can happen anyhow :D
						player.sendMessage(MessagesHandler.convert("Vote.Syntax"));
					}
				} else {
					player.sendMessage(MessagesHandler.convert("Vote.Syntax"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Vote.Syntax"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
