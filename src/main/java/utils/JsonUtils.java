package utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.FrameworkConstants;
import enums.ConfigJson;
import enums.ConfigProperties;
import exceptions.PropertyFileUsageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class JsonUtils {

    private JsonUtils(){}

    private static Map<String, String> CONFIGMAP;

    static {
        try {
            CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getJsonconfigfilepath()),
                    new TypeReference<HashMap<String,String>>() {});

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(ConfigJson key) {
        if (Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))) {
            throw new PropertyFileUsageException("Json key name " + key + " is not found. Please check config.json file");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
}
