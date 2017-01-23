package com.cubic_control.hnm.Items;

import com.cubic_control.hnm.Blocks.MBlocks;
import com.cubic_control.hnm.CreativeTabs.MCreativeTabs;
import com.cubic_control.hnm.Entity.EntityNeighbor;
import com.cubic_control.hnm.Entity.EntityShadow;
import com.cubic_control.hnm.Lib.RefStrings;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
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
	public static Item spawn_neighbor;
	public static Item spawn_shadow;
	//Custom
	public static Item iron_magnetized;
	public static Item magnet;
	public static Item nail;
	
	public static void createItems(){
		//Pre-Alpha
		binoculars = new ModItemBinoculars("binoculars").setFull3D();
		flashlight = new ModItem("flashlight").setFull3D();
		hammer = new ModItemHammer("hammer").setFull3D();
		key_rusty = new ModItemKeyRusty("key_rusty").setFull3D();
		//Alpha 1
		crowbar = new ModItemCrowbar("crowbar").setFull3D();
		rifle = new ModItemRifle("rifle").setFull3D();
		//Alpha 2
		bullet = new ModItem("bullet");
		door_white = new ModItemDoor(MBlocks.door_white, "door_white");
		key_red = new ModItemKeyRed("key_red").setFull3D();
		keycard = new ModItemKeycard("keycard").setFull3D();
		lockpick = new ModItemLockpick("lockpick").setFull3D();
		magnet_gun = new ModItemMagnetGun("magnet_gun").setFull3D();
		wrench = new ModItemWrench("wrench", 3.0f).setFull3D();
		//Alpha 3
		door_golden = new ModItemDoor(MBlocks.door_golden, "door_golden");
		key_blue = new ModItemKeyBlue("key_blue").setFull3D();
		key_golden = new ModItemKeyGolden("key_golden").setFull3D();
		//All
		spawn_neighbor = new ModItemSpawnItem("spawn_neighbor");
		spawn_shadow = new ModItemSpawnItem("spawn_shadow");
		//Custom
		iron_magnetized = new ModItem("iron_magnetized");
		magnet = new ModItem("magnet");
		nail = new ModItem("nail");
	}
	
	public static void registerItemRenderer() {
		//Pre-Alpha
		reg(binoculars);
		reg(flashlight);
		reg(hammer);
		reg(key_rusty);
		//Alpha 1
		reg(crowbar);
		reg(rifle);
		//Alpha 2
		reg(bullet);
		reg(door_white);
		reg(key_red);
		reg(keycard);
		reg(lockpick);
		reg(magnet_gun);
		reg(wrench);
		//Alpha 3
		reg(door_golden);
		reg(key_blue);
		reg(key_golden);
		//All
		reg(spawn_neighbor);
		reg(spawn_shadow);
		//Custom
		reg(iron_magnetized);
		reg(magnet);
		reg(nail);
    }
	
	public static void reg(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(RefStrings.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
