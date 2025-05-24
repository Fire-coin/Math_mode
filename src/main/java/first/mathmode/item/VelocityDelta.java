package first.mathmode.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class VelocityDelta extends Equation {
    public VelocityDelta(Item.Settings settings) {
        super(2, settings); // Speed is tier 2 equation
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        StatusEffectInstance effect = new StatusEffectInstance(StatusEffects.SPEED, 20 * 60 * 10, 0);
        user.addStatusEffect(effect);

        return ActionResult.SUCCESS;
    }
}
