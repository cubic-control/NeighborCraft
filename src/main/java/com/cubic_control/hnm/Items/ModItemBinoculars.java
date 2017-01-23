package com.cubic_control.hnm.Items;

import java.util.List;

import com.cubic_control.hnm.GUI.GuiBinoculars;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

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
