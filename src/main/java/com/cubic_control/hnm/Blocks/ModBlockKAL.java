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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityKAL;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlockKAL extends BlockContainer implements IBlock{
	public boolean isActive;
	
	protected ModBlockKAL(String name, boolean isOn) {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(15f);
		this.setResistance(30f);
		this.setHarvestLevel("pickaxe", 0);
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setTickRandomly(true);
		if(isOn){
			this.setBlockName(name + "_on");
			GameRegistry.registerBlock(this, name + "_on");
		}else{
			this.setBlockName(name + "_off");
			GameRegistry.registerBlock(this, name + "_off");
		}
		
		this.isActive = isOn;
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i1) {
		return new TileEntityKAL();
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
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.1F);
		}else if(meta == 4 || meta == 8){
			this.setBlockBounds(0.9F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		}else if(meta == 2 || meta == 6){
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.1F, 1.0F, 1.0F);
		}else{
			this.setBlockBounds(0.0F, 0.0F, 0.9F, 1.0F, 1.0F, 1.0F);
		}
	}
	@Override
	public boolean blocksDoors() {
		return isActive;
	}
	@Override
	public boolean blocksChest() {
		return false;
	}
	public Item getItemDropped(int i1, Random rand, int i2) {
        return Item.getItemFromBlock(MBlocks.KAL_on);
    }
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(MBlocks.KAL_on);
	}
}
