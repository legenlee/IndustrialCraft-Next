package industrialcraftnext;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import industrialcraftnext.common.registries.ICNBlocks;
import industrialcraftnext.common.registries.ICNItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(IndustrialCraftNext.MOD_ID)
public class IndustrialCraftNext {
    public static final String MOD_ID = "icnext";
    private static final Logger LOGGER = LogUtils.getLogger();

    public IndustrialCraftNext(IEventBus modEventBus, ModContainer modContainer) {
        ICNBlocks.BLOCKS.register(modEventBus);
        ICNItems.ITEMS.register(modEventBus);
    }
}
