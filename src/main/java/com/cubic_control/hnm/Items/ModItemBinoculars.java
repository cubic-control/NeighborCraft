package com.cubic_control.hnm.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemBinoculars extends ModItem implements IZoom{

	public ModItemBinoculars(String name) {
		super(name);
	}
	
	public boolean isItemTool(ItemStack stack) {
		return super.isItemTool(stack);
	}

	@Override
	public float getZoomFactor() {
		return -5.0F;
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
