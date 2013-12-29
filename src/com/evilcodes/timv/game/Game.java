package com.evilcodes.timv.game;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.evilcodes.timv.TIMV;
import com.evilcodes.timv.handlers.MessagesHandler;

public class Game {
	
	public static final ArrayList<Player> Traitors = new ArrayList<Player>();
	public static final ArrayList<Player> Detectives = new ArrayList<Player>();
	public static final ArrayList<Player> Innocents = new ArrayList<Player>();
	public static boolean started = false;
	public static int timeleft = 1200;
	
	public static void start() {
		Lobby.started = false;
		Game.started = true;
		matchRoles();
		sendMessages();
		//TODO
	}

	private static void matchRoles() {
		final ArrayList<Player> matched = new ArrayList<Player>();
		final int maxtraitors = TIMV.config.getInt("MaxTraitors");
		final int maxdetectives = TIMV.config.getInt("MaxDetective");
		final Random r = new Random();
		for (final Player player : Bukkit.getOnlinePlayers()) {
			if (!matched.contains(player)) {
				//Forced (by /traitor or /detectives) add to matched
				if (Lobby.forcedDetectives.contains(player)) {
					Detectives.add(player);
					matched.add(player);
				} else if (Lobby.forcedTraitors.contains(player)) {
					Traitors.add(player);
					matched.add(player);
				} else {
					int randnum = r.nextInt(3);
					if (randnum == 1) {
						//Add as traitor
						if (!(Traitors.size() >= maxtraitors)) {
							Traitors.add(player);
						} else if (!(Detectives.size() >= maxdetectives)) {
							Detectives.add(player);
						} else {
							Innocents.add(player);
						}
						matched.add(player);
					} else if (randnum == 2) {
						//Add as detective
						if (!(Detectives.size() >= maxtraitors)) {
							Detectives.add(player);
						} else {
							Innocents.add(player);
						}
						matched.add(player);
					} else {
						//Add as innocent
						Innocents.add(player);
						matched.add(player);
					}
				}
			} else {
				//Already matched :P
			}
		}
	}

	private static void sendMessages() {
		for (final Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(MessagesHandler.convert("Gamestart.All").replace("%map%", Lobby.votedMap));
			if (isTraitor(player)) {
				player.sendMessage(MessagesHandler.convert("Gamestart.Traitor"));
			} else if (isDetective(player)) {
				player.sendMessage(MessagesHandler.convert("Gamestart.Detective"));
			} else if (isInnocent(player)) {
				player.sendMessage(MessagesHandler.convert("Gamestart.Innocent"));
			}
		}
	}

	public static void stop() {
		// TODO
	}
	
	public static boolean isTraitor(final Player player) {
		if (Traitors.contains(player)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isDetective(final Player player) {
		if (Detectives.contains(player)) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isInnocent(final Player player) {
		if (Innocents.contains(player)) {
			return true;
		} else {
			return false;
		}
	}

}
