package com.cubic_control.hnm.Entity;

import java.util.Random;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.Configuration.MConfig;
import com.cubic_control.hnm.Entity.AI.EntityAIStalking;
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
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityThePlayer extends EntityFakeMob{

	public EntityThePlayer(World par1World) {
		super(par1World);
		this.getNavigator().setBreakDoors(true);
		this.getNavigator().setEnterDoors(true);
		this.tasks.addTask(0, new EntityAIStalking(this));
		this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityNeighbor.class, 5.0F, 1.0D, 1.5D));
		this.tasks.addTask(2, new EntityAISwimming(this));
		this.tasks.addTask(3, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(4, new EntityAIMoveIndoors(this));
		this.tasks.addTask(5, new EntityAIRestrictOpenDoor(this));
		this.tasks.addTask(6, new ModEntityAIOpenDoor(this, true));
		this.tasks.addTask(7, new EntityAIMoveTowardsRestriction(this, 0.3F));
		this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
		this.tasks.addTask(8, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(8, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityLiving.class, 0, true, false, IMob.mobSelector));
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
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
        }else{
        	this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.20D);
        }
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(35.0D);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
    }
	@Override
	public boolean isAIEnabled() {
        return true;
    }
	@Override
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData data) {
        data = super.onSpawnWithEgg(data);
        
        addRandomArmor();
        
        return data;
    }
	@Override
	protected Item getDropItem() {
        return MItems.crowbar;
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
	public void onUpdate() {
		super.onUpdate();
		
		if(this.getHealth() < this.getMaxHealth()){
			this.heal(0.01f);
		}else{
			return;
		}
	}
	
	protected void addRandomArmor() {
		switch(this.rand.nextInt(15)){
			case 0:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.binoculars));
				break;
			case 1:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.crowbar));
				break;
			case 2:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.flashlight));
				break;
			case 3:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.hammer));
				break;
			case 4:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.key_blue));
				break;
			case 5:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.key_golden));
				break;
			case 6:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.key_red));
				break;
			case 7:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.key_rusty));
				break;
			case 8:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.key_sun));
				break;
			case 9:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.keycard));
				break;
			case 10:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.lockpick));
				break;
			case 11:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.magnet_gun));
				break;
			case 12:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.rifle));
				break;
			case 13:
				this.setCurrentItemOrArmor(0, new ItemStack(MItems.wrench));
				break;
			case 14:
				break;
		}
	}

}
