package com.cubic_control.hnm.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import com.cubic_control.hnm.Items.ModItemSlab;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlockFence extends BlockFence {

	public ModBlockFence(String name, ModBlock block) {
		super(name, block.getMaterial());
		this.setHardness(block.getBlockHardness());
		this.setResistance(block.getBlockResistance() / 3.0F);
		this.setHarvestLevel(block.getHarvestTool(0), block.getHarvestLevel(0));
		this.setStepSound(block.stepSound);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setLightOpacity(0);
		this.setCreativeTab(block.getCreativeTabToDisplayOn());
		this.setBlockName(name + "_fence");
		GameRegistry.registerBlock(this, ModItemSlab.class, name + "_fence");
	}
	
	@Override
	public boolean canConnectFenceTo(IBlockAccess world, int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		return super.canConnectFenceTo(world, x, y, z) || block instanceof BlockFence || block instanceof BlockFenceGate;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister p_149651_1_) {
		this.blockIcon = p_149651_1_.registerIcon(this.getTextureName());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_){
        return this.blockIcon;
    }

}
