package me.frogdog.hecks.util;

import me.frogdog.hecks.Hecks;
import net.minecraft.util.math.MathHelper;

public class PlayerUtil {

    static Timer timer = new Timer();

    public static double getSpeed() {
        double speed;
        double prevPosX = 0;
        double prevPosZ = 0;
        if (timer.getPassedMillis(1000)) {
            prevPosX = Hecks.getInstance().mc.player.prevPosX;
            prevPosZ = Hecks.getInstance().mc.player.prevPosZ;
        }
        speed = Math.floor(((MathHelper.sqrt((Hecks.getInstance().mc.player.posX - prevPosX) * (Hecks.getInstance().mc.player.posX - prevPosX)+ (Hecks.getInstance().mc.player.posZ - prevPosZ) * (Hecks.getInstance().mc.player.posZ - prevPosZ))) / 1000.0f)/ (0.05f / 3600.0f));
        return speed;
    }
}
