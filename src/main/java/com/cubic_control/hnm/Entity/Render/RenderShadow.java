package com.cubic_control.hnm.Entity.Render;

import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderShadow extends RenderBiped{
	
	protected static ResourceLocation entityTexture;

	public RenderShadow(ModelBase par1ModelBase, float par2) {
		super(Minecraft.getMinecraft().getRenderManager(), (ModelBiped) par1ModelBase, par2);
		
		entityTexture = new ResourceLocation(RefStrings.MODID + ":textures/entity/shadow.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return entityTexture;
	}

}
