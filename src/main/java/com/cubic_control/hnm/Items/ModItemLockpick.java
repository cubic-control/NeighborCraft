package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemLockpick extends ModItem{

	public ModItemLockpick(String name) {
		super(name);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		if(block == MBlocks.padlock_blue || block == MBlocks.padlock_golden || block == MBlocks.padlock_red || block == MBlocks.padlock_rusty){
			world.setBlock(x, y, z, Blocks.air);
			block.dropBlockAsItem(world, x, y, z, 0, 0);
			player.inventory.consumeInventoryItem(this);
			return true;
		}else{
			return false;
		}
	}

}
