package com.cubic_control.hnm.Render;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderNeighbor extends RenderLiving{
	
	protected static ResourceLocation entityTexture;

	public RenderNeighbor(ModelBase par1ModelBase, float par2) {
		super(par1ModelBase, par2);
		if(MConfig.valentinesMode){
			entityTexture = new ResourceLocation(RefStrings.MODID + ":textures/entity/v_neighbor.png");
		}else{
			entityTexture = new ResourceLocation(RefStrings.MODID + ":textures/entity/neighbor.png");
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return entityTexture;
	}

}
