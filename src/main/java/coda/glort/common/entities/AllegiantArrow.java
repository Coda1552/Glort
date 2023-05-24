package coda.glort.common.entities;

import coda.glort.registry.GlortEntities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AllegiantArrow extends AbstractArrow {

    public AllegiantArrow(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        pickup = Pickup.DISALLOWED;
    }

    public AllegiantArrow(Level pLevel, double pX, double pY, double pZ) {
        super(GlortEntities.ALLEGIANT_ARROW.get(), pX, pY, pZ, pLevel);
    }

    public AllegiantArrow(Level pLevel, LivingEntity pShooter) {
        super(GlortEntities.ALLEGIANT_ARROW.get(), pShooter, pLevel);
    }

    @Override
    protected ItemStack getPickupItem() {
        return null;
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        Entity owner = getOwner();

        // todo - if the player is shifting, the arrow gets called back
        if (owner instanceof Player player) {
            Vec3 viewVec = player.getViewVector(1.0F);
            Vec3 playerPos = player.position();

            setDeltaMovement(viewVec.x, viewVec.y, viewVec.z);
        }
    }
}
