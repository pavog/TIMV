package com.evilcodes.timv;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.evilcodes.timv.commands.TIMVCommandExecutor;

public class TIMV extends JavaPlugin {
	
	public static final String prefix = "[TIMV] ";
	public static TIMV instance;
	public static boolean debug = false;
	public static File configFile;
	public static FileConfiguration config;
	public static File messagesFile;
	public static FileConfiguration messages;
	
	public void onEnable() {
		TIMV.instance = this;
		getCommand("timv").setExecutor(new TIMVCommandExecutor());
	}
	
	public void onDisable() {
		
	}

}
