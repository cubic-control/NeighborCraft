package com.cubic_control.hnm.Events;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Lib.RefStrings;

public class MEventBearTrap {
	
	@SubscribeEvent
	public void onPlayerTickEvent(PlayerTickEvent event) {
		Random rand = new Random();
		World world = event.player.worldObj;
		EntityPlayer player = event.player;
		Block block = world.getBlockState(new BlockPos(MathHelper.floor_double(player.posX),
				MathHelper.floor_double(player.posY - 0.20000000298023224D - (double)player.renderOffsetY),
				MathHelper.floor_double(player.posZ))).getBlock();
		
		if(block == MBlocks.bear_trap){
			event.player.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 25, 10));
			world.playSoundAtEntity(player, RefStrings.MODID + ":", 0.5F, 0.4F / (rand.nextFloat() * 0.4F + 0.8F));
		}
	}
}
