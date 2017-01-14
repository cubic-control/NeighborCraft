package com.cubic_control.hnm.Entity.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Entity.Model.ModelBlueKey;
import com.cubic_control.hnm.Lib.RefStrings;

public class RenderBlueKey implements IItemRenderer{
	
	ModelBlueKey model;
	
	protected static ResourceLocation texture;
	
	public RenderBlueKey(){
		model = new ModelBlueKey();
		texture = new ResourceLocation(RefStrings.MODID + ":textures/models/items/key_blue.png");
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
			GL11.glTranslatef(0.3f, -0.1f, -0.3f);
			break;
		case EQUIPPED:
			GL11.glRotatef(180F, 1.0f, 0.0f, 0.0f);
			GL11.glTranslatef(0.3f, -0.1f, -0.3f);
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