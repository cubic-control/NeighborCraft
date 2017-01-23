package com.cubic_control.hnm.Entity.Render;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Entity.Model.ModelPadlockGolden;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderPadlockGolden extends TileEntitySpecialRenderer{
	
	ModelPadlockGolden model;
	protected static ResourceLocation texture;
	
	public RenderPadlockGolden(){
		model = new ModelPadlockGolden();
		texture = new ResourceLocation(RefStrings.MODID + ":textures/models/blocks/lock_golden.png");
	}
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float par5, int par6) {
		GL11.glPushMatrix();
    	GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
          
    	bindTexture(texture);
    	GL11.glPushMatrix();
    	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
    	int rotation = 0;
    	switch (tile.getBlockMetadata() % 4) {
    		case 0:
    			rotation = 270;
    			break;
    		case 1:
    			rotation = 0;
    			break;
    		case 2:
    			rotation = 90;
    			break;
    		case 3:
    			rotation = 180;
    			break;
    	}
    	GL11.glRotatef(rotation, 0.0F, 1.0F, 0.0F);
    	
    	this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
    	GL11.glPopMatrix();
    	GL11.glPopMatrix();
	}

}
