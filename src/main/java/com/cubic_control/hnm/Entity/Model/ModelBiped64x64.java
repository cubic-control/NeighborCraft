package com.cubic_control.hnm.Entity.Model;

import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelBiped64x64 extends ModelBiped
{
    private static final String __OBFID = "CL_00000869";

    public ModelBiped64x64()
    {
        this(0.0F, false);
    }

    protected ModelBiped64x64(float par1, float par2, int par3, int par4)
    {
        super(par1, par2, par3, par4);
    }

    public ModelBiped64x64(float par1, boolean par2)
    {
        super(par1, 0.0F, 64, par2 ? 32 : 64);
    }
}