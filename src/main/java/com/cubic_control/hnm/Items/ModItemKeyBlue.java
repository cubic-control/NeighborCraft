package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemKeyBlue extends ModItem{

	public ModItemKeyBlue(String name, float f1) {
		super(name, f1);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		if(block == MBlocks.padlock_blue){
			world.playSoundAtEntity(player, RefStrings.MODID + ":lock.creakingkeyunlock", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.setBlock(x, y, z, Blocks.air);
			block.dropBlockAsItem(world, x, y, z, 0, 0);
			return true;
		}else{
			return false;
		}
	}

}
