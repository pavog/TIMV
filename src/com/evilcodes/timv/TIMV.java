package com.evilcodes.timv;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.evilcodes.timv.CommandManager;

public class TIMV extends JavaPlugin {

	  public Listener PlayerListener = new PlayerListener(this);
	  public Listener ServerListener = new ServerListener(this);
	  public static Logger logger;
	  public PlayerListener events;
	  public static TIMV instance;
	  public TIMV p;
	  public PluginManager pm;
	  public PlayerListener PL;	 
	  public static TIMV getInstance() {
		    return instance;
		  }	  
	
	public void onEnable() {
		getLogger().info("Plugin enabled!");
		instance = this;
		getServer().getPluginManager().registerEvents(this.PlayerListener, this);
		getServer().getPluginManager().registerEvents(this.ServerListener, this);
	    this.pm = getServer().getPluginManager();
	    getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
	    getServer().getPluginManager().registerEvents(new ServerListener(this), this);
	    Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	    this.getCommand("timv").setExecutor(new CommandManager());
	    	    
	    getConfig().options().copyDefaults(true);
	    saveConfig();
	    
	    
	    if (getServer().getPluginManager().getPlugin("TagAPI") == null) {
	        getLogger().log(Level.SEVERE, pluginRequiredMessage("TagAPI"));
	        getServer().getPluginManager().disablePlugin(this);
	        return;
	    }
	    
	    //MAYBE ADD VAULT!
	  }
	
	public void onDisable() {
		getLogger().info("Plugin disabled!");
	}
		
	
	  public String pluginRequiredMessage(String plugin) {
		    return "\n------------------------------ [ ERROR ] ------------------------------\n-----------------------------------------------------------------------\n\n" + plugin + " ist für TIMV benötigt!!!\nDownload: " + plugin + "!\nDownloade es hier: " + getPluginURL(plugin) + "\nTIMV wird vorerst abgeschaltet...\n\n-----------------------------------------------------------------------\n-----------------------------------------------------------------------";
		  }
	  
	  public String getPluginURL(String plugin) {
		    if (plugin.equalsIgnoreCase("TagAPI")) {
		      return "http://dev.bukkit.org/server-mods/tag/";
		    }
		    return "";
		  }	  
}

