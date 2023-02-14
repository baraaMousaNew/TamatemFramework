package com.dataprovider;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.lang.reflect.Method;

public class DataProviderClass {

    private static final String REGISTRATION = "src/test/java/com/datafiles/registration.json";

    public static JSONObject extractFromJSON (String file) throws Exception{
        FileReader reader = new FileReader(file);
        JSONParser jsonParser = new JSONParser();

        return (JSONObject) jsonParser.parse(reader);
    }
    @DataProvider
    public static Object[][] registrationCredentials (Method method) throws Exception{
        Object [] [] result;
        JSONObject object = (JSONObject) extractFromJSON(REGISTRATION).get("registration");
        object = (JSONObject) object.get("valid");
        result = new Object[1][object.size()];
        result[0] = new Object[]{object};
        return result;
     }
}
