package first.mathmode;

import first.mathmode.block.ModBlocks;
import first.mathmode.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class Mathmode implements ModInitializer {

    @Override
    public void onInitialize() {
        ModItems.initialize();
        ModBlocks.initialize();
    }
}
