package com.cubic_control.hnm.Entity;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.cubic_control.hnm.Main.MainRegistry;

public class MEntity {
	public static void createEntity(){
		EntityRegistry.registerModEntity(EntityNeighbor.class, "Neighbor", 1, MainRegistry.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityBullet.class, "Bullet", 2, MainRegistry.instance, 64, 1, true);
		EntityRegistry.registerModEntity(EntityShadow.class, "Shadow", 3, MainRegistry.instance, 64, 1, true);
		addSpawn();
	}
	
	public static void addSpawn(){
		EntityRegistry.addSpawn(EntityNeighbor.class, 10, 1, 5, EnumCreatureType.CREATURE);
		EntityRegistry.addSpawn(EntityNeighbor.class, 5, 1, 3, EnumCreatureType.MONSTER);
	}
}
