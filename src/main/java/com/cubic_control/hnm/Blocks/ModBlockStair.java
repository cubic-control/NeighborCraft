package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.item.ItemStack;

public class ModBlockStair extends BlockStairs{

	protected ModBlockStair(Block block, String name) {
		super(block, 0);
		this.setLightOpacity(0);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHarvestLevel(block.getHarvestTool(0), block.getHarvestLevel(0));
		this.setBlockName(name + "_stair");
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		GameRegistry.registerBlock(this, name + "_stair");
		GameRegistry.addShapedRecipe(new ItemStack(this, 4), "  X", " XX", "XXX", 'X', block);
		GameRegistry.addShapedRecipe(new ItemStack(this, 4), "X  ", "XX ", "XXX", 'X', block);
	}

}
