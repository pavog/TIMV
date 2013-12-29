package com.evilcodes.timv.game;

import java.util.ArrayList;

import org.bukkit.entity.Player;

public class Lobby {
	
	public static boolean started = true;
	public static int timeleft = 120;
	public static int map1votes = 0;
	public static int map2votes = 0;
	public static int map3votes = 0;
	public static ArrayList<Player> forcedTraitors = new ArrayList<Player>();
	public static ArrayList<Player> forcedDetectives = new ArrayList<Player>();
	public static String forcedMap = "";
	public static String votedMap = "";
	
	public static void start() {
		//TODO Start Countdown, Get Mapvotes, Get best voted map and save in votedMap
	}

}
