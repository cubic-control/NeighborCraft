package com.cubic_control.hnm.Blocks;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class ModMaterial extends Material{
	public static final Material barricade = (new ModMaterial(MapColor.woodColor)).setBurning().setRequiresTool();
	
	/** Boolean defining if the block can burn or not. */
    private boolean canBurn;
    /** Determines if the material can be harvested without a tool (or with the wrong tool) */
    private boolean requiresNoTool = true;

	public ModMaterial(MapColor par1MapColor) {
		super(par1MapColor);
	}
	
	/**
     * Set the canBurn bool to True and return the current object.
     */
	@Override
    public ModMaterial setBurning() {
        this.canBurn = true;
        return this;
    }
	/**
     * Returns if the block can burn or not.
     */
	@Override
	public boolean getCanBurn() {
        return this.canBurn;
    }
	/**
     * Makes blocks with this material require the correct tool to be harvested.
     */
	@Override
	public ModMaterial setRequiresTool() {
        this.requiresNoTool = false;
        return this;
    }
	/**
     * Returns true if the material can be harvested without a tool (or with the wrong tool)
     */
	@Override
    public boolean isToolNotRequired() {
        return this.requiresNoTool;
    }

}
