package first.mathmode.item_group;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;

import static first.mathmode.item.ModItems.*;
import static first.mathmode.block.ModBlocks.*;

public class ModItemGroups {

    public static final RegistryKey<ItemGroup> MATHMODE_GROUP = RegistryKey.of(
            Registries.ITEM_GROUP.getKey(),
            Identifier.of("mathmode", "mathmode_group")
    );

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, MATHMODE_GROUP,
                FabricItemGroup.builder()
                        .icon(() -> new ItemStack(RESEARCH_PAPER_TIER_5)) // icon for the group tab
                        .displayName(Text.translatable("itemGroup.mathmode"))
                        .entries((context, entries) -> {
                            entries.add(EQUATION);
                            entries.add(ENERGY_ROD);
                            entries.add(RESEARCH_PAPER_TIER_0);
                            entries.add(RESEARCH_PAPER_TIER_1);
                            entries.add(RESEARCH_PAPER_TIER_2);
                            entries.add(RESEARCH_PAPER_TIER_3);
                            entries.add(RESEARCH_PAPER_TIER_4);
                            entries.add(RESEARCH_PAPER_TIER_5);
                            entries.add(GEOMETRY);
                            entries.add(PYTHAGORAS_THEOREM);
                            entries.add(ALGEBRA);
                            entries.add(FORCE_DELTA);
                            entries.add(VELOCITY_DELTA);
                            entries.add(LIMITS);
                            entries.add(DIFFERENTIAL_CALCULUS);
                            entries.add(FORCE_DERIVATIVE);
                            entries.add(VELOCITY_DERIVATIVE);
                            entries.add(CALCULUS);
                            entries.add(MASS_ENERGY_EQUIVALENCE);
                            entries.add(RESEARCH_TABLE);
                        })
                        .build()
        );
    }
}