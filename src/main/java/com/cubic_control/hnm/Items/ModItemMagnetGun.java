package com.cubic_control.hnm.Items;

import java.util.List;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ModItemMagnetGun extends ModItem{
	
	protected EntityItem item;
	protected EntityPlayer player;

	public ModItemMagnetGun(String name) {
		super(name);
		if(MConfig.useRealisticTextures){
			this.setTextureName(RefStrings.MODID + ":realistic/" + name);
		}
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer ep)
    {
		double radius = 10;
      	List<EntityItem> items = world.getEntitiesWithinAABB(EntityItem.class, ep.boundingBox.expand(radius, radius, radius));
      	for(EntityItem it : items){
      		double distX = ep.posX - it.posX;
      		double distZ = ep.posZ - it.posZ;
      		double distY = it.posY+1.5D - ep.posY;
      		double dir = Math.atan2(distZ, distX);
      		double speed = 1F / it.getDistanceToEntity(ep) * 0.5;

      		if (distY<0)
      		{
      			it.motionY += speed;
      		}

      		it.motionX = Math.cos(dir) * speed;
      		it.motionZ = Math.sin(dir) * speed;
      	}

      	return is;
	}

}
