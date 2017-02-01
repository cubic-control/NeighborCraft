package com.cubic_control.hnm.Items;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.Item;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Lib.RefStrings;
import com.google.common.collect.Multimap;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItem extends Item {
	private float attackDamage;
	
	public ModItem(String name, String TextureName, float f1){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setTextureName(RefStrings.MODID + ":" + TextureName);
		GameRegistry.registerItem(this, name);
		
		attackDamage = f1;
	}
	
	public ModItem(String name, float f1){
		this.setUnlocalizedName(name);
		this.setCreativeTab(MCreativeTabs.tabAll);
		this.setTextureName(RefStrings.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		
		attackDamage = f1;
	}
	
	@Override
	public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(field_111210_e, "Weapon modifier", (double)this.attackDamage, 0));
        return multimap;
    }
}
