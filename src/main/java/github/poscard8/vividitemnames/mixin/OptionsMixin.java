package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.ModOptions;
import net.minecraft.client.Options;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("ALL")
@OnlyIn(Dist.CLIENT)
@Mixin(Options.class)
public abstract class OptionsMixin {

    private static final ModOptions MOD_OPTIONS = ModOptions.getInstance();

    @Inject(method = "processOptions", at = @At("TAIL"))
    private void addModOptions(Options.FieldAccess fieldAccess, CallbackInfo ci) {
        fieldAccess.process("commonItemColor", MOD_OPTIONS.commonItemColor);
        fieldAccess.process("commonItemBold", MOD_OPTIONS.commonItemBold);
        fieldAccess.process("commonItemItalic", MOD_OPTIONS.commonItemItalic);
        fieldAccess.process("commonItemUnderline", MOD_OPTIONS.commonItemUnderline);
        fieldAccess.process("commonItemStrikethrough", MOD_OPTIONS.commonItemStrikethrough);
        fieldAccess.process("commonItemObfuscated", MOD_OPTIONS.commonItemObfuscated);
        fieldAccess.process("uncommonItemColor", MOD_OPTIONS.uncommonItemColor);
        fieldAccess.process("uncommonItemBold", MOD_OPTIONS.uncommonItemBold);
        fieldAccess.process("uncommonItemItalic", MOD_OPTIONS.uncommonItemItalic);
        fieldAccess.process("uncommonItemUnderline", MOD_OPTIONS.uncommonItemUnderline);
        fieldAccess.process("uncommonItemStrikethrough", MOD_OPTIONS.uncommonItemStrikethrough);
        fieldAccess.process("uncommonItemObfuscated", MOD_OPTIONS.uncommonItemObfuscated);
        fieldAccess.process("rareItemColor", MOD_OPTIONS.rareItemColor);
        fieldAccess.process("rareItemBold", MOD_OPTIONS.rareItemBold);
        fieldAccess.process("rareItemItalic", MOD_OPTIONS.rareItemItalic);
        fieldAccess.process("rareItemUnderline", MOD_OPTIONS.rareItemUnderline);
        fieldAccess.process("rareItemStrikethrough", MOD_OPTIONS.rareItemStrikethrough);
        fieldAccess.process("rareItemObfuscated", MOD_OPTIONS.rareItemObfuscated);
        fieldAccess.process("epicItemColor", MOD_OPTIONS.epicItemColor);
        fieldAccess.process("epicItemBold", MOD_OPTIONS.epicItemBold);
        fieldAccess.process("epicItemItalic", MOD_OPTIONS.epicItemItalic);
        fieldAccess.process("epicItemUnderline", MOD_OPTIONS.epicItemUnderline);
        fieldAccess.process("epicItemStrikethrough", MOD_OPTIONS.epicItemStrikethrough);
        fieldAccess.process("epicItemObfuscated", MOD_OPTIONS.epicItemObfuscated);
    }


}
