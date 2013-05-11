package com.evilcodes.timv;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerListener extends JavaPlugin implements Listener {

	@SuppressWarnings("unused")
	private TIMV plugin;
	private String motd;

	public ServerListener(TIMV plugin) {
        this.plugin = plugin;
    }

	  @EventHandler(priority=EventPriority.MONITOR)
	  public void onServerListPing(ServerListPingEvent event) {
	      if (Bukkit.getOnlinePlayers().length == 0) {
		  event.setMotd(ChatColor.GREEN + "Frei");
	      } else if (Bukkit.getOnlinePlayers().length == 3 || Bukkit.getOnlinePlayers().length > 3) {
	      event.setMotd(ChatColor.RED + "Voll");
	      } else if (Bukkit.getOnlinePlayers().length == 1 || Bukkit.getOnlinePlayers().length > 1) {
	      event.setMotd(ChatColor.GREEN + "Warten");
	      }
	  }
	  
	  @EventHandler
	  public void onServerJoin(PlayerJoinEvent event) {
	  }
	  
	  public String getMotd()
	  {
	    return this.motd;
	  }
}