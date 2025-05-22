package first.mathmode.item;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public final class ModItems {
    private ModItems() {
    }

    public static final Item EQUATION = register("equation", Equation::new, new Item.Settings());
    public static final Item ENERGY_ROD = register("energy_rod", EnergyRod::new, new Item.Settings());

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("mathmode", path));
        return Items.register(registryKey, factory, settings);
    }

    public static void initialize() {
    }
}