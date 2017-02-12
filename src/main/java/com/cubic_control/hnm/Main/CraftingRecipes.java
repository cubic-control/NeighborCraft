package com.cubic_control.hnm.Main;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Items.MItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingRecipes {
	public static void createRecipes(){
		GameRegistry.addShapedRecipe(new ItemStack(MItems.crowbar), " XX", "YXY", "XX ", 'X', Items.iron_ingot, 'Y', new ItemStack(Items.dye, 1, 1));
		GameRegistry.addShapedRecipe(new ItemStack(MItems.lockpick), "  X", " X ", "X  ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.magnet_gun), "X  ", "XY ", "X  ", 'X', Items.iron_ingot, 'Y', MItems.magnet);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.rifle), "XXX", "Y  ", 'X', Items.iron_ingot, 'Y', Blocks.log);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.wrench), "  X", " XX", "X  ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.magnet), "XXX", "  X", "XXX", 'X', MItems.iron_magnetized);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.iron_magnetized), "XXX", "XYX", "XXX", 'X', Items.redstone, 'Y', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(MItems.nail, 5), "X", "Y", 'X', Blocks.stone_slab, 'Y', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(MBlocks.barricade_single), "XYX", "X X", 'X', MItems.nail, 'Y', Blocks.planks);
		GameRegistry.addShapelessRecipe(new ItemStack(MBlocks.barricade_double), MBlocks.barricade_single, MBlocks.barricade_single);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.bullet), Items.string, Items.wheat, new ItemStack(Items.dye, 11, 11));
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.gallon_of_milk), "XXX", "XXX", "XXX", 'X', Items.milk_bucket);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.base_key), " X ", " X ", " Y ", 'X', Items.stick, 'Y', Blocks.planks);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.key_blue), " X ", "XYX", " X ", 'X', new ItemStack(Items.dye, 4, 4), 'Y', MItems.base_key);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.key_golden), " X ", "XYX", " X ", 'X', Items.gold_nugget, 'Y', MItems.base_key);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.key_red), " X ", "XYX", " X ", 'X', Items.redstone, 'Y', MItems.base_key);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.key_rusty), " X ", "XYX", " X ", 'X', Items.iron_ingot, 'Y', MItems.base_key);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.base_lock), "XXX", "X X", "XYX", 'X', Items.stick, 'Y', Blocks.planks);
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.padlock_blue), " X ", "XYX", " X ", 'X', new ItemStack(Items.dye, 4, 4), 'Y', MItems.base_lock);
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.padlock_golden), " X ", "XYX", " X ", 'X', Items.gold_nugget, 'Y', MItems.base_lock);
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.padlock_red), " X ", "XYX", " X ", 'X', Items.redstone, 'Y', MItems.base_lock);
		GameRegistry.addShapedRecipe(new ItemStack(MBlocks.padlock_rusty), " X ", "XYX", " X ", 'X', Items.iron_ingot, 'Y', MItems.base_lock);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.door_golden), " X ", "XYX", " X ", 'X', Items.gold_nugget, 'Y', Items.wooden_door);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.door_white), " X ", "XYX", " X ", 'X', new ItemStack(Items.dye, 15, 15), 'Y', Items.wooden_door);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.hammer_head), "X  ", "XXX", "X  ", 'X', Items.iron_ingot);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.hammer_handle), "XYX", "XYX", "XYX", 'X', new ItemStack(Items.dye, 11, 11), 'Y', Items.stick);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.hammer), MItems.hammer_head, MItems.hammer_handle);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.flashlight_lense), "BBB", "GRg", "BBB", 'B', new ItemStack(Blocks.wool, 15, 15), 'G', Items.glowstone_dust, 'R', Items.redstone, 'g', Blocks.glass_pane);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.flashlight_handle), "OOO", "BRR", "OOO", 'B', new ItemStack(Blocks.wool, 15, 15), 'R', Items.redstone, 'O', new ItemStack(Blocks.wool, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.flashlight), MItems.flashlight_lense, MItems.flashlight_handle);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.monoculars), " B ", "ORO", "BGB", 'B', new ItemStack(Blocks.wool, 15, 15), 'O', new ItemStack(Blocks.wool, 1, 1), 'R', Items.redstone, 'G', Blocks.glass_pane);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.binoculars), MItems.monoculars, MItems.monoculars);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.magnet_gun_v2), MItems.magnet_gun);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.magnet_gun), MItems.magnet_gun_v2);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.crowbar_v2), MItems.crowbar);
		GameRegistry.addShapelessRecipe(new ItemStack(MItems.crowbar), MItems.crowbar_v2);
		GameRegistry.addShapedRecipe(new ItemStack(MItems.key_sun), " Z ", "XYX", " Z ", 'X', Items.iron_ingot, 'Y', MItems.base_key, 'Z', Items.gold_nugget);
	}
}
