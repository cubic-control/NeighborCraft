package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModBlockKAL;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemKeycard extends ModItem{

	public ModItemKeycard(String name, float f1) {
		super(name, f1);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	//@Override
	//public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		//Block block = world.getBlock(x, y, z);
		//TileEntity tile = world.getTileEntity(z, y, z);
		
		//if(block == MBlocks.TechLock){
			//boolean isActive = ((TileEntityKAL)tile).getIsActive();
			//boolean isPowered = ((ModBlockKAL)block).getInstance().isPowered;
			//if(!isPowered || !isActive){
				//((TileEntityKAL)tile).setIsActive(true);
				//((ModBlockKAL)block).setPowered(true);
			//}
			//return true;
		//}else{
			//return false;
		//}
	//}
}
