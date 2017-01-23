package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.EntityShadow;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModItemSpawnItem extends ModItem{
	private EntityLiving entityToSpawn;

	public ModItemSpawnItem(String name) {
		super(name);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			if(this == MItems.spawn_neighbor){
				entityToSpawn = new EntityNeighbor(world);
			}else if(this == MItems.spawn_shadow){
				entityToSpawn = new EntityShadow(world);
			}
			entityToSpawn.setLocationAndAngles(pos.getX(), pos.getY()+1, pos.getZ(), MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			world.spawnEntityInWorld(entityToSpawn);
			entityToSpawn.playLivingSound();
			return true;
		}

		return false;
	}

}
