package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Items.ModItemSlab;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModBlockSlab extends BlockSlab{

	public ModBlockSlab(boolean isFull, ModBlock block, String name) {
		super(isFull, block.getMaterial());
		this.setHardness(block.getBlockHardness());
		this.setResistance(block.getBlockResistance() / 3.0F);
		this.setHarvestLevel(block.getHarvestTool(0), block.getHarvestLevel(0));
		this.setStepSound(block.stepSound);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		if(isFull == false){
			ModItemSlab.ModBlockSlab = this;
			this.setLightOpacity(0);
			this.setCreativeTab(MCreativeTabs.tabAll);
			this.setBlockName(name + "_slab");
			GameRegistry.registerBlock(this, ModItemSlab.class, name + "_slab");
			GameRegistry.addRecipe(new ItemStack(this, 6), "XXX", 'X', block);
		}
		if(isFull == true){
			ModItemSlab.ModBlockSlabDouble = this;
			this.setBlockName(name + "_slab_double");
			GameRegistry.registerBlock(this, ModItemSlab.class, name + "_slab_double");
		}
	}

	@Override
	public String func_150002_b(int var1) {
		return this.getUnlocalizedName();
	}
	@Override
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_) {
        return Item.getItemFromBlock(this);
    }

}
