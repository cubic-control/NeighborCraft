package com.cubic_control.hnm.GUI;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiBinoculars extends Gui{
	protected static ResourceLocation resource;
	
	public GuiBinoculars(){
		resource = new ResourceLocation(RefStrings.MODID + ":textures/overlay/binoculars.png");
	}
	
	public void RenderGui(){
		Minecraft mc = Minecraft.getMinecraft();
		GL11.glPushMatrix();
		GL11.glScaled(1.65D, 1.3D, 1.3D);
		mc.getTextureManager().bindTexture(resource);
		drawTexturedModalRect(0, 0, 0, 0, mc.displayWidth, mc.displayHeight);
		GL11.glPopMatrix();
	}
}
