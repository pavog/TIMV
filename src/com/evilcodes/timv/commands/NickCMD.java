package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.evilcodes.timv.handlers.DatabaseHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class NickCMD implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof Player) {
			final Player player = (Player) cs;
			if (DatabaseHandler.isPremium(player)) {
				if (args.length == 1) {
					final String name = args[0];
					player.setDisplayName(name);
					//TODO SETNAME
				} else {
					player.sendMessage(MessagesHandler.convert("Nick.Syntax"));
				}
			} else {
				player.sendMessage(MessagesHandler.convert("Nick.OnlyYoutubers"));
			}
		} else {
			cs.sendMessage(MessagesHandler.noPlayer());
		}
		return true;
	}

}
