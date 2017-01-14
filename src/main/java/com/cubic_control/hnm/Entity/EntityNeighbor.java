package com.cubic_control.hnm.Entity;

import java.util.Random;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.AI.ModEntityAIOpenDoor;
import com.cubic_control.hnm.Items.MItems;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityNeighbor extends EntityMob{
	protected EntityPlayer player;
	private EntityLiving entity;

	public EntityNeighbor(World par1World) {
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIMoveIndoors(this));
		this.tasks.addTask(4, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(5, new ModEntityAIOpenDoor(this, true));
		this.tasks.addTask(6, new EntityAIMoveTowardsRestriction(this, 0.3F));
		this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.tasks.addTask(7, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
		this.tasks.addTask(7, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void entityInit() {
        super.entityInit();
        this.getDataWatcher().addObject(15, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(16, Byte.valueOf((byte)0));
        this.getDataWatcher().addObject(17, Byte.valueOf((byte)0));
    }
	
	@Override
	protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if(MConfig.isPlayerFasterThanNeighbor){
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
        }else{
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.35D);
        }
        
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
        
        if(MConfig.hardcoreNeighbor){
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(2000.0D);
        	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(32.0D);
        }else{
        	this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        	
        	if(this.worldObj.difficultySetting == EnumDifficulty.EASY){
            	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
            }else if(this.worldObj.difficultySetting == EnumDifficulty.NORMAL){
            	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(12.0D);
            }else if(this.worldObj.difficultySetting == EnumDifficulty.HARD){
            	this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(16.0D);
            }
        }
    }
	
	@Override
	public boolean isAIEnabled() {
        return true;
    }
	
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        
        return data;
    }
	
	protected Item getDropItem() {
        return MItems.key_red;
    }
	
	/**
     * Get this Entity's EnumCreatureAttribute
     */
	@Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.UNDEFINED;
    }
	
	@Override
    public boolean getCanSpawnHere() {
		if(worldObj.villageCollectionObj.getVillageList().iterator().hasNext() && worldObj.villageCollectionObj.findNearestVillage((int)this.posX, (int)this.posY, (int)this.posZ, 10) == null) {
			return false;
		}
		return true;
    }
	
	@Override
    protected boolean canDespawn() {
     return true;
    }
	
	@Override
	protected String getHurtSound() {
		Random rand = new Random();
		if(rand.nextInt() < 5){
			return RefStrings.MODID + ":neighbor.hurt";
		}else{
			return RefStrings.MODID + ":neighbor.hurt.1";
		}
    }
	
	//@Override
	//protected String getLivingSound() {
		//return RefStrings.MODID + ":neighbor.gasp";
	//}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		
		if(this.getHealth() < this.getMaxHealth()){
			this.heal(0.01f);
		}
	}
	
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer){
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();
		
		if(par1EntityPlayer.isSneaking() && this.isEntityAlive() && itemstack == null && MConfig.canGetKeyFromNeighbor){
			par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, new ItemStack(MItems.key_red));
			return true;
		}else{
			return false;
		}
	}

}
