package com.cubic_control.hnm.Items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IZoom {
	@SideOnly(Side.CLIENT)
	public float getZoomFactor();
}
