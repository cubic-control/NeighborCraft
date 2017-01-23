package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.GUI.GuiBinoculars;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class MEventBinoculars {
	
	@SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;
        ItemStack heldItem = player.getItemInUse();
        
        if(heldItem != null && heldItem.getItem() == MItems.binoculars) {
        	GuiBinoculars gui = new GuiBinoculars();
        	gui.RenderGui();
        }
	}

}
