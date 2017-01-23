package com.cubic_control.hnm.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public interface IZoom {
	@SideOnly(Side.CLIENT)
	public float getZoomFactor();
}
