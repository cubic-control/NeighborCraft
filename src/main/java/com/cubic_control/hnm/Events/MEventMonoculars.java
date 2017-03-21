package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.GUI.GuiMonoculars;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class MEventMonoculars {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
    public void renderOverlay(RenderGameOverlayEvent event) {
		Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.thePlayer;
        ItemStack heldItem = player.getItemInUse();
        
        if(heldItem != null && heldItem.getItem() == MItems.monoculars) {
        	GuiMonoculars gui = new GuiMonoculars();
        	gui.RenderGui(event.resolution);
        }
	}

}
