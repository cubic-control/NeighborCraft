package com.cubic_control.hnm.Items;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.cubic_control.cubic_core.Utils.ModUtils;
import com.cubic_control.hnm.Lib.RefStrings;

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
		world.playSoundAtEntity(player, RefStrings.MODID + ":flashlight.on", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		player.setItemInUse(stack, getMaxItemUseDuration(stack));
		return stack;
	}
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i1) {
		world.playSoundAtEntity(player, RefStrings.MODID + ":flashlight.off", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		MovingObjectPosition mop = Minecraft.getMinecraft().renderViewEntity.rayTrace(200, 1.0F);
		ModUtils.updateLightByMOP(world, mop);
	}

}
