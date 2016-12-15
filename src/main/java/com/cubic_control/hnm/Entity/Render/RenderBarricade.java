package com.cubic_control.hnm.Entity.Render;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Entity.Model.ModelBarricade;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class RenderBarricade extends TileEntitySpecialRenderer{
	
	ModelBarricade model;
	protected static ResourceLocation texture;
	
	public RenderBarricade(){
		model = new ModelBarricade();
		texture = new ResourceLocation(RefStrings.MODID + ":textures/blocks/barricade.png");
	}
	
	private void adjustRotatePivotViaMeta(World world, int x, int y, int z){
    	int meta = world.getBlockMetadata(x, y, z);
    	GL11.glPushMatrix();
    	GL11.glRotatef(meta * (-90), 0.0F, 0.0F, 1.0F);
    	GL11.glPopMatrix();
    }
	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
		GL11.glPushMatrix();
    	GL11.glTranslatef((float) var2 + 0.5F, (float) var4 + 1.5F, (float) var6 + 0.5F);
          
    	bindTexture(texture);
    	GL11.glPushMatrix();
    	GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
            
    	int rotation = 0;
    	switch (var1.getBlockMetadata() % 4) {
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
	
	private void adjustLightFixture(World world, int i, int j, int k, Block block){
    	Tessellator tess = Tessellator.instance;
    	float brightness = block.getLightOpacity(world, i, j, k);
    	int skyLight = world.getLightBrightnessForSkyBlocks(i, j, k, 0);
    	int modulousModifier = skyLight % 65536;
    	int divModifier = skyLight / 65536;
    	tess.setColorOpaque_F(brightness, brightness, brightness);
    	OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  (float) modulousModifier,  divModifier);
    }

}
