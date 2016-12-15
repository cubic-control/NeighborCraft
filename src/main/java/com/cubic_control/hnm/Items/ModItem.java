package com.cubic_control.hnm.Items;

import net.minecraft.item.Item;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItem extends Item {
	public ModItem(String name, String TextureName){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setTextureName(RefStrings.MODID + ":" + TextureName);
		GameRegistry.registerItem(this, name);
	}
	
	public ModItem(String name){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setTextureName(RefStrings.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
	}
}
