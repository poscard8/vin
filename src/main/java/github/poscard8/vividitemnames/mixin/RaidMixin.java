package github.poscard8.vividitemnames.mixin;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@SuppressWarnings("ALL")
@Mixin(Raid.class)
public abstract class RaidMixin {

    @Inject(method = "getLeaderBannerInstance", at = @At("TAIL"), cancellable = true)
    private static void tweakOminousBanner(CallbackInfoReturnable<ItemStack> ci) {

        ItemStack stack = ci.getReturnValue();
        stack.setHoverName(Component.translatable("block.minecraft.ominous_banner"));
        ci.setReturnValue(stack);
    }

}
