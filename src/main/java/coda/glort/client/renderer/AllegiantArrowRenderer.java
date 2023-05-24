package coda.glort.client.renderer;

import coda.glort.common.entities.AllegiantArrow;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class AllegiantArrowRenderer extends ArrowRenderer<AllegiantArrow> {
   public static final ResourceLocation LOCATION = new ResourceLocation("textures/entity/projectiles/arrow.png");

   public AllegiantArrowRenderer(EntityRendererProvider.Context pContext) {
      super(pContext);
   }

   public ResourceLocation getTextureLocation(AllegiantArrow pEntity) {
      return LOCATION;
   }
}