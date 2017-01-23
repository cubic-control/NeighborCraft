package com.cubic_control.hnm.Blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityGallonOfMilk;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModBlockGallonOfMilk extends BlockContainer{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	protected ModBlockGallonOfMilk(String name) {
		super(Material.iron);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		this.setUnlocalizedName(name);
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
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
        return null;
    }
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        int l = MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0) {
            world.setBlockState(pos, this.getStateFromMeta(1), 2);
            world.markBlockRangeForRenderUpdate(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
        }

        if (l == 1) {
        	world.setBlockState(pos, this.getStateFromMeta(2), 2);
            world.markBlockRangeForRenderUpdate(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
        }

        if (l == 2) {
        	world.setBlockState(pos, this.getStateFromMeta(3), 2);
            world.markBlockRangeForRenderUpdate(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
        }

        if (l == 3) {
        	world.setBlockState(pos, this.getStateFromMeta(4), 2);
            world.markBlockRangeForRenderUpdate(pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
        }
    }
	@Override
	@SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if(meta == 3 || meta == 7){
			return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
		}else if(meta == 4 || meta == 8){
			return this.getDefaultState().withProperty(FACING, EnumFacing.NORTH);
		}else if(meta == 2 || meta == 6){
			return this.getDefaultState().withProperty(FACING, EnumFacing.WEST);
		}else{
			return this.getDefaultState().withProperty(FACING, EnumFacing.EAST);
		}
    }
	@Override
    public int getMetaFromState(IBlockState state) {
		if(state == this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH)){
			return 3;
		}else if(state == this.getDefaultState().withProperty(FACING, EnumFacing.NORTH)){
			return 4;
		}else if(state == this.getDefaultState().withProperty(FACING, EnumFacing.WEST)){
			return 2;
		}else{
			return 1;
		}
    }
	@Override
    protected BlockState createBlockState() {
        return new BlockState(this, new IProperty[] {FACING});
    }

}
