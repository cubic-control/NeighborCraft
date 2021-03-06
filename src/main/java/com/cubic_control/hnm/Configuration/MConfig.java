package com.cubic_control.hnm.Configuration;

import java.io.File;

import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class MConfig extends Configuration{
	
	private static String PATH;

	public static Configuration config;
	
	public static boolean hardcoreNeighbor;
	public static boolean rifleRequiresBullets;
	public static boolean doesRifleDoDamage;
	public static boolean isPlayerFasterThanNeighbor;
	public static boolean canGetKeyFromNeighbor;
	public static boolean doItemsUse3DModels;
	public static boolean valentinesMode;

	/**
	 * Creates Config file in custom folder in .minecraft folder.
	 */
	public static void createConfig(){
		PATH = "config/cubic_control/hnm/1.7/";
		File file = new File(PATH + "ConfigurationFile.cfg");
		config = new Configuration(file);
		config.load();
		syncConfig();
	}
	
	public static void syncConfig() {
		addBooleans();
		addInts();

	    if(config.hasChanged()){
	    	config.save();
	    }
	  }
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if(eventArgs.modID.equals(RefStrings.MODID)){
			syncConfig();
		}
	}
	
	/**
	 * Add Booleans to config file.
	 */
	public static void addBooleans(){
		config.getCategory(ConfigTypes.BOOLEANS);
		hardcoreNeighbor = config.getBoolean("hardcoreNeighbor", ConfigTypes.BOOLEANS, false, "makes the neighbor realy strong.");
		rifleRequiresBullets = config.getBoolean("rifleRequiresBullets", ConfigTypes.BOOLEANS, false, "makes the rifle require bullets too shoot.");
		doesRifleDoDamage = config.getBoolean("doesRifleDoDamage", ConfigTypes.BOOLEANS, false, "makes the rifle bullets do damage.");
		isPlayerFasterThanNeighbor = config.getBoolean("isPlayerFasterThanNeighbor", ConfigTypes.BOOLEANS, false, "if true, the player is faster than the neighbor.");
		canGetKeyFromNeighbor = config.getBoolean("canGetKeyFromNeighbor", ConfigTypes.BOOLEANS, true, "sets if you can get a red key from the neighbor by shift-right clicking him.");
		doItemsUse3DModels = config.getBoolean("doItemsUse3DModels", ConfigTypes.BOOLEANS, true, "makes the items in the mod use 3D models.");
		valentinesMode = config.getBoolean("valentinesMode", ConfigTypes.BOOLEANS, false, "puts the neighbor and player in valentines mode(there PINK AND PURPLE!).");
	}
	
	public static void addInts(){
		config.getCategory(ConfigTypes.INTS);
	}
	
	public static Configuration getConfig(){
		return config;
	}

}