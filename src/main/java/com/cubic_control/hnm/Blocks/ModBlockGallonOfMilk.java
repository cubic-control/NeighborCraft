package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGallonOfMilk;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockBlue;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ModBlockGallonOfMilk extends BlockContainer{

	protected ModBlockGallonOfMilk(String name) {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setBlockName(name);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(10.0f);
		this.setLightOpacity(0);
		this.setResistance(5.0f);
		this.setStepSound(soundTypeMetal);
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i1) {
		return new TileEntityGallonOfMilk();
	}
	@Override
	public int getRenderType() {
		return -1;
	}
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
		return null;
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }

}
