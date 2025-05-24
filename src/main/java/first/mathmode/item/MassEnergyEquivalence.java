package first.mathmode.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class MassEnergyEquivalence extends Equation {
    public MassEnergyEquivalence(Item.Settings settings) {
        super(5, settings);
    }

    @Override
    public void onCraftByPlayer(ItemStack stack, PlayerEntity player) {
        ItemStack itemStack = new ItemStack(ModItems.ENERGY_ROD, 1);
        player.giveItemStack(itemStack);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        StatusEffectInstance strength2 = new StatusEffectInstance(StatusEffects.STRENGTH, 20 * 60 * 30, 1);
        StatusEffectInstance speed2 = new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 30, 1);
        user.addStatusEffect(strength2);
        user.addStatusEffect(speed2);

        return ActionResult.SUCCESS;
    }
}
