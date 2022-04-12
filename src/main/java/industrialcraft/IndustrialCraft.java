package industrialcraft;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import industrialcraft.core.client.ICBlockRenderHandler;
import industrialcraft.core.registry.ICBlockItems;
import industrialcraft.core.registry.ICBlocks;
import industrialcraft.core.registry.ICEntities;
import industrialcraft.core.registry.ICFeatures;
import industrialcraft.core.registry.ICItems;
import industrialcraft.core.registry.ICSoundEvents;

@Mod(IndustrialCraft.MOD_ID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class IndustrialCraft {
    public static final String MOD_ID = "icnext";
    public static final Logger LOGGER = LogManager.getLogger();

    public IndustrialCraft() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::commonSetup);
        bus.addListener(this::clientSetup);

        ICSoundEvents.setup(bus);
        ICBlocks.setup(bus);
        ICBlockItems.setup(bus);
        ICItems.setup(bus);
        ICEntities.setup(bus);
        ICFeatures.setup(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        WoodType.register(ICBlocks.RUBBER);

        event.enqueueWork(() -> {
            ICBlocks.setupPots();
            ICBlocks.setupFlammables();
            ICBlocks.setupStrippables();
        });
    }

    @OnlyIn(Dist.CLIENT)
    private void clientSetup(final FMLClientSetupEvent event) {
        ICBlockRenderHandler.setup();
    }

    public static ResourceLocation modPrefix(String name) {
        return new ResourceLocation(IndustrialCraft.MOD_ID, name);
    }

    public static ResourceLocation forgePrefix(String name) {
        return new ResourceLocation("forge", name);
    }

    public static ResourceLocation mcPrefix(String name) {
        return new ResourceLocation("minecraft", name);
    }
}
