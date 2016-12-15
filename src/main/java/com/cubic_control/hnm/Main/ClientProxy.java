package com.cubic_control.hnm.Main;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.client.MinecraftForgeClient;

import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.Model.ModelBiped64x64;
import com.cubic_control.hnm.Entity.Model.ModelBullet;
import com.cubic_control.hnm.Entity.Render.RenderBarricade;
import com.cubic_control.hnm.Entity.Render.RenderBinoculars;
import com.cubic_control.hnm.Entity.Render.RenderBullet;
import com.cubic_control.hnm.Entity.Render.RenderCrowbar;
import com.cubic_control.hnm.Entity.Render.RenderFlashlight;
import com.cubic_control.hnm.Entity.Render.RenderHammer;
import com.cubic_control.hnm.Entity.Render.RenderRedKey;
import com.cubic_control.hnm.Entity.Render.RenderMagnetGun;
import com.cubic_control.hnm.Entity.Render.RenderNeighbor;
import com.cubic_control.hnm.Entity.Render.RenderRifle;
import com.cubic_control.hnm.Entity.Render.RenderRustyKey;
import com.cubic_control.hnm.Entity.Render.RenderTechLock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricade;
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
		MinecraftForgeClient.registerItemRenderer(MItems.magnet_gun, new RenderMagnetGun());
		MinecraftForgeClient.registerItemRenderer(MItems.rifle, new RenderRifle());
		MinecraftForgeClient.registerItemRenderer(MItems.red_key, new RenderRedKey());
		MinecraftForgeClient.registerItemRenderer(MItems.crowbar, new RenderCrowbar());
		MinecraftForgeClient.registerItemRenderer(MItems.rusty_key, new RenderRustyKey());
		MinecraftForgeClient.registerItemRenderer(MItems.hammer, new RenderHammer());
		MinecraftForgeClient.registerItemRenderer(MItems.flashlight, new RenderFlashlight());
		MinecraftForgeClient.registerItemRenderer(MItems.binoculars, new RenderBinoculars());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBarricade.class, new RenderBarricade());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTechLock.class, new RenderTechLock());
	}
}
