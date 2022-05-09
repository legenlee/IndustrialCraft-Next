package industrialcraft.common.block.transport;

import industrialcraft.common.block.TransportBlock;
import industrialcraft.common.tier.CableTier;

public class CableBlock extends AbstractCableBlock {
    public CableBlock(CableTier tier) {
        super(tier);
    }

    @Override
    public boolean canDamageNearbyEntity() {
        return true;
    }
}
