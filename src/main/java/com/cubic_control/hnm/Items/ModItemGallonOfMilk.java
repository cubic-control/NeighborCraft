package com.cubic_control.hnm.Items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;

public class ModItemGallonOfMilk extends ModItem{

	public ModItemGallonOfMilk(String name, float f1) {
		super(name, f1);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float f1, float f2, float f3) {
		if (world.getBlock(x, y, z) != Blocks.snow_layer) {
            if(side == 0) {
                --y;
            }else if(side == 1) {
                ++y;
            }else if(side == 2) {
                --z;
            }else if(side == 3) {
                ++z;
            }else if(side == 4) {
                --x;
            }else if(side == 5) {
                ++x;
            }else if(!world.isAirBlock(x, y, z)) {
                return false;
            }
        }
        if(!player.canPlayerEdit(x, y, z, side, stack)) {
            return false;
        }else{
            if(MBlocks.gallon_of_milk.canPlaceBlockAt(world, x, y, z)) {
                --stack.stackSize;
                world.setBlock(x, y, z, MBlocks.gallon_of_milk);
            }
            return true;
        }
	}
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
        	player.curePotionEffects(stack);
        }
        return stack;
    }

}
