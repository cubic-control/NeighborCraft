package com.cubic_control.hnm.CreativeTabs;

import net.minecraft.creativetab.CreativeTabs;

public class MCreativeTabs {
	public static CreativeTabs tabAll;
	
	public static void createTabs(){
		tabAll = new CreativeTabAll("tabAll");
	}
}
