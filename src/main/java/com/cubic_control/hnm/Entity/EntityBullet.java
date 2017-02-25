package com.cubic_control.hnm.Entity;

import com.cubic_control.hnm.Configuration.MConfig;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable{
	private int ticksAlive;
	
	private Entity entity;

	public EntityBullet(World par1World) {
		super(par1World);
	}
	public EntityBullet(World par1World, EntityLivingBase par2EntityLivingBase){
		super(par1World, par2EntityLivingBase);
	}
	public EntityBullet(World par1World, double par2, double par4, double par6){
		super(par1World, par2, par4, par6);
	}
	@Override
	protected void onImpact(MovingObjectPosition pos) {
		entity = pos.entityHit;
		Block block = this.worldObj.getBlock(pos.blockX, pos.blockY, pos.blockZ);
	   
		if(pos.entityHit != null) {
			if(MConfig.doesRifleDoDamage) {
				pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 2.5f);
			}
			if(entity instanceof EntityLivingBase){
				((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 5, 1));
			}
		}
		
		if(block != null){
			if(block == Blocks.glass || block == Blocks.stained_glass || block == Blocks.glass_pane || block == Blocks.stained_glass_pane){
				this.worldObj.setBlock(pos.blockX, pos.blockY, pos.blockZ, Blocks.air);
			}
		}

		for(int i = 0; i < 8; ++i) {
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
		}

		if(!this.worldObj.isRemote) {
			this.setDead();
		}
      
	}
	@Override
	protected float getGravityVelocity()  {
		return 0.01f;
	}
	@Override
	public void onUpdate() {
		super.onUpdate();
	   
		++this.ticksAlive;
	   
		if(ticksAlive >= 50){
			this.setDead();
		}
	}

}