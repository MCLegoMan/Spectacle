/*
    Spectacle
    Author: MCLegoMan
    Github: https://github.com/MCLegoMan/Spectacle
    License: CC-BY 4.0
*/

package com.mclegoman.spectacle.common.data;

import com.mclegoman.releasetypeutils.common.releasetype.RTUReleaseTranslationTypes;
import com.mclegoman.releasetypeutils.common.releasetype.RTUReleaseType;
import com.mclegoman.releasetypeutils.common.releasetype.RTUReleaseTypes;
import com.mclegoman.spectacle.common.util.SpectacleLogType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpectacleData {
    public static final String NAME = "Spectacle";
    public static final String ID = "spectacle";
    public static final Integer MAJOR_VERSION = 1;
    public static final Integer MINOR_VERSION = 0;
    public static final Integer PATCH_VERSION = 0;
    public static final RTUReleaseTypes RELEASE_TYPE = RTUReleaseTypes.ALPHA;
    public static final Integer BUILD_VERSION = 1;
    public static final Boolean IS_DEVELOPMENT = RTUReleaseType.isDevelopmentBuild(RELEASE_TYPE);
    public static final String VERSION = MAJOR_VERSION + "." + MINOR_VERSION + "." + PATCH_VERSION + "-" + RTUReleaseType.releaseTypeString(RELEASE_TYPE, RTUReleaseTranslationTypes.NORMAL) + "." + BUILD_VERSION;
    public static final String PREFIX = "[" + NAME + " " + VERSION + "] ";
    private static final Logger LOGGER = LoggerFactory.getLogger(NAME);
    public static final ModContainer MOD_CONTAINER = FabricLoader.getInstance().getModContainer(ID).get();
    public static void addLog(SpectacleLogType logType, String message) {
        if (logType.equals(SpectacleLogType.INFO)) LOGGER.info(PREFIX + message);
        if (logType.equals(SpectacleLogType.WARN)) LOGGER.info(PREFIX + message);
        if (logType.equals(SpectacleLogType.ERROR)) LOGGER.info(PREFIX + message);
        if (logType.equals(SpectacleLogType.DEBUG)) LOGGER.info(PREFIX + message);
    }
}