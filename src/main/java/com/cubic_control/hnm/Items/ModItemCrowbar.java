package com.cubic_control.hnm.Items;

import java.util.Random;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModMaterial;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeDouble;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeSingle;
import com.cubic_control.hnm.Lib.RefStrings;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemCrowbar extends ModItem{

	public ModItemCrowbar(String name, float f1) {
		super(name, f1);
	}
	public ModItemCrowbar(String name, String tex, float f1) {
		super(name, tex, f1);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		ItemStack parStack = new ItemStack(MItems.nail);
		EntityItem parEntity = new EntityItem(world, x, y, z, parStack);
		Random rand = new Random();
		if(block == MBlocks.barricade_double){
			if(rand.nextInt() > 5){
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}else{
				world.playSoundAtEntity(player, RefStrings.MODID + ":nail.eject.1", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			}
			if(!world.isRemote){
				world.spawnEntityInWorld(parEntity);
			}
			int hits = ((TileEntityBarricadeDouble) tile).getTimesHit();
			if(hits >= 7){
				world.setBlock(x, y, z, Blocks.air);
				world.setTileEntity(x, y, z, null);
				block.dropBlockAsItem(world, x, y, z, 0, 0);
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
			if(!world.isRemote){
				world.spawnEntityInWorld(parEntity);
			}
			int hits = ((TileEntityBarricadeSingle) tile).getTimesHit();
			if(hits >= 3){
				world.setBlock(x, y, z, Blocks.air);
				world.setTileEntity(x, y, z, null);
				block.dropBlockAsItem(world, x, y, z, 0, 0);
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
