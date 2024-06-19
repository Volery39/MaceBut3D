package volery.macebut3d.mixin.client;

import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static volery.macebut3d.MaceBut3D.MOD_ID;

@Mixin(ModelLoader.class)
public abstract class ModelLoaderMixin {
    @Shadow
    protected abstract void loadItemModel(ModelIdentifier id);

    @Inject(
            method = {"<init>"},
            at = {@At(
                    value = "invoke",
                    ordinal = 0,
                    target = "Lnet/minecraft/client/render/model/ModelLoader;loadItemModel(Lnet/minecraft/client/util/ModelIdentifier;)V"
            )}
    )
    private void addMace(CallbackInfo info) {
        this.loadItemModel(ModelIdentifier.ofInventoryVariant(Identifier.of(MOD_ID, "mace_in_hand")));
    }
}
