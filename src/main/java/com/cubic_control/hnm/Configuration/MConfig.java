package com.cubic_control.hnm.Configuration;

import java.io.File;

import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

public class MConfig extends Configuration{
	
	private static String PATH;

	public static Configuration config;
	
	public static boolean hardcoreNeighbor = false;
	public static boolean rifleRequiresBullets = false;
	public static boolean doesRifleDoDamage = false;
	public static boolean useRealisticTextures = true;
	public static int helloNeighborVersion = 0;

	/**
	 * Creates Config file in custom folder in .minecraft folder.
	 */
	public static void createConfig(){
		PATH = "config/cubic_control/hnm/";
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
		useRealisticTextures = config.getBoolean("useRealisticTextures", ConfigTypes.BOOLEANS, true, "makes the items use more realistic textures.");
	}
	
	public static void addInts(){
		config.getCategory(ConfigTypes.INTS);
		helloNeighborVersion = config.getInt("helloNeighborVersion", ConfigTypes.INTS, 0, 0, 3, "selects the version of Hello Neighbor you want to use. 0 is PRE-ALPHA, 1 is ALPHA-1 and so-on");
	}
	
	public static Configuration getConfig(){
		return config;
	}

}