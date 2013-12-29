package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.game.Lobby;
import com.evilcodes.timv.handlers.MessagesHandler;

public class TLCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (Game.started) {
			cs.sendMessage(MessagesHandler.convert("TL").replace("%time%", Game.timeleft + ""));
		} else {
			cs.sendMessage(MessagesHandler.convert("TL").replace("%time%", Lobby.timeleft + ""));
		}
		return true;
	}

}
