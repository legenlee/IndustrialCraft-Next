package industrialcraftnext.common.block.misc;

import javax.annotation.Nullable;

import industrialcraftnext.common.block.state.properties.ICBlockStateProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class ICRubberLogBlock extends RotatedPillarBlock {
    public static final DirectionProperty FACING;
    public static final BooleanProperty HAS_RESIN;
    public static final BooleanProperty CAN_GENERATE_RESIN;

    static {
        FACING = HorizontalDirectionalBlock.FACING;
        HAS_RESIN = ICBlockStateProperties.HAS_RESIN;
        CAN_GENERATE_RESIN = ICBlockStateProperties.CAN_GENERATE_RESIN;
    }

    public ICRubberLogBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState()
            .setValue(FACING, Direction.NORTH)
            .setValue(CAN_GENERATE_RESIN, false)
            .setValue(HAS_RESIN, false));
    }
    
    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(CAN_GENERATE_RESIN, false);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(FACING, CAN_GENERATE_RESIN, HAS_RESIN));
    }
    
    @Override
    protected boolean isRandomlyTicking(BlockState state) {
        return state.getValue(CAN_GENERATE_RESIN);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource rand) {
        boolean hasResin = state.getValue(HAS_RESIN);

        if (!hasResin && rand.nextInt(50) == 0 && level.getBlockState(pos.relative(Direction.DOWN, 1)).getBlock() == this && level.getBlockState(pos.relative(Direction.UP, 1)).getBlock() == this) {
            Direction facing = Direction.from2DDataValue(rand.nextInt(4));
            level.setBlock(pos, state.setValue(FACING, facing).setValue(HAS_RESIN, true), Block.UPDATE_CLIENTS);
        }
    }
}
