package coda.glort.client.render;

import coda.glort.Glort;
import coda.glort.client.GlortModelLayers;
import coda.glort.client.model.CroakerModel;
import coda.glort.common.entities.Croaker;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class CroakerRenderer extends MobRenderer<Croaker, CroakerModel<Croaker>> {
   public static final Map<Integer, ResourceLocation> TEXTURES = Util.make(Maps.newHashMap(), (hashMap) -> {
      hashMap.put(0, new ResourceLocation(Glort.MOD_ID, "textures/entity/croaker/croaker_1.png"));
      hashMap.put(1, new ResourceLocation(Glort.MOD_ID, "textures/entity/croaker/croaker_2.png"));
      hashMap.put(2, new ResourceLocation(Glort.MOD_ID, "textures/entity/croaker/croaker_3.png"));
      hashMap.put(3, new ResourceLocation(Glort.MOD_ID, "textures/entity/croaker/croaker_4.png"));
   });

   public CroakerRenderer(EntityRendererProvider.Context p_174437_) {
      super(p_174437_, new CroakerModel<>(p_174437_.bakeLayer(GlortModelLayers.CROAKER)), 0.5F);
   }

   public ResourceLocation getTextureLocation(Croaker pEntity) {
      return pEntity.isBaby() ? TEXTURES.get(0) : TEXTURES.getOrDefault(pEntity.getVariant(), TEXTURES.get(0));
   }

   protected void scale(Croaker pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
      float f = 1.0F;

      if (pLivingEntity.isBaby()) {
         f *= 0.5F;
         this.shadowRadius = 0.25F;
      } else {
         this.shadowRadius = 0.5F;
      }

      pMatrixStack.scale(f, f, f);
   }
}