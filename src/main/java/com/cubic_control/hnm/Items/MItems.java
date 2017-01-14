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
	
	public static void createItems(){
		//Pre-Alpha
		binoculars = new ModItemBinoculars("binoculars");
		flashlight = new ModItem("flashlight");
		hammer = new ModItemHammer("hammer");
		key_rusty = new ModItemKeyRusty("key_rusty");
		//Alpha 1
		crowbar = new ModItemCrowbar("crowbar");
		rifle = new ModItemRifle("rifle");
		//Alpha 2
		bullet = new ModItem("bullet");
		door_white = new ModItemDoor("door_white");
		key_red = new ModItemKeyRed("key_red");
		keycard = new ModItemKeycard("keycard");
		lockpick = new ModItemLockpick("lockpick").setFull3D();
		magnet_gun = new ModItemMagnetGun("magnet_gun");
		wrench = new ModItemWrench("wrench", 3.0f).setFull3D();
		//Alpha 3
		door_golden = new ModItemDoor("door_golden");
		key_blue = new ModItemKeyBlue("key_blue");
		key_golden = new ModItemKeyGolden("key_golden");
		//All
		spawn_egg = new ModItemMonsterPlacer("Neighbor", 0xFBFF87, 0x879DFF, "Neighbor");
		//Custom
		iron_magnetized = new ModItem("iron_magnetized");
		magnet = new ModItem("magnet");
		nail = new ModItem("nail");
	}
}
