package com.evilcodes.timv.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.evilcodes.timv.TIMV;
import com.evilcodes.timv.game.Game;
import com.evilcodes.timv.game.Lobby;

public class PlayerJoinListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent e) {
		final Player player = e.getPlayer();
		if (Game.started || Lobby.started) {
			//Teleport player to lobby
			player.teleport(new Location(Bukkit.getWorld(TIMV.config.getString("Worldname")), TIMV.config.getInt("Spawn.x"), TIMV.config.getInt("Spawn.y"), TIMV.config.getInt("Spawn.z")));
		} else if (!Lobby.started && Game.started) {
			//TODO SET SPECTATOR
		}
	}

}
