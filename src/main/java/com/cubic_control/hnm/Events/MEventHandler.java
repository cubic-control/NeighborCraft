package com.cubic_control.hnm.Events;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class MEventHandler {
	public static void registerEvents(){
		MinecraftForge.EVENT_BUS.register(new MEventZoom());
		FMLCommonHandler.instance().bus().register(new MEventBearTrap());
		MinecraftForge.EVENT_BUS.register(new MEventBinoculars());
		FMLCommonHandler.instance().bus().register(new MEventFlashlight());
		MinecraftForge.EVENT_BUS.register(new MEventMonoculars());
	}

}
