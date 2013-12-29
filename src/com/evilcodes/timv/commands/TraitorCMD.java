package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.TIMV;
import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.game.Lobby;
import com.evilcodes.timv.handlers.DatabaseHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class TraitorCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (Lobby.started && !Game.started) {
				if (DatabaseHandler.hasPass(player)) {
					if (!Lobby.forcedTraitors.contains(player) && !Lobby.forcedDetectives.contains(player)) {
						if (!(Lobby.forcedTraitors.size() >= TIMV.config.getInt("MaxTraitors"))) {
							Lobby.forcedTraitors.add(player);
							player.sendMessage(MessagesHandler.convert("Traitor.Success"));
						} else {
							player.sendMessage(MessagesHandler.convert("Traitor.TooMany"));
						}
					} else {
						player.sendMessage(MessagesHandler.convert("Traitor.AlreadyMatched"));
					}
				} else {
					player.sendMessage(MessagesHandler.convert("NoPasses"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Traitor.OnlyInLobby"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
