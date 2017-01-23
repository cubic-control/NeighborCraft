package com.cubic_control.hnm.Entity.TileEntity;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Blocks.ModBlockKAL;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityKAL extends TileEntity{
	public static TileEntityKAL getInstance;
	private boolean isActive = false;
	
	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean b1) {
		this.isActive = b1;
	}

	@Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setBoolean("isActive", (boolean)isActive);
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        
        if (compound.hasKey("isActive", 99)) {
            boolean b0 = compound.getBoolean("isActive");
            this.setIsActive(b0);
        }
	}

}
