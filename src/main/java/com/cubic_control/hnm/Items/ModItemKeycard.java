package com.cubic_control.hnm.Items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModBlockKAL;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItemKeycard extends ModItem{

	public ModItemKeycard(String name, float f1) {
		super(name, f1);
	}
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Block block = world.getBlock(x, y, z);
		TileEntity tile = world.getTileEntity(x, y, z);
		
		if(block == MBlocks.KAL_on){
			int i = world.getBlockMetadata(x, y, z);
			world.setBlock(x, y, z, Blocks.air);
			world.setTileEntity(x, y, z, null);
			if(MBlocks.KAL_off.canPlaceBlockAt(world, x, y, z)) {
                world.setBlock(x, y, z, MBlocks.KAL_off);
                world.setBlockMetadataWithNotify(x, y, z, i, i);
            }
			player.addChatMessage(new ChatComponentText(
				EnumChatFormatting.GOLD+"["+EnumChatFormatting.WHITE+RefStrings.NAME+
				EnumChatFormatting.GOLD+"]:"+EnumChatFormatting.GREEN+" KAL deactivated"));
			
			return true;
		}else{
			return false;
		}
		
	}
}
