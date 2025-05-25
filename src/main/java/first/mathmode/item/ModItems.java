package first.mathmode.item;

import net.minecraft.item.*;
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

    public static final Item EQUATION = register("equation", ((settings) -> new Equation(0, settings)));
    public static final Item GEOMETRY = register("geometry", ((settings) -> new Equation(0, settings)));
    public static final Item PYTHAGORAS_THEOREM = register("pythagoras_theorem", ((settings) -> new Equation(1, settings)));
    public static final Item ALGEBRA = register("algebra", ((settings) -> new Equation(1, settings)));
    public static final Item FORCE_DELTA = register("force_delta", ForceDelta::new, new Item.Settings());
    public static final Item VELOCITY_DELTA = register("velocity_delta", VelocityDelta::new, new Item.Settings());
    public static final Item LIMITS = register("limits", ((settings) -> new Equation(3, settings)));
    public static final Item DIFFERENTIAL_CALCULUS = register("differential_calculus", ((settings) -> new Equation(3, settings)));
    public static final Item FORCE_DERIVATIVE = register("force_derivative", ForceDerivative::new, new Item.Settings());
    public static final Item VELOCITY_DERIVATIVE = register("velocity_derivative", VelocityDerivative::new, new Item.Settings());
    public static final Item CALCULUS = register("calculus", ((settings) -> new Equation(4, settings)));
    public static final Item MASS_ENERGY_EQUIVALENCE = register("mass_energy_equivalence", MassEnergyEquivalence::new, new Item.Settings());
    public static final Item RESEARCH_PAPER_TIER_0 = register("research_paper_tier_0", ((settings) -> new ResearchPaper(0, settings)));
    public static final Item RESEARCH_PAPER_TIER_1 = register("research_paper_tier_1", ((settings) -> new ResearchPaper(1, settings)));
    public static final Item RESEARCH_PAPER_TIER_2 = register("research_paper_tier_2", ((settings) -> new ResearchPaper(2, settings)));
    public static final Item RESEARCH_PAPER_TIER_3 = register("research_paper_tier_3", ((settings) -> new ResearchPaper(3, settings)));
    public static final Item RESEARCH_PAPER_TIER_4 = register("research_paper_tier_4", ((settings) -> new ResearchPaper(4, settings)));
    public static final Item RESEARCH_PAPER_TIER_5 = register("research_paper_tier_5", ((settings) -> new ResearchPaper(5, settings)));
    public static final Item ENERGY_ROD = register("energy_rod", EnergyRod::new, new Item.Settings());

    public static void initialize() {
    }
}