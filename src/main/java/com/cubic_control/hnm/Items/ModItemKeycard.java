package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemKeycard extends ModItem{

	public ModItemKeycard(String name) {
		super(name);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlockState(pos).getBlock();
		TileEntity tile = world.getTileEntity(pos);
		
		if(block == MBlocks.TechLock){
			boolean isPowered = ((TileEntityKAL)tile).getIsActive();
			if(!isPowered){
				((TileEntityKAL)tile).setIsActive(true);
			}
			return true;
		}else{
			return false;
		}
	}
}
