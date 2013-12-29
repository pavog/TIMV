package com.evilcodes.timv.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.evilcodes.timv.TIMV;
import com.evilcodes.timv.handlers.FilesHandler;
import com.evilcodes.timv.handlers.MessagesHandler;

public class TIMVCommandExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			displayHelp(cs, 0);
		} else if (args.length == 1) {
			final String arg = args[0];
			if (arg.equalsIgnoreCase("reload")) {
				reload();
				cs.sendMessage(MessagesHandler.convert("Reloaded").replace("%version%", TIMV.instance.getDescription().getVersion()));
			} else if (arg.equalsIgnoreCase("help")) {
				//Help
				displayHelp(cs, 0);
			} else if (arg.equalsIgnoreCase("info")) {
				//Infos about the plugin
				displayHelp(cs, 1);
			} else if (arg.equalsIgnoreCase("commands")) {
				//Commands usable by all players
				displayHelp(cs, 2);
			} else if (arg.equalsIgnoreCase("ranks")) {
				//Commands only usable by premium players or youtubers
				displayHelp(cs, 3);
			} else if (arg.equalsIgnoreCase("admin")) {
				//Commands only usable by admins
				displayHelp(cs, 4);
			}
		}
		return true;
	}

	private void reload() {
		FilesHandler.CheckForConfigs();		
	}

	private void displayHelp(final CommandSender cs, final int page) {
		if (page == 0) {
			//Default help page
			cs.sendMessage(MessagesHandler.convert("Header"));
			cs.sendMessage(MessagesHandler.convert("Help.Line1"));
			cs.sendMessage(MessagesHandler.convert("Help.Line2"));
			cs.sendMessage(MessagesHandler.convert("Help.Line3"));
			cs.sendMessage(MessagesHandler.convert("Help.Line4"));
			cs.sendMessage(MessagesHandler.convert("Help.Line5"));
			cs.sendMessage(MessagesHandler.convert("Footer"));
		} else if (page == 1) {
			//Info help page
			cs.sendMessage(MessagesHandler.convert("Header"));
			cs.sendMessage("§3Alternative TIMV version " + TIMV.instance.getDescription().getVersion() + " loaded!");
			cs.sendMessage("§3Public plugin made by §oEvilCodes");
			cs.sendMessage("§3§ohttp://www.evilcodes.tk/");
			cs.sendMessage("§3Contact: §oevilcodes.dev@gmail.com");
			cs.sendMessage("§3Get this plugin here: §ohttp://www.dev.bukkit.org/bukkit-plugins/AltTIMV");
			cs.sendMessage(MessagesHandler.convert("Footer"));
		} else if (page == 2) {
			//Commands help page
			cs.sendMessage(MessagesHandler.convert("Header"));
			cs.sendMessage(MessagesHandler.convert("Help.Commands.Line1"));
			cs.sendMessage(MessagesHandler.convert("Help.Commands.Line2"));
			cs.sendMessage(MessagesHandler.convert("Help.Commands.Line3"));
			cs.sendMessage(MessagesHandler.convert("Help.Commands.Line4"));
			cs.sendMessage(MessagesHandler.convert("Help.Commands.Line5"));
			cs.sendMessage(MessagesHandler.convert("Footer"));
		} else if (page == 3) {
			//Rankcommands help page
			cs.sendMessage(MessagesHandler.convert("Header"));
			cs.sendMessage(MessagesHandler.convert("Help.Ranks.Line1"));
			cs.sendMessage(MessagesHandler.convert("Help.Ranks.Line2"));
			cs.sendMessage(MessagesHandler.convert("Help.Ranks.Line3"));
			cs.sendMessage(MessagesHandler.convert("Help.Ranks.Line4"));
			cs.sendMessage(MessagesHandler.convert("Help.Ranks.Line5"));
			cs.sendMessage(MessagesHandler.convert("Footer"));
		} else if (page == 4) {
			//Admincommands help page
			cs.sendMessage(MessagesHandler.convert("Header"));
			cs.sendMessage(MessagesHandler.convert("Help.Admin.Line1"));
			cs.sendMessage(MessagesHandler.convert("Help.Admin.Line2"));
			cs.sendMessage(MessagesHandler.convert("Help.Admin.Line3"));
			cs.sendMessage(MessagesHandler.convert("Help.Admin.Line4"));
			cs.sendMessage(MessagesHandler.convert("Help.Admin.Line5"));
			cs.sendMessage(MessagesHandler.convert("Footer"));
		} else {
			displayHelp(cs, 0);
		}
		
	}

}
