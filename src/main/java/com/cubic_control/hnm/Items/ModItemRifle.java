package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ModItemRifle extends ModItem{

	public ModItemRifle(String name, float f1) {
		super(name, f1);
	}
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(MConfig.rifleRequiresBullets){
			boolean flag = par3EntityPlayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, par1ItemStack) > 0;
			if (flag || par3EntityPlayer.inventory.hasItem(MItems.bullet)){
				par2World.playSoundAtEntity(par3EntityPlayer, RefStrings.MODID + ":rifle.shoot", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        	if (!par2World.isRemote)
	        	{
	            	par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer));
	        	}
				par3EntityPlayer.inventory.consumeInventoryItem(MItems.bullet);
			}
		}else{
			par2World.playSoundAtEntity(par3EntityPlayer, RefStrings.MODID + ":rifle.shoot", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        	if (!par2World.isRemote)
        	{
            	par2World.spawnEntityInWorld(new EntityBullet(par2World, par3EntityPlayer));
        	}
		}
	  
		return par1ItemStack;
	}

}
