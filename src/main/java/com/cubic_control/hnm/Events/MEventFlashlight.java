package com.cubic_control.hnm.Events;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.cubic_control.cubic_core.Utils.ModUtils;
import com.cubic_control.hnm.Items.IForwardLight;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class MEventFlashlight {
	
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		World world = player.worldObj;
		ItemStack stack = player.getHeldItem();
		if(world.isRemote){
			if(stack != null) {
				boolean flag = stack.getItem() instanceof IForwardLight;
				if(flag){
					MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0F);
				
					if(mop != null){
						if(stack == player.getItemInUse()){
							ModUtils.addLightToMOP(world, mop, player);
						}
					}
				}
			}
		}
	}
	
	

}
