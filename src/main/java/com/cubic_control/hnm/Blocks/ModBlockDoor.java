package com.cubic_control.hnm.Blocks;

import java.util.Random;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModBlockDoor extends BlockDoor{

	protected ModBlockDoor(Material var1, float var2, float var3, String var4, int var5, SoundType var6, String var7) {
		super(var1);
		this.setCreativeTab(null);
		this.setHardness(var2);
		this.setResistance(var3);
		this.setHarvestLevel(var4, var5);
		this.setStepSound(var6);
		this.setUnlocalizedName(var7 + "_block");
		this.setTickRandomly(true);
		ModelLoader.setCustomStateMapper(this, (new StateMap.Builder()).addPropertiesToIgnore(POWERED).build());
		GameRegistry.registerBlock(this, var7 + "_block");
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return state.getValue(HALF) == BlockDoor.EnumDoorHalf.UPPER ? null : this.getItem();
    }
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos) {
        return this.getItem();
    }
	
	private Item getItem() {
        return this == MBlocks.door_golden ? MItems.door_golden : (this == MBlocks.door_white ? MItems.door_white : Item.getItemFromBlock(this));
    }

}
