package com.cubic_control.hnm.Entity.Render;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Entity.Model.ModelMagnetGun;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderMagnetGun implements IItemRenderer{
	
	ModelMagnetGun model;
	
	protected static ResourceLocation texture;
	
	public RenderMagnetGun(){
		model = new ModelMagnetGun();
		texture = new ResourceLocation(RefStrings.MODID + ":textures/models/items/gun_magnet.png");
	}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
		case ENTITY:
			return true;
		case EQUIPPED:
			return true;
		case EQUIPPED_FIRST_PERSON:
			return true;
		case INVENTORY:
			return false;
		default:
			return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
        
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		switch(type){
		case ENTITY:
			GL11.glRotatef(180F, 1.0f, 0.0f, 0.0f);
			GL11.glTranslatef(0.3f, 0.3f, -0.7f);
			break;
		case EQUIPPED:
			GL11.glRotatef(180F, 1.0f, 0.0f, 0.0f);
			GL11.glTranslatef(0.3f, 0.3f, -0.7f);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glRotatef(180F, 0.0f, 0.0f, 1.0f);
			GL11.glRotatef(90F, 0.0f, 1.0f, 0.0f);
			GL11.glRotatef(-20F, 1.0f, 0.0f, 0.0f);
			GL11.glTranslatef(0.3f, -0.3f, -1.0f);
			break;
		case INVENTORY:
			break;
		default:
			break;
		}
        
		model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        
		GL11.glPopMatrix(); 
	}
}
