package com.cubic_control.hnm.Main;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.Model.ModelBiped64x64;
import com.cubic_control.hnm.Entity.Model.ModelBullet;
import com.cubic_control.hnm.Entity.Render.RenderBarricadeDouble;
import com.cubic_control.hnm.Entity.Render.RenderBarricadeSingle;
import com.cubic_control.hnm.Entity.Render.RenderBinoculars;
import com.cubic_control.hnm.Entity.Render.RenderBlueKey;
import com.cubic_control.hnm.Entity.Render.RenderBullet;
import com.cubic_control.hnm.Entity.Render.RenderCrowbar;
import com.cubic_control.hnm.Entity.Render.RenderFlashlight;
import com.cubic_control.hnm.Entity.Render.RenderGallonOfMilk;
import com.cubic_control.hnm.Entity.Render.RenderGoldenKey;
import com.cubic_control.hnm.Entity.Render.RenderGrave;
import com.cubic_control.hnm.Entity.Render.RenderHammer;
import com.cubic_control.hnm.Entity.Render.RenderMagnetGun;
import com.cubic_control.hnm.Entity.Render.RenderNeighbor;
import com.cubic_control.hnm.Entity.Render.RenderPadlockBlue;
import com.cubic_control.hnm.Entity.Render.RenderPadlockGolden;
import com.cubic_control.hnm.Entity.Render.RenderRedKey;
import com.cubic_control.hnm.Entity.Render.RenderRedPadlock;
import com.cubic_control.hnm.Entity.Render.RenderRifle;
import com.cubic_control.hnm.Entity.Render.RenderRustyKey;
import com.cubic_control.hnm.Entity.Render.RenderRustyPadlock;
import com.cubic_control.hnm.Entity.Render.RenderTechLock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeDouble;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeSingle;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGallonOfMilk;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGrave;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockBlue;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockGolden;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRedPadlock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRustyPadlock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityTechLock;
import com.cubic_control.hnm.Items.MItems;

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
	}
	public ModelBiped getArmorModel(int id){ return null; }
	
	public void registerRenders() {	
		if(MConfig.use3DModels){
			//Pre-Alpha
			MinecraftForgeClient.registerItemRenderer(MItems.binoculars, new RenderBinoculars());
			MinecraftForgeClient.registerItemRenderer(MItems.flashlight, new RenderFlashlight());
			MinecraftForgeClient.registerItemRenderer(MItems.hammer, new RenderHammer());
			MinecraftForgeClient.registerItemRenderer(MItems.key_rusty, new RenderRustyKey());
			//Alpha 1
			MinecraftForgeClient.registerItemRenderer(MItems.crowbar, new RenderCrowbar());
			MinecraftForgeClient.registerItemRenderer(MItems.rifle, new RenderRifle());
			//Alpha 2
			MinecraftForgeClient.registerItemRenderer(MItems.magnet_gun, new RenderMagnetGun());
			MinecraftForgeClient.registerItemRenderer(MItems.key_red, new RenderRedKey());
			//Alpha 3
			MinecraftForgeClient.registerItemRenderer(MItems.key_blue, new RenderBlueKey());
			MinecraftForgeClient.registerItemRenderer(MItems.key_golden, new RenderGoldenKey());
		}
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricadeDouble.class, new RenderBarricadeDouble());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricadeSingle.class, new RenderBarricadeSingle());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGrave.class, new RenderGrave());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRedPadlock.class, new RenderRedPadlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityRustyPadlock.class, new RenderRustyPadlock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTechLock.class, new RenderTechLock());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPadlockBlue.class, new RenderPadlockBlue());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPadlockGolden.class, new RenderPadlockGolden());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityGallonOfMilk.class, new RenderGallonOfMilk());
	}
}
