package com.cubic_control.hnm.CreativeTabs;

import com.cubic_control.hnm.Items.MItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class CreativeTabAll extends CreativeTabs {

	public CreativeTabAll(String lable) {
		super(lable);
	}

	@Override
	public Item getTabIconItem() {
		return MItems.red_key;
	}

}
