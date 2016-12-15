package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemKeyRed extends ModItem{

	public ModItemKeyRed(String name) {
		super(name);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		if(block instanceof BlockDoor){
			int i1 = ((BlockDoor) block).func_150012_g(world, x, y, z);
            int j1 = i1 & 7;
            j1 ^= 4;
            
			if ((i1 & 8) == 0){
				world.setBlockMetadataWithNotify(x, y, z, j1, 2);
				world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
            }else
            {
                world.setBlockMetadataWithNotify(x, y - 1, z, j1, 2);
                world.markBlockRangeForRenderUpdate(x, y - 1, z, x, y, z);
            }
			world.playAuxSFXAtEntity(player, 1003, x, y, z, 0);
			return true;
		}else{
			return false;
		}
	}

}
