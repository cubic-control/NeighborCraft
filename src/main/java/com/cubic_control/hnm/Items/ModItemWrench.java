package com.cubic_control.hnm.Items;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;
import com.google.common.collect.Multimap;

public class ModItemWrench extends ModItem{
	
	public ModItemWrench(String name, float f1) {
		super(name, f1);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
		
	}
}
