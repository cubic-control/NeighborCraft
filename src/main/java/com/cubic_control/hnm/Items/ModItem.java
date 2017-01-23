package com.cubic_control.hnm.Items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;

public class ModItem extends Item {
	
	public ModItem(String name){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		GameRegistry.registerItem(this, name);
	}
}
