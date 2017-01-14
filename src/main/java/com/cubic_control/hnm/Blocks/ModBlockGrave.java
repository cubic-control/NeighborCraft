package com.cubic_control.hnm.Blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeDouble;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBarricadeSingle;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGrave;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityTechLock;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockGrave extends BlockContainer {
	
	protected ModBlockGrave(String name) {
		super(Material.rock);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(15f);
		this.setResistance(30f);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(Block.soundTypeStone);
		this.setBlockName(name);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setTickRandomly(true);
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityGrave();
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
	public boolean isNormalCube() {
		return false;
	}
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack) {
        int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 1, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        }

        if (l == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        }

        if (l == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        }

        if (l == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
            world.markBlockRangeForRenderUpdate(x, y, z, x, y, z);
        }
    }
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z){
		int meta = access.getBlockMetadata(x, y, z);

		if(meta == 3  || meta == 7){
			this.setBlockBounds(0.0F, 0.0F, 0.87F, 1.0F, 1.95F, 1.0F);
		}else if(meta == 4 || meta == 8){
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.12F, 1.95F, 1.0F);
		}else if(meta == 2 || meta == 6){
			this.setBlockBounds(0.87F, 0.0F, 0.0F, 1.0F, 1.95F, 1.0F);
		}else{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.95F, 0.12F);
		}
	}
}