package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;

public class MItems {
	//Pre-Alpha
	public static Item binoculars;
	public static Item flashlight;
	public static Item hammer;
	public static Item rusty_key;
	//Alpha 1
	//Alpha 2
	public static Item bullet;
	public static Item crowbar;
	public static Item keycard;
	public static Item lockpick;
	public static Item magnet_gun;
	public static Item red_key;
	public static Item rifle;
	public static Item wrench;
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
		rusty_key = new ModItemKeyRusty("rusty_key");
		//Alpha 1
		//Alpha 2
		bullet = new ModItem("bullet");
		crowbar = new ModItemCrowbar("crowbar");
		keycard = new ModItemKeycard("keycard");
		lockpick = new ModItemLockpick("lockpick").setFull3D();
		magnet_gun = new ModItemMagnetGun("magnet_gun");
		red_key = new ModItemKeyRed("red_key");
		rifle = new ModItemRifle("rifle");
		wrench = new ModItemWrench("wrench", 3.0f).setFull3D();
		//All
		spawn_egg = new ModItemMonsterPlacer("Neighbor", 0xFBFF87, 0x879DFF, "Neighbor");
		//Custom
		iron_magnetized = new ModItem("iron_magnetized");
		magnet = new ModItem("magnet");
		nail = new ModItem("nail");
	}
}
