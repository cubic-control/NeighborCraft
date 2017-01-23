package com.cubic_control.hnm.Entity.TileEntity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class MTileEntity {
	public static void createTileEntity(){
		//Pre-Alpha
		GameRegistry.registerTileEntity(TileEntityBearTrap.class, "bear_trap_TileEntity");
		GameRegistry.registerTileEntity(TileEntityCamera.class, "camera_TileEntity");
		GameRegistry.registerTileEntity(TileEntityRustyPadlock.class, "padlock_rusty_TileEntity");
		//Alpha 1
		GameRegistry.registerTileEntity(TileEntityGrave.class, "grave_TileEntity");
		//Alpha 2
		GameRegistry.registerTileEntity(TileEntityGallonOfMilk.class, "gallon_of_milk_TileEntity");
		GameRegistry.registerTileEntity(TileEntityKAL.class, "KAL_TileEntity");
		GameRegistry.registerTileEntity(TileEntityRedPadlock.class, "padlock_red_TileEntity");
		//Alpha 3
		GameRegistry.registerTileEntity(TileEntityPadlockBlue.class, "padlock_blue_TileEntity");
		GameRegistry.registerTileEntity(TileEntityPadlockGolden.class, "padlock_golden_TileEntity");
		//Custom
		GameRegistry.registerTileEntity(TileEntityBarricadeDouble.class, "barricade_double_TileEntity");
		GameRegistry.registerTileEntity(TileEntityBarricadeSingle.class, "barricade_single_TileEntity");
	}
}
