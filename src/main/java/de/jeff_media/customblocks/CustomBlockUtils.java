package de.jeff_media.customblocks;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.BoundingBox;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CustomBlockUtils {

    private static Logger logger = Bukkit.getLogger();

    public static boolean isDebug() {
        return Boolean.parseBoolean(System.getProperty("customblocks.debug", "false"));
    }

    public static void debug(String message) {

        if (isDebug()) {
            logger.info("[CustomBlocks] " + message);
        }

    }

    public static void setDebug(boolean debug) {
        System.setProperty("customblocks.debug", String.valueOf(debug));
    }

    public static Collection<ArmorStand> getArmorStands(Block block) {
        return block.getWorld().getNearbyEntities(BoundingBox.of(block))
                .stream()
                .filter(entity -> entity instanceof ArmorStand)
                .map(entity -> (ArmorStand) entity)
                .collect(Collectors.toList());
    }

    public static Logger getLogger() {
        return CustomBlockUtils.logger;
    }

    public static void setLogger(Logger logger) {
        CustomBlockUtils.logger = logger;
    }
}
