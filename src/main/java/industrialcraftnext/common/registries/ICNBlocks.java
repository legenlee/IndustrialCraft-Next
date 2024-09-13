package industrialcraftnext.common.registries;

import industrialcraftnext.IndustrialCraftNext;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

// @formatter:off
public final class ICNBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(IndustrialCraftNext.MOD_ID);

    public static final DeferredBlock<Block> RUBBER_LOG = BLOCKS.registerBlock("rubber_log", RotatedPillarBlock::new,
        BlockBehaviour.Properties.of()
            .mapColor(state -> state.getValue(BlockStateProperties.AXIS) == Direction.Axis.Y ? MapColor.WOOD : MapColor.COLOR_BROWN)
            .instrument(NoteBlockInstrument.BASS)
            .strength(2.0F)
            .sound(SoundType.WOOD)
            .ignitedByLava());
}
