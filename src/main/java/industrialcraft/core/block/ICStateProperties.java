package industrialcraft.core.block;

import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class ICStateProperties {
    public static final BooleanProperty HAS_SAP = BooleanProperty.create("has_sap");
    public static final BooleanProperty CAN_CREATE_SAP = BooleanProperty.create("can_create_sap");
    public static final BooleanProperty WORKING = BooleanProperty.create("working");
}