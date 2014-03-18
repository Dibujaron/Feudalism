package com.dibujaron.feudalism;

import org.bukkit.plugin.java.JavaPlugin;

import com.dibujaron.feudalism.files.ConfigHandler;

public class Feudalism extends JavaPlugin{
	
	private static Feudalism f;
	
	public void onEnable(){
		ConfigHandler.loadConfig(getConfig());
		f = this;
	}
	
	public static Feudalism getInstance(){
		//returns the instance of this class that's created on plugin load.
		//A useful trick for easy main-class access from other classes.
		return f;
	}
}
