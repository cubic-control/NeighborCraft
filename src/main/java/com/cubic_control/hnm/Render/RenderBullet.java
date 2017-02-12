package com.cubic_control.hnm.Render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.cubic_control.hnm.Entity.EntityBullet;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends Render{
	
	protected ModelBase mainModel;
	
	protected static ResourceLocation entityTexture;

	public RenderBullet(ModelBase par1, float par2) {
		super();
		mainModel = par1;
		shadowSize = 0.5F;
		entityTexture = new ResourceLocation(RefStrings.MODID + ":textures/entity/bullet.png");
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return entityTexture;
	}

	public void render(EntityBullet bullet, double d, double d1, double d2, float f, float f1)
	{
		bindEntityTexture(bullet);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) d, (float) d1, (float) d2);
		GL11.glRotatef(f, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(90F -bullet.prevRotationPitch - (bullet.rotationPitch - bullet.prevRotationPitch) * f1, 1.0F, 0.0F, 0.0F);
		if(mainModel != null){
			mainModel.render(bullet, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		}
		GL11.glPopMatrix();
	}

	@Override
	public void doRender(Entity entity, double d, double d1, double d2, float f, float f1)
	{
		render((EntityBullet) entity, d, d1, d2, f, f1);
	}

}
