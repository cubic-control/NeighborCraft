package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ModItemLockpick extends ModItem{

	public ModItemLockpick(String name) {
		super(name);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlockState(pos).getBlock();
		if(block == MBlocks.padlock_blue || block == MBlocks.padlock_golden || block == MBlocks.padlock_red || block == MBlocks.padlock_rusty){
			world.playSoundAtEntity(player, RefStrings.MODID + ":lock.creakingkeyunlock", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			world.setBlockState(pos, (IBlockState) Blocks.air.getDefaultState());
			world.setTileEntity(pos, null);
			block.dropBlockAsItem(world, pos, null, 0);
			return true;
		}else{
			return false;
		}
	}

}
