package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.game.Lobby;
import com.evilcodes.timv.handlers.DatabaseHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class PartyCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (Lobby.started && !Game.started) {
				if (DatabaseHandler.isPremium(player)) {
					//TODO START PARTY
				} else {
					player.sendMessage(MessagesHandler.convert("Party.OnlyPremiums"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Party.OnlyInLobby"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
