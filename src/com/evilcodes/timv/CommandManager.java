package com.evilcodes.timv;

import com.evilcodes.timv.TIMV;
import com.evilcodes.timv.commands.CommandHelper;
import com.evilcodes.timv.commands.HelpCMD;
import com.evilcodes.timv.commands.LeaveCMD;
import com.evilcodes.timv.commands.ReloadCMD;
import com.evilcodes.timv.commands.StartCMD;
import com.evilcodes.timv.commands.StatsCMD;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandManager
  implements CommandExecutor
{
  public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings)
  {
    CommandHelper h = new CommandHelper(cs, cmnd);

    if (strings.length == 0) {
      cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "-----------------" + ChatColor.AQUA + "] " + ChatColor.YELLOW + "TIMV " + ChatColor.RESET + ChatColor.AQUA + "[" + ChatColor.GOLD + "-----------------" + ChatColor.AQUA + "]");
      cs.sendMessage(ChatColor.DARK_AQUA + "Trouble in Mineville " + ChatColor.RESET + ChatColor.DARK_AQUA + "plugin von EvilCodes. " + ChatColor.ITALIC + "(Version: " + ChatColor.DARK_RED + ChatColor.ITALIC + TIMV.getInstance().getDescription().getVersion() + ChatColor.DARK_AQUA + ChatColor.ITALIC + ")");
      cs.sendMessage(ChatColor.AQUA + "[" + ChatColor.GOLD + "-----------------" + ChatColor.AQUA + "] " + ChatColor.YELLOW + "TIMV " + ChatColor.RESET + ChatColor.AQUA + "[" + ChatColor.GOLD + "-----------------" + ChatColor.AQUA + "]");
      return true;
    }

    if (strings[0].equalsIgnoreCase("help")) {
      HelpCMD.getCommand().execHelpCMD(cs, strings, cmnd);
      return true;
    }
    
    if (strings[0].equalsIgnoreCase("hilfe")) {
        HelpCMD.getCommand().execHelpCMD(cs, strings, cmnd);
        return true;
      }

    if (strings[0].equalsIgnoreCase("reload")) {
      if (cs.hasPermission("timv.admin")) {
        ReloadCMD.getCommand().execReloadCMD(cs, strings, cmnd);
      } else {
        h.noPermission();
      }
      return true;
    }

    if (strings[0].equalsIgnoreCase("stats")) {
      if ((cs instanceof Player)) {
        if (cs.hasPermission("timv.user"))
          StatsCMD.getCommand().execStatsCMD(cs, strings, cmnd);
        else
          h.noPermission();
      }
      else {
        h.noConsole();
      }
      return true;
    }
    
    
    if (strings[0].equalsIgnoreCase("leave")) {
        if ((cs instanceof Player)) {
            LeaveCMD.getCommand().execLeaveCMD(cs, strings, cmnd);
        } else {
          h.noConsole();
        }
        return true;
      }

    if (strings[0].equalsIgnoreCase("start")) {
      if (cs.hasPermission("timv.admin")) {
        StartCMD.getCommand().execStartCMD(cs, strings, cmnd);
      } else {
        h.noPermission();
      }
      return true;
    }
    h.unknownCommand();
	return true;

    //TODO: Stop, List, Spectate
  }
}