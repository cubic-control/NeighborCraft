package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModBlockTechLock;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityTechLock;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemKeycard extends ModItem{

	public ModItemKeycard(String name) {
		super(name);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
}
