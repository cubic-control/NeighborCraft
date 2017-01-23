package com.cubic_control.hnm.Main;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.EntityShadow;
import com.cubic_control.hnm.Entity.Model.ModelBiped64x64;
import com.cubic_control.hnm.Entity.Model.ModelBullet;
import com.cubic_control.hnm.Entity.Render.RenderBarricadeDouble;
import com.cubic_control.hnm.Entity.Render.RenderBarricadeSingle;
import com.cubic_control.hnm.Entity.Render.RenderBearTrap;
import com.cubic_control.hnm.Entity.Render.RenderBullet;
import com.cubic_control.hnm.Entity.Render.RenderCamera;
import com.cubic_control.hnm.Entity.Render.RenderGallonOfMilk;
import com.cubic_control.hnm.Entity.Render.RenderGrave;
import com.cubic_control.hnm.Entity.Render.RenderNeighbor;
import com.cubic_control.hnm.Entity.Render.RenderPadlockBlue;
import com.cubic_control.hnm.Entity.Render.RenderPadlockGolden;
import com.cubic_control.hnm.Entity.Render.RenderRedPadlock;
import com.cubic_control.hnm.Entity.Render.RenderRustyPadlock;
import com.cubic_control.hnm.Entity.Render.RenderShadow;
import com.cubic_control.hnm.Entity.Render.RenderTechLock;
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

public class ClientProxy extends ServerProxy{
	@Override
	public void registerRenderInfo(){
		registerTileEntity();
	}
	@SuppressWarnings("unchecked")
	private void registerEntityRenders() {
		RenderingRegistry.registerEntityRenderingHandler(EntityNeighbor.class, new RenderNeighbor(new ModelBiped64x64(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityBullet.class, new RenderBullet(new ModelBullet(), 0.5f));
		RenderingRegistry.registerEntityRenderingHandler(EntityShadow.class, new RenderShadow(new ModelBiped(), 0.5f));
	}
	private void registerTileEntity(){
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
	@Override
	public void registerRenders() {
		MBlocks.registerBlockRenderer();
		registerEntityRenders();
		MItems.registerItemRenderer();
	}
}
