package com.cubic_control.hnm.Events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.cubic_control.cubic_core.Utils.ModUtils;
import com.cubic_control.hnm.Blocks.IBlock;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MEventChestLocked {
	
	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		World world = event.entityPlayer.worldObj;
		Random rand = new Random();
		
		if(event.action == Action.RIGHT_CLICK_BLOCK){
			Block block = event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z);
			
			if(block instanceof BlockChest){
				Block[] blocks = new Block[6];
				blocks = ModUtils.getBlocksAroundPoint(world, event.x, event.y, event.z);
				
				for(int i = 0; i < blocks.length; i++){
					Block block2 = blocks[i];
					
					if(block2 instanceof IBlock){
						boolean flag = ((IBlock) block2).blocksChest();
						if(flag){
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}
}
