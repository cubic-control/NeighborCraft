// Date: 1/1/2017 10:06:55 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package com.cubic_control.hnm.Entity.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelBearTrap extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public ModelBearTrap()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Shape1 = new ModelRenderer(this, 0, 15);
      Shape1.addBox(0F, 0F, 0F, 7, 1, 3);
      Shape1.setRotationPoint(-3.5F, 23F, -1.5F);
      Shape1.setTextureSize(64, 32);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 0);
      Shape2.addBox(0F, 0F, 0F, 2, 1, 14);
      Shape2.setRotationPoint(-1F, 23.5F, -7F);
      Shape2.setTextureSize(64, 32);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 32, 0);
      Shape3.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape3.setRotationPoint(-0.5F, 23.2F, 1F);
      Shape3.setTextureSize(64, 32);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape4 = new ModelRenderer(this, 32, 3);
      Shape4.addBox(0F, 0F, 0F, 1, 1, 2);
      Shape4.setRotationPoint(-0.5F, 23.2F, -3F);
      Shape4.setTextureSize(64, 32);
      Shape4.mirror = true;
      setRotation(Shape4, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 38, 0);
      Shape5.addBox(0F, 0F, 0F, 4, 3, 1);
      Shape5.setRotationPoint(-2F, 21F, -8F);
      Shape5.setTextureSize(64, 32);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 38, 4);
      Shape6.addBox(0F, 0F, 0F, 4, 3, 1);
      Shape6.setRotationPoint(-2F, 21F, 7F);
      Shape6.setTextureSize(64, 32);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 48, 0);
      Shape7.addBox(0F, 0F, 0F, 4, 7, 1);
      Shape7.setRotationPoint(-2F, 16F, -3F);
      Shape7.setTextureSize(64, 32);
      Shape7.mirror = true;
      setRotation(Shape7, -0.7853982F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 48, 8);
      Shape8.addBox(0F, 0F, 0F, 4, 7, 1);
      Shape8.setRotationPoint(2F, 16F, 3F);
      Shape8.setTextureSize(64, 32);
      Shape8.mirror = true;
      setRotation(Shape8, -0.7853982F, 3.141593F, 0F);
      Shape9 = new ModelRenderer(this, 0, 25);
      Shape9.addBox(0F, 0F, 0F, 4, 1, 6);
      Shape9.setRotationPoint(-2F, 16F, -3F);
      Shape9.setTextureSize(64, 32);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape4.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
