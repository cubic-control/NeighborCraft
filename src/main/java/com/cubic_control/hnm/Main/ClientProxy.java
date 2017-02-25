package com.cubic_control.hnm.Main;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.EntityShadow;
import com.cubic_control.hnm.Entity.EntityThePlayer;
import com.cubic_control.hnm.Entity.Model.ModelBiped64x64;
import com.cubic_control.hnm.Entity.Model.ModelBullet;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeDouble;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeSingle;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBearTrap;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityCamera;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGallonOfMilk;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGrave;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockBlue;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockGolden;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRedPadlock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRustyPadlock;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Render.RenderBarricadeDouble;
import com.cubic_control.hnm.Render.RenderBarricadeSingle;
import com.cubic_control.hnm.Render.RenderBearTrap;
import com.cubic_control.hnm.Render.RenderBinoculars;
import com.cubic_control.hnm.Render.RenderBlueKey;
import com.cubic_control.hnm.Render.RenderBullet;
import com.cubic_control.hnm.Render.RenderCamera;
import com.cubic_control.hnm.Render.RenderCrowbar;
import com.cubic_control.hnm.Render.RenderCrowbarV2;
import com.cubic_control.hnm.Render.RenderElectromagnet;
import com.cubic_control.hnm.Render.RenderElectromagnetV2;
import com.cubic_control.hnm.Render.RenderFlashlight;
import com.cubic_control.hnm.Render.RenderGallonOfMilk;
import com.cubic_control.hnm.Render.RenderGoldenKey;
import com.cubic_control.hnm.Render.RenderGrave;
import com.cubic_control.hnm.Render.RenderKey;
import com.cubic_control.hnm.Render.RenderKey_card;
import com.cubic_control.hnm.Render.RenderKey_rr;
import com.cubic_control.hnm.Render.RenderLockPick;
import com.cubic_control.hnm.Render.RenderNailPuller;
import com.cubic_control.hnm.Render.RenderNeighbor;
import com.cubic_control.hnm.Render.RenderPadlockBlue;
import com.cubic_control.hnm.Render.RenderPadlockGolden;
import com.cubic_control.hnm.Render.RenderKey_player;
import com.cubic_control.hnm.Render.RenderRedPadlock;
import com.cubic_control.hnm.Render.RenderRifle;
import com.cubic_control.hnm.Render.RenderRustyPadlock;
import com.cubic_control.hnm.Render.RenderShadow;
import com.cubic_control.hnm.Render.RenderTechLock;
import com.cubic_control.hnm.Render.RenderThePlayer;
import com.cubic_control.hnm.Render.RenderWrench;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{
	public void registerRenderInfo(){
		registerEntity();
		registerRenders();
	}
	public int addArmor(String armor){
		return RenderingRegistry.addNewArmourRendererPrefix(armor);
	}
	@SuppressWarnings("unchecked")
	private void registerEntity() {
		RenderingRegistry.registerEntityRenderingHandler(EntityNeighbor.class, new RenderNeighbor(new ModelBiped64x64(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(new ModelBullet(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderShadow(new ModelBiped(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityThePlayer.class, new RenderThePlayer(new ModelBiped64x64(), 0.5f));
	}
	public ModelBiped getArmorModel(int id){ return null; }
	
	public void registerRenders() {	
		if(MConfig.doItemsUse3DModels){
			//Pre-Alpha
			MinecraftForgeClient.registerItemRenderer(MItems.binoculars, new RenderBinoculars());
			MinecraftForgeClient.registerItemRenderer(MItems.flashlight, new RenderFlashlight());
			MinecraftForgeClient.registerItemRenderer(MItems.hammer, new RenderNailPuller());
			MinecraftForgeClient.registerItemRenderer(MItems.key_rusty, new RenderKey());
			//Alpha 1
			MinecraftForgeClient.registerItemRenderer(MItems.crowbar, new RenderCrowbar());
			MinecraftForgeClient.registerItemRenderer(MItems.rifle, new RenderRifle());
			//Alpha 2
			MinecraftForgeClient.registerItemRenderer(MItems.keycard, new RenderKey_card());
			MinecraftForgeClient.registerItemRenderer(MItems.lockpick, new RenderLockPick());
			MinecraftForgeClient.registerItemRenderer(MItems.magnet_gun, new RenderElectromagnet());
			MinecraftForgeClient.registerItemRenderer(MItems.key_red, new RenderKey_player());
			MinecraftForgeClient.registerItemRenderer(MItems.wrench, new RenderWrench());
			MinecraftForgeClient.registerItemRenderer(MItems.key_sun, new RenderKey_rr());
			//Alpha 3
			//MinecraftForgeClient.registerItemRenderer(MItems.crowbar_v2, new RenderCrowbarV2());
			MinecraftForgeClient.registerItemRenderer(MItems.key_blue, new RenderBlueKey());
			MinecraftForgeClient.registerItemRenderer(MItems.key_golden, new RenderGoldenKey());
			//MinecraftForgeClient.registerItemRenderer(MItems.magnet_gun_v2, new RenderElectromagnetV2());
		}
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricadeDouble.class, new RenderBarricadeDouble());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricadeSingle.class, new RenderBarricadeSingle());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrave.class, new RenderGrave());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRedPadlock.class, new RenderRedPadlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRustyPadlock.class, new RenderRustyPadlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKAL.class, new RenderTechLock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPadlockBlue.class, new RenderPadlockBlue());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPadlockGolden.class, new RenderPadlockGolden());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGallonOfMilk.class, new RenderGallonOfMilk());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityCamera.class, new RenderCamera());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBearTrap.class, new RenderBearTrap());
	}
}
