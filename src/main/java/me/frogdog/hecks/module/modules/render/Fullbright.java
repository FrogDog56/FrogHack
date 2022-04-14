package me.frogdog.hecks.module.modules.render;

import me.frogdog.hecks.module.ModuleType;
import me.frogdog.hecks.module.ToggleableModule;
import me.frogdog.hecks.property.EnumProperty;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public final class Fullbright extends ToggleableModule {
    private final EnumProperty<Mode> mode = new EnumProperty<Mode>(Mode.POTION, "Mode", "m");

    public Fullbright() {
        super("Fullbright", new String[]{"fullbright", "Fullbright", "fb"}, "Does exactly what it's name indicates", ModuleType.RENDER);
        this.offerProperties(this.mode, this.keybind);
    }

    @Override
    public void render(RenderWorldLastEvent event) {
        if (Fullbright.this.mode.getValue() == Mode.GAMMA) {
            mc.gameSettings.gammaSetting = 1000f;
        }

        if(Fullbright.this.mode.getValue() == Mode.POTION) {
            mc.player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 5, 0));
        }
    }

    public enum Mode {
        GAMMA,
        POTION
    }

}
