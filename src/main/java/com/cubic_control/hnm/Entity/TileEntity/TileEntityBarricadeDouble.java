package com.cubic_control.hnm.Entity.TileEntity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBarricadeDouble extends TileEntity{
	public static TileEntityBarricadeDouble getInstance;
	private int timesHit;
	
	public int getTimesHit(){
		return timesHit;
	}
	
	public void setTimesHit(int i1){
		timesHit = i1;
	}
	
	@Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setByte("timesHit", (byte)this.getTimesHit());
	}
	
	@Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        
        if (compound.hasKey("timesHit", 99)) {
            byte b0 = compound.getByte("timesHit");
            this.setTimesHit(b0);
        }
	}

}
