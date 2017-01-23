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
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.TileEntity.TileEntityPadlockBlue;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModBlockPadlockBlue extends BlockContainer{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	protected ModBlockPadlockBlue(String name) {
		super(Material.iron);
		this.setUnlocalizedName(name);
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
		return new TileEntityPadlockBlue();
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
	public boolean isNormalCube() {
		return false;
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
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos){
		EnumFacing dir = (EnumFacing)access.getBlockState(pos).getValue(FACING);

		if(dir == EnumFacing.SOUTH){
			this.setBlockBounds(0.65F, 0.0F, 0.0F, 0.95F, 0.5F, 0.15F);
		}else if(dir == EnumFacing.NORTH){
			this.setBlockBounds(0.85F, 0.0F, 0.65F, 1.0F, 0.5F, 0.95F);
		}else if(dir == EnumFacing.WEST){
			this.setBlockBounds(0.0F, 0.0F, 0.05F, 0.15F, 0.5F, 0.35F);
		}else{
			this.setBlockBounds(0.05F, 0.0F, 0.85F, 0.35F, 0.5F, 1.0F);
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
