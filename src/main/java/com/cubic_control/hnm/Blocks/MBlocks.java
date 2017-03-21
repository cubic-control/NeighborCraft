package com.cubic_control.hnm.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

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
	public static Block KAL_on;
	public static Block KAL_off;
	
	public static Block wood_turquoise;
	//Alpha 3
	public static Block door_golden;
	public static Block padlock_blue;
	public static Block padlock_golden;
	//Custom
	public static Block barricade_double;
	public static Block barricade_single;
	public static Block invisible_light;
	public static Block door_white_iron;
	public static Block door_golden_iron;
	
	public static Block blue_fabric_dif;
	public static Block blue_wave_fabric_dif;
	public static Block blue_wood_dif;
	public static Block dirt_ground_dif;
	public static Block fabric_rhombus_dif;
	public static Block floor;
	public static Block floor_blue_dif;
	public static Block floor_green;
	public static Block Grass_ground_dif;
	public static Block green_wood_dif;
	public static Block light_wood_dif;
	public static Block purple_fabric_dif;
	public static Block red_fabric_dif;
	public static Block red_strip_fabric_dif;
	public static Block red_wood_dif;
	public static Block wallpaper_dark_blue;
	public static Block wallpaper_dark_dif;
	public static Block white_wood_dif;
	public static Block wood_2_dif;
	public static Block wood_dif;
	
	public static void createBlocks(){
		//Pre-Alpha
		bear_trap = new ModBlockBearTrap("beartrap");
		camera = new ModBlockCamera("camera");
		padlock_rusty = new ModBlockPadlockRusty("lock_rusty");
		//Alpha 1
		grave = new ModBlockGrave("grave");
		//Alpha 2
		door_white = new ModBlockDoor(Material.wood, 2f, 15f, "axe", 0, Block.soundTypeWood, "door_white");
		gallon_of_milk = new ModBlockGallonOfMilk("milk").setCreativeTab(null);
		padlock_red = new ModBlockPadlockRed("lock_red");
		KAL_on = new ModBlockKAL("TechLock", true);
		KAL_off = new ModBlockKAL("TechLock", false).setCreativeTab(null);
		
		wood_turquoise = new ModBlock(Material.wood, "wood_turquoise_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		//Alpha 3
		door_golden = new ModBlockDoor(Material.wood, 3f, 30f, "axe", 0, Block.soundTypeWood, "door_golden");
		padlock_blue = new ModBlockPadlockBlue("lock_blue");
		padlock_golden = new ModBlockPadlockGolden("lock_golden");
		//Custom
		barricade_double = new ModBlockBarricadeDouble("barricade_double");
		barricade_single = new ModBlockBarricadeSingle("barricade_single");
		invisible_light = new ModBlockInvisibleLight("invisible_light");
		door_white_iron = new ModBlockDoor(Material.iron, 2f, 15f, "axe", 0, Block.soundTypeWood, "door_white_iron", "door_white");
		door_golden_iron = new ModBlockDoor(Material.iron, 3f, 30f, "axe", 0, Block.soundTypeWood, "door_golden_iron", "door_golden");
		
		blue_fabric_dif = new ModBlock(Material.cloth, "blue_fabric_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		blue_wave_fabric_dif = new ModBlock(Material.cloth, "blue_wave_fabric_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		blue_wood_dif = new ModBlock(Material.wood, "blue_wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		dirt_ground_dif = new ModBlock(Material.ground, "dirt_ground_dif", 0f, "shovel", -1, 5f, Block.soundTypeGrass);
		fabric_rhombus_dif = new ModBlock(Material.cloth, "fabric_rhombus_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		floor = new ModBlock(Material.wood, "floor", 2f, "axe", 0, 15f, Block.soundTypeWood);
		floor_blue_dif = new ModBlock(Material.wood, "floor_blue_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		floor_green = new ModBlock(Material.wood, "floor_green", 2f, "axe", 0, 15f, Block.soundTypeWood);
		Grass_ground_dif = new ModBlock(Material.grass, "Grass_ground_dif", 1f, "shovel", -1, 15f, Block.soundTypeGrass);
		green_wood_dif = new ModBlock(Material.wood, "green_wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		light_wood_dif = new ModBlock(Material.wood, "light_wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		purple_fabric_dif = new ModBlock(Material.cloth, "purple_fabric_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		red_fabric_dif = new ModBlock(Material.cloth, "red_fabric_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		red_strip_fabric_dif = new ModBlock(Material.cloth, "red_strip_fabric_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		red_wood_dif = new ModBlock(Material.wood, "red_wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		wallpaper_dark_blue = new ModBlock(Material.cloth, "wallpaper_dark_blue", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		wallpaper_dark_dif = new ModBlock(Material.cloth, "wallpaper_dark_dif", 1f, "axe", -1, 10f, Block.soundTypeCloth);
		white_wood_dif = new ModBlock(Material.wood, "white_wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		wood_2_dif = new ModBlock(Material.wood, "wood_2_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
		wood_dif = new ModBlock(Material.wood, "wood_dif", 2f, "axe", 0, 15f, Block.soundTypeWood);
	}
}
