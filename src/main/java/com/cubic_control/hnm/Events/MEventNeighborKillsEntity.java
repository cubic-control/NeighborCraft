package com.cubic_control.hnm.Events;

import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDeathEvent;

public class MEventNeighborKillsEntity {
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event){
		Entity entity = event.entityLiving;
		World world = entity.worldObj;
		if(entity instanceof EntityPlayer){
			world.playSoundAtEntity(entity, RefStrings.MODID + ":neighbor.kill.entity", 0.5F, 1.0F);
		}
	}

}
