package coda.glort.registry;

import coda.glort.Glort;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlortBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Glort.MOD_ID);

    public static final RegistryObject<Block> SCRAG = BLOCKS.register("scrag", () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)));
}
