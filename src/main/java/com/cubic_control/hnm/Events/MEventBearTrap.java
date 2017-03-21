package com.cubic_control.hnm.Events;

import java.util.Random;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class MEventBearTrap {
	
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		Random rand = new Random();
		World world = event.player.worldObj;
		EntityPlayer player = event.player;
		Block block = world.getBlock(MathHelper.floor_double(player.posX),
				MathHelper.floor_double(player.posY - 0.20000000298023224D - (double)player.yOffset),
				MathHelper.floor_double(player.posZ));
		
		if(block == MBlocks.bear_trap){
			event.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 25, 10));
			//world.playSoundAtEntity(player, RefStrings.MODID + ":beartrap.close", 0.5F, 1.0F);
		}
	}
}
