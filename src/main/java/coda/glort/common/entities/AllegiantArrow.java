package coda.glort.common.entities;

import coda.glort.registry.GlortEntities;
import coda.glort.registry.GlortItems;
import com.sun.jna.platform.win32.Sspi;
import net.minecraft.core.particles.DustParticleOptions;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec2;
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
        return new ItemStack(GlortItems.ALLEGIANT_ARROW.get());
    }

    @Override
    public boolean isNoGravity() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

        Entity owner = getOwner();

        for (int i = 0; i < 10; i++) {
            level.addParticle(DustParticleOptions.REDSTONE, getX(), getY(), getZ(), 0.0D, 0.0D, 0.0D);
        }

        if (owner instanceof Player player) {

            if (player.isShiftKeyDown()) {

                Vec3 vec3 = new Vec3(player.getX() - this.getX(), player.getY() + (double)player.getEyeHeight() - this.getY(), player.getZ() - this.getZ());
                this.setDeltaMovement(this.getDeltaMovement().add(vec3.normalize().scale(0.25D)));

                if (inGround) {
                    setDeltaMovement(getDeltaMovement().x, 0.1D, getDeltaMovement().y);
                    inGround = false;
                }
            } else {
                Vec3 viewVec = player.getViewVector(1.0F);

                setDeltaMovement(viewVec.scale(0.9D));
            }
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        Entity entity = pResult.getEntity();

        if (getOwner() instanceof Player player) {
            if (player == entity) {
                discard();

                if (!player.getInventory().add(new ItemStack(GlortItems.ALLEGIANT_ARROW.get()))) {
                    Vec3 pos = player.position();

                    level.addFreshEntity(new ItemEntity(level, pos.x, pos.y, pos.z, new ItemStack(GlortItems.ALLEGIANT_ARROW.get())));
                }
            }
            else {
                DamageSource damageSource = DamageSource.arrow(this, entity);
                player.setLastHurtMob(entity);

                boolean flag = entity.getType() == EntityType.ENDERMAN;

                float damage = 4.0F;

                if (entity.hurt(damageSource, damage)) {
                    if (flag) {
                        return;
                    }

                    this.playSound(SoundEvents.ARROW_HIT, 1.0F, 1.2F / (this.random.nextFloat() * 0.2F + 0.9F));

                    if (entity instanceof LivingEntity livingentity) {
                        if (!this.level.isClientSide && this.getPierceLevel() <= 0) {
                            livingentity.setArrowCount(livingentity.getArrowCount() + 1);
                        }

                        if (!this.level.isClientSide) {
                            EnchantmentHelper.doPostHurtEffects(livingentity, player);
                            EnchantmentHelper.doPostDamageEffects(player, livingentity);
                        }

                        this.doPostHurtEffects(livingentity);
                        if (livingentity instanceof Player && player instanceof ServerPlayer && !this.isSilent()) {
                            ((ServerPlayer) player).connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.ARROW_HIT_PLAYER, 0.0F));
                        }
                    }
                }
            }
        }
    }
}