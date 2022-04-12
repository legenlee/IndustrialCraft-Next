package industrialcraft.core.inventory;

import industrialcraft.IndustrialCraft;
import industrialcraft.core.registry.ICItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.RegistryObject;

public class ICCreativeModeTab {
    public static final CreativeModeTab ICNEXT = createCreativeModeTab("general", ICItems.TIN_INGOT);

    public static final CreativeModeTab createCreativeModeTab(String label, RegistryObject<Item> itemObject) {
        return new CreativeModeTab(IndustrialCraft.MOD_ID + "." + label) {
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(itemObject.get());
            }
        };
    }
}
