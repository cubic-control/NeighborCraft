package com.cubic_control.hnm.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Used to keep track of items that produce a
 * zoom effect.
 * 
 * @author: cubic_control
 * 
 * */

public interface IZoom {
	@SideOnly(Side.CLIENT)
	public float getZoomFactor();
}
