package coda.glort.common.items;

import coda.glort.common.entities.AllegiantArrow;
import coda.glort.registry.GlortEntities;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class AllegiantArrowItem extends Item {

    public AllegiantArrowItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        AllegiantArrow arrow = GlortEntities.ALLEGIANT_ARROW.get().create(pLevel);

        Vec3 pos = pPlayer.position();

        arrow.moveTo(pos.x, pos.y + 1.0D, pos.z);
        arrow.setOwner(pPlayer);
        pLevel.playSound(pPlayer, pPlayer.blockPosition(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F);

        pLevel.addFreshEntity(arrow);

        return super.use(pLevel, pPlayer, pUsedHand);
    }
}
