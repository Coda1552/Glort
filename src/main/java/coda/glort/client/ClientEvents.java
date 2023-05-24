package coda.glort.client;

import coda.glort.Glort;
import coda.glort.client.model.CroakerModel;
import coda.glort.client.render.CroakerRenderer;
import coda.glort.client.renderer.AllegiantArrowRenderer;
import coda.glort.registry.GlortEntities;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Glort.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent e) {
        EntityRenderers.register(GlortEntities.ALLEGIANT_ARROW.get(), AllegiantArrowRenderer::new);
        EntityRenderers.register(GlortEntities.CROAKER.get(), CroakerRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions e) {
        e.registerLayerDefinition(GlortModelLayers.CROAKER, CroakerModel::createBodyLayer);
    }
}
