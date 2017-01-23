package com.cubic_control.hnm.Blocks;

import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class MBlocks {
	//Pre-Alpha
	public static Block bear_trap;
	public static Block camera;
	public static Block padlock_rusty;
	//Alpha 1
	public static Block grave;
	//Alpha 2
	public static Block door_white;
	public static Block gallon_of_milk;
	public static Block padlock_red;
	public static Block TechLock;
	//Alpha 3
	public static Block door_golden;
	public static Block padlock_blue;
	public static Block padlock_golden;
	//Custom
	public static Block barricade_double;
	public static Block barricade_single;
	
	public static void createBlocks(){
		//Pre-Alpha
		bear_trap = new ModBlockBearTrap("beartrap");
		camera = new ModBlockCamera("camera");
		padlock_rusty = new ModBlockPadlockRusty("lock_rusty");
		//Alpha 1
		grave = new ModBlockGrave("grave");
		//Alpha 2
		door_white = new ModBlockDoor(Material.wood, 2f, 15f, "axe", 0, Block.soundTypeWood, "door_white");
		gallon_of_milk = new ModBlockGallonOfMilk("milk");
		padlock_red = new ModBlockPadlockRed("lock_red");
		TechLock = new ModBlockKAL("TechLock");
		//Alpha 3
		door_golden = new ModBlockDoor(Material.wood, 3f, 30f, "axe", 0, Block.soundTypeWood, "door_golden");
		padlock_blue = new ModBlockPadlockBlue("lock_blue");
		padlock_golden = new ModBlockPadlockGolden("lock_golden");
		//Custom
		barricade_double = new ModBlockBarricadeDouble("barricade_double");
		barricade_single = new ModBlockBarricadeSingle("barricade_single");
	}
	
	public static void registerBlockRenderer() {
		//Pre-Alpha
		reg(bear_trap);
		reg(camera);
		reg(padlock_rusty);
		//Alpha 1
		reg(grave);
		//Alpha 2
		reg(door_white);
		reg(gallon_of_milk);
		reg(padlock_red);
		reg(TechLock);
		//Alpha 3
		reg(door_golden);
		reg(padlock_blue);
		reg(padlock_golden);
		//Custom
		reg(MBlocks.barricade_double);
		reg(MBlocks.barricade_single);
    }
	
	public static void reg(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(RefStrings.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}
