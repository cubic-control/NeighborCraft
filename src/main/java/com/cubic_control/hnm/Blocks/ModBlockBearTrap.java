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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityBearTrap;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockBearTrap extends BlockContainer {
	public boolean isActive;
	
	protected ModBlockBearTrap(String name) {
		super(Material.iron);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(15f);
		this.setResistance(30f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockName(name);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setTickRandomly(true);
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityBearTrap();
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
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z){
		int meta = access.getBlockMetadata(x, y, z);

		if(meta == 3  || meta == 7){
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		}else if(meta == 4 || meta == 8){
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		}else if(meta == 2 || meta == 6){
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		}else{
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.3F, 1.0F);
		}
	}
}
