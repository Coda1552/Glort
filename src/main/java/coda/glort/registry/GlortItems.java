package coda.glort.registry;

import coda.glort.Glort;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeSpawnEggItem;
import coda.glort.common.items.AllegiantArrowItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class GlortItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Glort.MOD_ID);
    public static final CreativeModeTab GROUP = new CreativeModeTab(Glort.MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CROAKER_SPAWN_EGG.get());
        }
    };

    public static final RegistryObject<Item> CROAKER_SPAWN_EGG = ITEMS.register("croaker_spawn_egg", () -> new ForgeSpawnEggItem(GlortEntities.CROAKER, 0xd07444, 0xe3b373, new Item.Properties().tab(GROUP)));
            return new ItemStack(SCRAG.get());
        }
    };

    public static final RegistryObject<Item> SCRAG = ITEMS.register("scrag", () -> new BlockItem(GlortBlocks.SCRAG.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> ALLEGIANT_ARROW = ITEMS.register("allegiant_arrow", () -> new AllegiantArrowItem(new Item.Properties().tab(GROUP)));
}
