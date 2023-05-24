package coda.glort;

import coda.glort.registry.GlortEntities;
import coda.glort.registry.GlortItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Glort.MOD_ID)
public class Glort {
	public static final String MOD_ID = "glort";

	public Glort() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		IEventBus forgeBus = MinecraftForge.EVENT_BUS;

		bus.addListener(GlortEntities::registerAttributes);
		bus.addListener(GlortEntities::registerSpawnPlacements);

		GlortEntities.ENTITIES.register(bus);
		GlortItems.ITEMS.register(bus);
	}
}