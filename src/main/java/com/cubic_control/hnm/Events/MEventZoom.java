package com.cubic_control.hnm.Events;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;

import com.cubic_control.hnm.Items.IZoom;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MEventZoom {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void updateFOV(FOVUpdateEvent event) {
		ItemStack stack = event.entity.getItemInUse();

		if (stack != null) {
			boolean flag = stack.getItem() instanceof IZoom;
			if (flag) {
				float zoomFactor = ((IZoom) stack.getItem()).getZoomFactor();
				
				event.newfov = zoomFactor;
			}
		}
	}

}
