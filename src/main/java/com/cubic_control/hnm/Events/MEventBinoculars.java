package com.cubic_control.hnm.Events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.cubic_control.hnm.GUI.GuiBinoculars;
import com.cubic_control.hnm.Items.MItems;

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
