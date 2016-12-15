package com.cubic_control.hnm.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MBlocks {
	public static Block Barricade;
	public static Block TechLock;
	public static Block rusty_padlock;
	public static Block red_padlock;
	
	public static void createBlocks(){
		Barricade = new ModBlockBarricade("Barricade", "barricade_block");
		TechLock = new ModBlockTechLock("TechLock", "TechLock_Block");
	}
}
