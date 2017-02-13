package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRedPadlock;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityRustyPadlock;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class ModBlockPadlockRusty extends BlockContainer implements IBlock{

	protected ModBlockPadlockRusty(String name) {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setBlockName(name);
		this.setBlockTextureName(RefStrings.MODID + ":" + name);
		this.setBlockUnbreakable();
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setHardness(15.0f);
		this.setHarvestLevel("pickaxe", 2);
		this.setLightOpacity(0);
		this.setResistance(30.0f);
		this.setStepSound(soundTypeMetal);
		GameRegistry.registerBlock(this, name);
	}
	@Override
	public TileEntity createNewTileEntity(World world, int i1) {
		return new TileEntityRustyPadlock();
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
			this.setBlockBounds(0.6F, 0.0F, 0.0F, 0.96F, 0.56F, 0.15F);
		}else if(meta == 4 || meta == 8){
			this.setBlockBounds(0.85F, 0.0F, 0.6F, 1.0F, 0.56F, 0.96F);
		}else if(meta == 2 || meta == 6){
			this.setBlockBounds(0.0F, 0.0F, 0.04F, 0.15F, 0.56F, 0.4F);
		}else{
			this.setBlockBounds(0.04F, 0.0F, 0.85F, 0.4F, 0.56F, 1.0F);
		}
	}
	@Override
	public boolean blocksDoors() {
		return true;
	} 

}
