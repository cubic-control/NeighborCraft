package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class MItems {
	//Pre-Alpha
	public static Item binoculars;
	public static Item flashlight;
	public static Item hammer;
	public static Item key_rusty;
	//Alpha 1
	public static Item crowbar;
	public static Item rifle;
	//Alpha 2
	public static Item bullet;
	public static Item door_white;
	public static Item keycard;
	public static Item lockpick;
	public static Item magnet_gun;
	public static Item key_red;
	public static Item wrench;
	public static Item key_sun;
	//Alpha 3
	public static Item door_golden;
	public static Item key_blue;
	public static Item key_golden;
	//All
	public static Item spawn_egg;
	//Custom
	public static Item iron_magnetized;
	public static Item magnet;
	public static Item nail;
	public static Item base_key;
	public static Item base_lock;
	public static Item hammer_head;
	public static Item hammer_handle;
	public static Item remover;
	public static Item flashlight_lense;
	public static Item flashlight_handle;
	public static Item monoculars;
	
	public static void createItems(){
		//Pre-Alpha
		binoculars = new ModItemBinoculars("binoculars", 0.7f);
		flashlight = new ModItemFlashlight("flashlight", 1.7f);
		hammer = new ModItemHammer("hammer", 4.5f);
		key_rusty = new ModItemKeyRusty("key_rusty", 1.2f);
		//Alpha 1
		crowbar = new ModItemCrowbar("crowbar", 5.0f);
		rifle = new ModItemRifle("rifle", 1.6f);
		//Alpha 2
		bullet = new ModItem("bullet", 0.5f);
		door_white = new ModItemDoor("door_white", 1.0f);
		key_red = new ModItemKeyRed("key_red", 1.5f);
		keycard = new ModItemKeycard("keycard", 0.3f);
		lockpick = new ModItemLockpick("lockpick", 1.3f).setFull3D();
		magnet_gun = new ModItemMagnetGun("magnet_gun", 1.8f);
		wrench = new ModItemWrench("wrench", 3.0f).setFull3D();
		key_sun = new ModItem("key_sun", 1.3f);
		//Alpha 3
		door_golden = new ModItemDoor("door_golden", 1.6f);
		key_blue = new ModItemKeyBlue("key_blue", 1.1f);
		key_golden = new ModItemKeyGolden("key_golden", 2.8f);
		//All
		spawn_egg = new ModItemMonsterPlacer("Neighbor", 0xFBFF87, 0x879DFF, "Neighbor");
		spawn_egg = new ModItemMonsterPlacer("Shadow", 0x000000, 0x595959, "Shadow");
		//Custom
		iron_magnetized = new ModItem("iron_magnetized", 0.4f);
		magnet = new ModItem("magnet", 0.6f);
		nail = new ModItem("nail", 0.2f);
		base_key = new ModItem("key_base", 0.6f);
		base_lock = new ModItem("base_lock", 0.2f);
		hammer_head = new ModItem("hammer_head", 0.7f);
		hammer_handle = new ModItem("hammer_handle", 1.0f);
		remover = new ModItemRemover("remover", 0.5f);
		flashlight_lense = new ModItem("flashlight_lense", 0.6f);
		flashlight_handle = new ModItem("flashlight_handle", 1.1f);
		monoculars = new ModItemMonoculars("monoculars", 0.3f);
	}
}
