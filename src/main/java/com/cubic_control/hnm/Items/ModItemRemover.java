package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemRemover extends ModItem{

	public ModItemRemover(String name, float f1) {
		super(name, f1);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		if(block != null ){
			world.setBlock(x, y, z, Blocks.air);
			return true;
		}else if(tile != null){
			world.setTileEntity(x, y, z, null);
			return true;
		}else{
			return false;
		}
	}

}
