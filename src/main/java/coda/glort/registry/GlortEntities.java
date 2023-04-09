package coda.glort.registry;

import coda.glort.Glort;
import coda.glort.common.entities.Croaker;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlortEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Glort.MOD_ID);

    public static void registerAttributes(final EntityAttributeCreationEvent e) {
        e.put(GlortEntities.CROAKER.get(), Croaker.createAttributes().build());
    }

    public static void registerSpawnPlacements(final SpawnPlacementRegisterEvent event) {
        //event.register(GlortEntities.CROAKER.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Croaker::canSpawn, SpawnPlacementRegisterEvent.Operation.REPLACE);
    }

    public static final RegistryObject<EntityType<Croaker>> CROAKER = ENTITIES.register("croaker", () -> EntityType.Builder.of(Croaker::new, MobCategory.CREATURE).sized(0.45F, 1.6F).setTrackingRange(16).updateInterval(1).build("croaker"));

}
