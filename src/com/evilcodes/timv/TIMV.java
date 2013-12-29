package com.evilcodes.timv;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.evilcodes.timv.commands.DetectiveCMD;
import com.evilcodes.timv.commands.MapCMD;
import com.evilcodes.timv.commands.NickCMD;
import com.evilcodes.timv.commands.PartyCMD;
import com.evilcodes.timv.commands.ShopCMD;
import com.evilcodes.timv.commands.StartCMD;
import com.evilcodes.timv.commands.StopCMD;
import com.evilcodes.timv.commands.TIMVCommandExecutor;
import com.evilcodes.timv.commands.TLCMD;
import com.evilcodes.timv.commands.TraitorCMD;
import com.evilcodes.timv.commands.VoteCMD;
import com.evilcodes.timv.handlers.FilesHandler;

public class TIMV extends JavaPlugin {
	
	public static final String prefix = "[TIMV] ";
	public static TIMV instance;
	public static boolean debug = false;
	public static File configFile;
	public static FileConfiguration config;
	public static File messagesFile;
	public static FileConfiguration messages;
	
	//TODO ADD SHOP ITEMS
	//TODO START PARTY
	//TODO SETNICKNAME
	//TODO Setspawn & Setlobby cmd
	
	public void onEnable() {
		TIMV.instance = this;
		FilesHandler.CheckForConfigs();
		getCommand("timv").setExecutor(new TIMVCommandExecutor());
		getCommand("detective").setExecutor(new DetectiveCMD());
		getCommand("map").setExecutor(new MapCMD());
		getCommand("nick").setExecutor(new NickCMD());
		getCommand("party").setExecutor(new PartyCMD());
		getCommand("shop").setExecutor(new ShopCMD());
		getCommand("startgame").setExecutor(new StartCMD());
		getCommand("stopgame").setExecutor(new StopCMD());
		getCommand("tl").setExecutor(new TLCMD());
		getCommand("traitor").setExecutor(new TraitorCMD());
		getCommand("vote").setExecutor(new VoteCMD());
	}
	
	public void onDisable() {
		
	}

}
