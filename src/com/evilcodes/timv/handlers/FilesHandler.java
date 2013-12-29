package com.evilcodes.timv.handlers;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

import com.evilcodes.timv.TIMV;

public class FilesHandler {
		
	public static void CheckForConfigs() {
		TIMV.configFile = new File(TIMV.instance.getDataFolder(), "config.yml");
		TIMV.messagesFile = new File(TIMV.instance.getDataFolder(), "messages.yml");
		
		if (!TIMV.configFile.exists()) {
			LogHandler.log("No Configfile found, creating...");
			setConfigs();
		}
		if (!TIMV.messagesFile.exists()) {
			LogHandler.log("No Messagesfile found, creating...");
			setConfigs();
		}
		LoadFiles();
	}
	
	public static void SaveFiles() {
	    try {
	    	TIMV.config.save(TIMV.configFile);
	    	TIMV.messages.save(TIMV.messagesFile);
	    }
	    catch (Exception e) {
	    	LogHandler.err("Could not save configfiles!");
	    	LogHandler.stackerr(e);
	    }
	}
	
	public static void LoadFiles() {
	   	try {
	   	   if (TIMV.config == null) {
	   	    TIMV.configFile = new File(TIMV.instance.getDataFolder(), "config.yml");
	   	    }
	   		TIMV.config = YamlConfiguration.loadConfiguration(TIMV.configFile);
	   		
		   	if (TIMV.messages == null) {
			    TIMV.messagesFile = new File(TIMV.instance.getDataFolder(), "messages.yml");
			}
	   		TIMV.messages = YamlConfiguration.loadConfiguration(TIMV.messagesFile);
		} catch (Exception e) {
	    	LogHandler.err("Could not load configfiles!");
	    	LogHandler.stackerr(e);
		}
	}
		
	public static void setConfigs() {
	    if (!TIMV.configFile.exists()) {      
	         TIMV.instance.saveResource("config.yml", false);
	     }
	    TIMV.config = YamlConfiguration.loadConfiguration(TIMV.configFile);
	    
	    if (!TIMV.messagesFile.exists()) {      
	         TIMV.instance.saveResource("messages.yml", false);
	     }
	    TIMV.messages = YamlConfiguration.loadConfiguration(TIMV.messagesFile);
	    
	}
		
	
}

