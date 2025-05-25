package first.mathmode.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class EnergyRod extends Item {
    public EnergyRod(Settings settings) {
        super(settings.maxCount(1));
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        // Only do this on the server
        if (!world.isClient) {
            // Check what the player is looking at
            HitResult hitResult = user.raycast(5.0D, 0.0F, false);
            if (hitResult.getType() == HitResult.Type.BLOCK) {
                BlockHitResult blockHit = (BlockHitResult) hitResult;
                // Get the position of the block being looked at
                var pos = blockHit.getBlockPos();

                // Replace that block with water
                world.setBlockState(pos, Blocks.AIR.getDefaultState());
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        World world = attacker.getEntityWorld();
        if (world.getRandom().nextInt(1000) == 0) {
            target.kill((ServerWorld) world);
        }
    }
}
