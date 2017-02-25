package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModBlock extends Block{

	protected ModBlock(Material material, String name, float hardness, String toolClass, int level, float resistance, SoundType soundType) {
		super(material);
		this.setBlockName(name);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(hardness);
		this.setHarvestLevel(toolClass, level);
		this.setResistance(resistance);
		this.setStepSound(soundType);
		GameRegistry.registerBlock(this, name);
		
		ModBlockStair stair = new ModBlockStair(this, name);
		ModBlockSlab slab_double = new ModBlockSlab(true, this, name);
		ModBlockSlab slab_single = new ModBlockSlab(false, this, name);
		ModBlockFence fence = new ModBlockFence(name, this);
	}
	
	public float getBlockHardness(){
		return this.blockHardness;
	}
	
	public float getBlockResistance(){
		return this.blockResistance;
	}

}
