package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;

public class ModItemSlab extends ItemSlab{
	public static BlockSlab ModBlockSlab;
	public static BlockSlab ModBlockSlabDouble;

	public ModItemSlab(Block block) {
		super(block, (BlockSlab)ModBlockSlab, (BlockSlab)ModBlockSlabDouble, false);
		this.setMaxDamage(0);
	    this.setHasSubtypes(true);
	}

}
