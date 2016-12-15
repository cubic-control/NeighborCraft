package com.cubic_control.hnm.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Items.MItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes {
	public static void createRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(MItems.crowbar), " XX", " X ", "XX ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.lockpick), "  X", " X ", "X  ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.magnet_gun), "X  ", "XY ", "X  ", 'X', Items.iron_ingot, 'Y', MItems.magnet);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.rifle), "XXX", "Y  ", 'X', Items.iron_ingot, 'Y', Blocks.log);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.wrench), "  X", " XX", "X  ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.magnet), "XXX", "  X", "XXX", 'X', MItems.iron_magnetized);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.iron_magnetized), "XXX", "XYX", "XXX", 'X', Items.redstone, 'Y', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.nail, 5), "X", "Y", 'X', Blocks.stone_slab, 'Y', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.Barricade), "XYX", "   ", "XYX", 'X', MItems.nail, 'Y', Blocks.planks);
	}
}
