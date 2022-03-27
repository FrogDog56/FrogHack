package me.frogdog.hecks.module.modules.misc;

import me.frogdog.hecks.module.ModuleType;
import me.frogdog.hecks.module.ToggleableModule;
import me.frogdog.hecks.property.NumberProperty;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public final class Timer extends ToggleableModule {
    private final NumberProperty<Float> speed = new NumberProperty<>(1f, 0f, 10f, "Speed", "TimerSpeed", "ts");

    public Timer() {
        super("Timer", new String[] {"timer", "timerspeed"}, ModuleType.MISC);
        this.offerProperties(this.speed);
        this.offerProperties(this.keybind);
    }

    public void update(TickEvent event) {
        mc.timer.tickLength = 50f / (Timer.this.speed.getValue() == 0f ? 0.1f : Timer.this.speed.getValue());
    }

    @Override
    public void onDisable() {
        super.onDisable();
        mc.timer.tickLength = 50f;

    }
}
