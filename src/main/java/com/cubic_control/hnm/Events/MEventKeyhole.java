package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModBlockDoor;
import com.cubic_control.hnm.GUI.GuiBinoculars;
import com.cubic_control.hnm.GUI.GuiKeyhole;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class MEventKeyhole {
	private boolean b0;
	
	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		EntityPlayer player = event.entityPlayer;
		
		if(player.isSneaking()){
			 if(event.action == Action.RIGHT_CLICK_BLOCK){
				 Block block = event.world.getBlock(event.x, event.y, event.z);
				 
				 if(block == MBlocks.door_white){
					 b0 = true;
				 }else{
					 b0 = false;
				 }
			 }else{
				 b0 = false;
			 }
		}else{
			b0 = false;
		}
	}
	
	@SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {
        if(b0){
        	GuiKeyhole gui = new GuiKeyhole();
        	gui.RenderGui(event.resolution);
        }
	}

}
