package com.cubic_control.hnm.Main;

import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.MEntity;
import com.cubic_control.hnm.Entity.TileEntity.MTileEntity;
import com.cubic_control.hnm.Events.MEventHandler;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

@Mod(modid = RefStrings.MODID, name = RefStrings.NAME, version = RefStrings.VERSION, guiFactory = RefStrings.GUIFACTORY)
public class MainRegistry {
	@SidedProxy(clientSide = RefStrings.CLIENTSIDE, serverSide = RefStrings.SERVERSIDE)
	public static ServerProxy proxy;
	
	@Mod.Instance(RefStrings.MODID)
	public static MainRegistry instance;
	
	@EventHandler
	public static void Preload(FMLPreInitializationEvent PreEvent){
		MConfig.createConfig();
		MCreativeTabs.createTabs();
		MTileEntity.createTileEntity();
		MBlocks.createBlocks();
		MEntity.createEntity();
		MItems.createItems();
		CraftingRecipes.createRecipes();
		proxy.registerRenderInfo();
	}
	@EventHandler
	public static void load(FMLInitializationEvent event){
		FMLCommonHandler.instance().bus().register(instance);
		MEventHandler.registerEvents();
		proxy.registerRenders();
	}
	@EventHandler
	public static void Postload(FMLPostInitializationEvent PostEvent){
	}
	
	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if(eventArgs.modID.equals(RefStrings.MODID)){
			MConfig.syncConfig();
		}
	}
}
