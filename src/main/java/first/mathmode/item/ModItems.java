package first.mathmode.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {
    private ModItems() {
    }

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("mathmode", path));
        return Items.register(registryKey, factory, settings);
    }

    public static Item register(String path, Function<Item.Settings, Item> factory) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("mathmode", path));
        return Items.register(registryKey, factory, new Item.Settings());
    }

    public static final Item EQUATION = register("equation", Equation::new, new Item.Settings());
    public static final Item ENERGY_ROD = register("energy_rod", EnergyRod::new, new Item.Settings());
    public static final Item RESEARCH_PAPER_TIER_0 = register("research_paper_tier_0", (Function) ((settings) -> new ResearchPaper(0, (Item.Settings) settings)));
    public static final Item RESEARCH_PAPER_TIER_1 = register("research_paper_tier_1", (Function) ((settings) -> new ResearchPaper(1, (Item.Settings) settings)));
    public static final Item RESEARCH_PAPER_TIER_2 = register("research_paper_tier_2", (Function) ((settings) -> new ResearchPaper(2, (Item.Settings) settings)));
    public static final Item RESEARCH_PAPER_TIER_3 = register("research_paper_tier_3", (Function) ((settings) -> new ResearchPaper(3, (Item.Settings) settings)));
    public static final Item RESEARCH_PAPER_TIER_4 = register("research_paper_tier_4", (Function) ((settings) -> new ResearchPaper(4, (Item.Settings) settings)));
    public static final Item RESEARCH_PAPER_TIER_5 = register("research_paper_tier_5", (Function) ((settings) -> new ResearchPaper(5, (Item.Settings) settings)));



    public static void initialize() {
    }
}