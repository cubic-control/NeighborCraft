package com.cubic_control.hnm.GUI;

import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class GuiKeyhole extends GuiScreen{
	protected static ResourceLocation resource;
	
	public GuiKeyhole(){
		resource = new ResourceLocation(RefStrings.MODID + ":textures/overlay/keyhole.png");
	}
	
	@Override
	public void drawScreen(int par1, int par2, float par3) {
		mc.getTextureManager().bindTexture(resource);
		drawTexturedModalRect(0, 0, 0, 0, mc.displayWidth, mc.displayHeight);
		super.drawScreen(par1, par2, par3);
	}
	
	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}
}
