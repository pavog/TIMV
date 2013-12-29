package com.evilcodes.timv.handlers;

import org.bukkit.Bukkit;

import com.evilcodes.timv.TIMV;

public class LogHandler {

	public static void log(String msg) {
		Bukkit.getLogger().info(TIMV.prefix + msg);
	}
	
	public static void err(String msg) {
		Bukkit.getLogger().severe(TIMV.prefix + msg);
	}
	
	public static void stackerr(Exception msg) {
		if (TIMV.debug) {
			Bukkit.getLogger().severe(TIMV.prefix + msg);
		}
	}
}
