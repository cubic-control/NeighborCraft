package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.Items.IZoom;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.FOVUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MEventZoom {
	
	@SubscribeEvent
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
