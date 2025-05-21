package first.mathmode;

import first.mathmode.item.ModItems;
import net.fabricmc.api.ModInitializer;

public class FabricDocsReferenceItems implements ModInitializer {
    @Override
    public void onInitialize() {
        ModItems.initialize();
    }
}