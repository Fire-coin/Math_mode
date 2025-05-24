package first.mathmode.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class VelocityDerivative extends Equation{
    public VelocityDerivative(Item.Settings settings) {
        super(4, settings); // Derivative definition of velocity is tier 4
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 20, 1);
        user.addStatusEffect(effect);

        return ActionResult.SUCCESS;
    }
}
