package com.cubic_control.hnm.Events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;

import com.cubic_control.cubic_core.Utils.ModUtils;
import com.cubic_control.hnm.Blocks.IBlock;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class MEventDoorLocked {
	
	@SubscribeEvent
	public void onPlayerInteractEvent(PlayerInteractEvent event) {
		World world = event.entityPlayer.worldObj;
		Random rand = new Random();
		
		if(event.action == Action.RIGHT_CLICK_BLOCK && !event.entityPlayer.isSneaking()){
			Block block = event.entityPlayer.worldObj.getBlock(event.x, event.y, event.z);
			
			if(block instanceof BlockDoor){
				Block[] blocks = new Block[6];
				blocks = ModUtils.getBlocksAroundPoint(world, event.x, event.y, event.z);
				Block[] blocksLower = new Block[6];
				blocksLower = ModUtils.getBlocksAroundPoint(world, event.x, event.y-1, event.z);
				Block[] blocksHigher = new Block[6];
				blocksHigher = ModUtils.getBlocksAroundPoint(world, event.x, event.y+1, event.z);
				
				for(int i = 0; i < blocks.length; i++){
					Block block2 = blocks[i];
					
					if(block2 instanceof IBlock){
						boolean flag = ((IBlock) block2).blocksDoors();
						if(flag){
							world.playSoundAtEntity(event.entityPlayer, RefStrings.MODID + ":door.locked", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
							event.setCanceled(true);
						}
					}
				}
				
				for(int i = 0; i < blocksLower.length; i++){
					Block block2 = blocksLower[i];
					
					if(block2 instanceof IBlock){
						boolean flag = ((IBlock) block2).blocksDoors();
						if(flag){
							world.playSoundAtEntity(event.entityPlayer, RefStrings.MODID + ":door.locked", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
							event.setCanceled(true);
						}
					}
				}
				
				for(int i = 0; i < blocksHigher.length; i++){
					Block block2 = blocksHigher[i];
					
					if(block2 instanceof IBlock){
						boolean flag = ((IBlock) block2).blocksDoors();
						if(flag){
							world.playSoundAtEntity(event.entityPlayer, RefStrings.MODID + ":door.locked", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
							event.setCanceled(true);
						}
					}
				}
			}
		}
	}
}
