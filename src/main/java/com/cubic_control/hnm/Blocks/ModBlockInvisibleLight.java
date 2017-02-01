package com.cubic_control.hnm.Blocks;

import org.lwjgl.opengl.GL11;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class ModBlockInvisibleLight extends BlockBreakable{
	@SideOnly(Side.CLIENT)
    private IIcon icon;

	protected ModBlockInvisibleLight(String name) {
		super(RefStrings.MODID + ":" + name, Material.glass, false);
		this.setBlockName(name);
		this.setCreativeTab(null);
		this.setHardness(0f);
		this.setLightLevel(1.0f);
		this.setLightOpacity(0);
		this.setResistance(0f);
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i1, int i2, int i3) {
		return null;
	}
	@Override
	@SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 0;
    }
	@Override
	public boolean renderAsNormalBlock() {
        return false;
    }
	@Override
	protected boolean canSilkHarvest() {
        return true;
    }

}
