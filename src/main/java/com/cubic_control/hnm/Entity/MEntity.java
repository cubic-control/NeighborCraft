package com.cubic_control.hnm.Entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.cubic_control.hnm.Main.MainRegistry;

import cpw.mods.fml.common.registry.EntityRegistry;

public class MEntity {
	public static void createEntity(){
		EntityRegistry.registerModEntity(EntityNeighbor.class, "Neighbor", 1, MainRegistry.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 2, MainRegistry.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityShadow.class, "Shadow", 3, MainRegistry.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityThePlayer.class, "Player", 4, MainRegistry.instance, 64, 1, true);
		addSpawn();
	}
	
	public static void addSpawn(){
		EntityRegistry.addSpawn(EntityNeighbor.class, 10, 1, 5, EnumCreatureType.creature);
		EntityRegistry.addSpawn(EntityThePlayer.class, 5, 1, 3, EnumCreatureType.creature);
	}
}
