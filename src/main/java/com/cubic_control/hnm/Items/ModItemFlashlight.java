package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ModItemFlashlight extends ModItem implements IForwardLight{

	public ModItemFlashlight(String name, float f1) {
		super(name, f1);
	}
	@Override
	public boolean isItemTool(ItemStack stack) {
		return super.isItemTool(stack);
	}
	@Override
	public int getMaxItemUseDuration(ItemStack stack) {
		return 72000;
	}
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return stack;
	}

}
