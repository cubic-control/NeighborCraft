package com.cubic_control.hnm.Entity.TileEntity;

import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;

public class MTileEntity {
	public static void createTileEntity(){
		GameRegistry.registerTileEntity(TileEntityBarricade.class, "Barricade_TileEntity");
		GameRegistry.registerTileEntity(TileEntityTechLock.class, "TechLock_TileEntity");
	}
}
