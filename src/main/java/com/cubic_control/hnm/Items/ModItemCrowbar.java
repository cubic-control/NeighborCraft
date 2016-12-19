package com.cubic_control.hnm.Items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModMaterial;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;
import com.google.common.collect.Sets;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItemCrowbar extends ModItem{

	public ModItemCrowbar(String name) {
		super(name);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		int hits = 0;
		ItemStack parStack = new ItemStack(MItems.nail, 1);
		EntityItem parEntity = new EntityItem(world, x, y, z, parStack);
		world.spawnEntityInWorld(parEntity);
		if(block == MBlocks.Barricade){
			if(hits == 3){
				world.setBlock(x, y, z, Blocks.air);
				block.dropBlockAsItem(world, x, y, z, 0, 0);
			}else if(hits == 2){
				hits = 3;
			}else if(hits == 1){
				hits = 2;
			}else if(hits == 0){
				hits = 1;
			}
			return true;
		}else{
			return false;
		}
	}

}
