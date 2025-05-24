package first.mathmode.item;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
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
                world.setBlockState(pos, Blocks.WATER.getDefaultState());

                // Optional: message the player
                user.sendMessage(Text.literal("Transformed into water!"), true);
            }
        }

        return ActionResult.SUCCESS;
    }
}
