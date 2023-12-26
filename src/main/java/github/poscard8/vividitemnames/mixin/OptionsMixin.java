package github.poscard8.vividitemnames.mixin;

import github.poscard8.vividitemnames.VividItemNames;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("ALL")
@Mixin(Options.class)
public abstract class OptionsMixin {

    @Inject(method = "processOptions", at = @At("TAIL"))
    private void addModOptions(Options.FieldAccess fieldAccess, CallbackInfo ci) {

        fieldAccess.process("commonItemColor", VividItemNames.OPTIONS.commonItemColor);
        fieldAccess.process("commonItemBold", VividItemNames.OPTIONS.commonItemBold);
        fieldAccess.process("commonItemItalic", VividItemNames.OPTIONS.commonItemItalic);
        fieldAccess.process("commonItemUnderline", VividItemNames.OPTIONS.commonItemUnderline);
        fieldAccess.process("commonItemStrikethrough", VividItemNames.OPTIONS.commonItemStrikethrough);
        fieldAccess.process("commonItemObfuscated", VividItemNames.OPTIONS.commonItemObfuscated);
        fieldAccess.process("commonItemEnclosure", VividItemNames.OPTIONS.commonItemEnclosure);
        fieldAccess.process("commonItemEnclosureColor", VividItemNames.OPTIONS.commonItemEnclosureColor);
        fieldAccess.process("uncommonItemColor", VividItemNames.OPTIONS.uncommonItemColor);
        fieldAccess.process("uncommonItemBold", VividItemNames.OPTIONS.uncommonItemBold);
        fieldAccess.process("uncommonItemItalic", VividItemNames.OPTIONS.uncommonItemItalic);
        fieldAccess.process("uncommonItemUnderline", VividItemNames.OPTIONS.uncommonItemUnderline);
        fieldAccess.process("uncommonItemStrikethrough", VividItemNames.OPTIONS.uncommonItemStrikethrough);
        fieldAccess.process("uncommonItemObfuscated", VividItemNames.OPTIONS.uncommonItemObfuscated);
        fieldAccess.process("uncommonItemEnclosure", VividItemNames.OPTIONS.uncommonItemEnclosure);
        fieldAccess.process("uncommonItemEnclosureColor", VividItemNames.OPTIONS.uncommonItemEnclosureColor);
        fieldAccess.process("rareItemColor", VividItemNames.OPTIONS.rareItemColor);
        fieldAccess.process("rareItemBold", VividItemNames.OPTIONS.rareItemBold);
        fieldAccess.process("rareItemItalic", VividItemNames.OPTIONS.rareItemItalic);
        fieldAccess.process("rareItemUnderline", VividItemNames.OPTIONS.rareItemUnderline);
        fieldAccess.process("rareItemStrikethrough", VividItemNames.OPTIONS.rareItemStrikethrough);
        fieldAccess.process("rareItemObfuscated", VividItemNames.OPTIONS.rareItemObfuscated);
        fieldAccess.process("rareItemEnclosure", VividItemNames.OPTIONS.rareItemEnclosure);
        fieldAccess.process("rareItemEnclosureColor", VividItemNames.OPTIONS.rareItemEnclosureColor);
        fieldAccess.process("epicItemColor", VividItemNames.OPTIONS.epicItemColor);
        fieldAccess.process("epicItemBold", VividItemNames.OPTIONS.epicItemBold);
        fieldAccess.process("epicItemItalic", VividItemNames.OPTIONS.epicItemItalic);
        fieldAccess.process("epicItemUnderline", VividItemNames.OPTIONS.epicItemUnderline);
        fieldAccess.process("epicItemStrikethrough", VividItemNames.OPTIONS.epicItemStrikethrough);
        fieldAccess.process("epicItemObfuscated", VividItemNames.OPTIONS.epicItemObfuscated);
        fieldAccess.process("epicItemEnclosure", VividItemNames.OPTIONS.epicItemEnclosure);
        fieldAccess.process("epicItemEnclosureColor", VividItemNames.OPTIONS.epicItemEnclosureColor);
        fieldAccess.process("otherItemColor", VividItemNames.OPTIONS.otherItemColor);
        fieldAccess.process("otherItemBold", VividItemNames.OPTIONS.otherItemBold);
        fieldAccess.process("otherItemItalic", VividItemNames.OPTIONS.otherItemItalic);
        fieldAccess.process("otherItemUnderline", VividItemNames.OPTIONS.otherItemUnderline);
        fieldAccess.process("otherItemStrikethrough", VividItemNames.OPTIONS.otherItemStrikethrough);
        fieldAccess.process("otherItemObfuscated", VividItemNames.OPTIONS.otherItemObfuscated);
        fieldAccess.process("otherItemEnclosure", VividItemNames.OPTIONS.otherItemEnclosure);
        fieldAccess.process("otherItemEnclosureColor", VividItemNames.OPTIONS.otherItemEnclosureColor);
    }

}
