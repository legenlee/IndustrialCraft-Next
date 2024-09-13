package industrialcraftnext.common.registries;

import industrialcraftnext.IndustrialCraftNext;
import net.minecraft.world.item.BlockItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

// @formatter:off
public class ICNItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(IndustrialCraftNext.MOD_ID);

    public static final DeferredItem<BlockItem> RUBBER_LOG = ITEMS.registerSimpleBlockItem("rubber_log", ICNBlocks.RUBBER_LOG);
}
