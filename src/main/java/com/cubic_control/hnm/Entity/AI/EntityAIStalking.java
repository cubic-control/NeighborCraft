package com.cubic_control.hnm.Entity.AI;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class EntityAIStalking extends EntityAIBase{
	private EntityLiving theEntity;
	
	public EntityAIStalking(EntityLiving par1) {
        this.theEntity = par1;
        this.setMutexBits(4);
    }
	
    private boolean isSeenByTarget(EntityLiving stalker) {
        EntityLivingBase seer = stalker.getAttackTarget();
        
        if(stalker == null || seer == null) {
        	return true;
        }
        Vec3 visionVec = seer.getLook(1.0F).normalize();
        Vec3 targetVec = Vec3.createVectorHelper(stalker.posX - seer.posX, stalker.boundingBox.minY + (double)(stalker.height / 2.0F) - (seer.posY + (double)seer.getEyeHeight()), stalker.posZ - seer.posZ);
        targetVec = targetVec.normalize();
        double dotProduct = visionVec.dotProduct(targetVec);
        
        boolean inFOV = dotProduct > 0.1 && seer.canEntityBeSeen(stalker);
        
        return inFOV;
    }

	@Override
	public boolean shouldExecute() {
		return isSeenByTarget(theEntity);
	}
}
