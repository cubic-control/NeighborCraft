package com.cubic_control.hnm.Events;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class MEventHandler {
	public static void registerEvents(){
		MinecraftForge.EVENT_BUS.register(new MEventZoom());
		FMLCommonHandler.instance().bus().register(new MEventBearTrap());
		MinecraftForge.EVENT_BUS.register(new MEventBinoculars());
	}

}
