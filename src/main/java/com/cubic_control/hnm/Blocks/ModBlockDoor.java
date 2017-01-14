package com.cubic_control.hnm.Blocks;

import java.util.Random;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class ModBlockDoor extends BlockDoor{

	protected ModBlockDoor(Material var1, float var2, float var3, String var4, int var5, SoundType var6, String var7) {
		super(var1);
		this.setCreativeTab(null);
		this.setHardness(var2);
		this.setResistance(var3);
		this.setHarvestLevel(var4, var5);
		this.setStepSound(var6);
		this.setBlockName(var7);
		this.setBlockTextureName(RefStrings.MODID + ":" + var7);
		this.setTickRandomly(true);
		GameRegistry.registerBlock(this, var7 + "_block");
	}
	
	//@Override
	//public boolean onBlockActivated(World var1, int i1, int i2, int i3, EntityPlayer player, int i4, float f1, float f2, float f3) {
        //super.onBlockActivated(var1, i1, i2, i3, player, i4, f1, f2, f3);
        //if(boolean){
        	//return true;
        //}else{
        	//return false;
        //}
    //}
	
	@Override
	public Item getItemDropped(int i1, Random rand, int i2) {
        return this == MBlocks.door_golden ? MItems.door_golden : (
        		this == MBlocks.door_white ? MItems.door_white : Item.getItemFromBlock(this));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return this == MBlocks.door_golden ? MItems.door_golden : (
        		this == MBlocks.door_white ? MItems.door_white : Item.getItemFromBlock(this));
    }

}
