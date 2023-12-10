package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.VividItemNames;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@SuppressWarnings("ALL")
@OnlyIn(Dist.CLIENT)
@Mixin(Item.class)
public abstract class ItemMixin {

    private static final Rarity MODDED_COMMON = Rarity.create("modded_common", style -> VividItemNames.getCommonStyle());
    private static final Rarity MODDED_UNCOMMON = Rarity.create("modded_uncommon", style -> VividItemNames.getUncommonStyle());
    private static final Rarity MODDED_RARE = Rarity.create("modded_rare", style -> VividItemNames.getRareStyle());
    private static final Rarity MODDED_EPIC = Rarity.create("modded_epic", style -> VividItemNames.getEpicStyle());

    private static final Map<Rarity, Rarity> MAP = Map.of(
            Rarity.COMMON, MODDED_COMMON, Rarity.UNCOMMON, MODDED_UNCOMMON, Rarity.RARE, MODDED_RARE, Rarity.EPIC, MODDED_EPIC
    );

    @Inject(method = "getRarity", at = @At("RETURN"), cancellable = true)
    private void redirectRarity(ItemStack stack, CallbackInfoReturnable<Rarity> ci) {
        if (MAP.keySet().contains(ci.getReturnValue())) {
            ci.setReturnValue(MAP.get(ci.getReturnValue()));
        }
    }


}
