package coda.glort.client;

import coda.glort.Glort;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class GlortModelLayers {
    public static final ModelLayerLocation CROAKER = create("croaker");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(Glort.MOD_ID, name), "main");
    }
}
