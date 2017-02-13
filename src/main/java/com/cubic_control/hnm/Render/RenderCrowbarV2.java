package com.cubic_control.hnm.Render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;
import net.minecraftforge.client.IItemRenderer.ItemRendererHelper;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Lib.RefStrings;

public class RenderCrowbarV2 implements IItemRenderer{
	protected static ResourceLocation textureLocation1;
	protected static ResourceLocation textureLocation2;
	protected static ResourceLocation modelLocation;
	
	IModelCustom model;
	
	public RenderCrowbarV2(){
		textureLocation1 = new ResourceLocation(RefStrings.MODID + ":textures/models/blue_noise_dif.png");
		textureLocation2 = new ResourceLocation(RefStrings.MODID + ":textures/models/red_wood_dif.png");
		modelLocation = new ResourceLocation(RefStrings.MODID + ":obj/items/crowbar_v2.obj");
		
		model = AdvancedModelLoader.loadModel(modelLocation);
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
		
		GL11.glScalef(0.015f, 0.015f, 0.015f);
		switch(type){
		case ENTITY:
			//Note: x = +right or -left; y = +up or -down; z = +towards or -away;
			GL11.glTranslatef(0.0f, 26.0f, 3.0f);
			break;
		case EQUIPPED:
			GL11.glTranslatef(25.0f, 35.0f, 0.0f);
			break;
		case EQUIPPED_FIRST_PERSON:
			GL11.glRotatef(90F, 0.0f, 1.0f, 0.0f);
			GL11.glTranslatef(25.0f, 35.0f, 20.0f);
			break;
		case INVENTORY:
			break;
		default:
			break;
		}
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation1);
		model.renderPart("0");
		Minecraft.getMinecraft().getTextureManager().bindTexture(textureLocation2);
		model.renderPart("1");
        
		GL11.glPopMatrix(); 
	}
}