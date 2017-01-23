package com.cubic_control.hnm.Items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeDouble;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeSingle;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemCrowbar extends ModItem{

	public ModItemCrowbar(String name) {
		super(name);
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlockState(pos).getBlock();
		TileEntity tile = world.getTileEntity(pos);
		ItemStack parStack = new ItemStack(MItems.nail, 1);
		EntityItem parEntity = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), parStack);
		Random rand = new Random();
		if(block == MBlocks.barricade_double){
			if(rand.nextInt() > 5){
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}else{
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject.1", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}
			world.spawnEntityInWorld(parEntity);
			int hits = ((TileEntityBarricadeDouble) tile).getTimesHit();
			if(hits >= 7){
				world.setBlockState(pos, (IBlockState) Blocks.air.getDefaultState());
				world.setTileEntity(pos, null);
				block.dropBlockAsItem(world, pos, null, 0);
				hits = 0;
			}else{
				((TileEntityBarricadeDouble) tile).setTimesHit(hits+1);
			}
			return true;
		}else if(block == MBlocks.barricade_single){
			if(rand.nextInt() > 5){
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}else{
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject.1", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}
			world.spawnEntityInWorld(parEntity);
			int hits = ((TileEntityBarricadeSingle) tile).getTimesHit();
			if(hits >= 3){
				world.setBlockState(pos, (IBlockState) Blocks.air.getDefaultState());
				world.setTileEntity(pos, null);
				block.dropBlockAsItem(world, pos, null, 0);
				hits = 0;
			}else{
				((TileEntityBarricadeSingle) tile).setTimesHit(hits+1);
			}
			return true;
		}else{
			return false;
		}
	}

}
