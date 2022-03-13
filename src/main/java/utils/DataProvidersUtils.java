package utils;

import constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public final class DataProvidersUtils {

    private DataProvidersUtils(){}

    private static List<Map<String,String>> list = new ArrayList<>();

    @DataProvider(name = "getTestData" ,parallel = true)
    public static Object[] getData(Method m){
        String testname = m.getName();

        if(list.isEmpty()){
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDatasheet());
            System.out.println(list);
        }
        List<Map<String, String>> smallList = new ArrayList<>(list);

        Predicate<Map<String,String>> isTestNameNotMatching = map ->!map.get("testname").equalsIgnoreCase(testname);
        Predicate<Map<String,String>> isExecuteColumnNo = map -> map.get("execute").equalsIgnoreCase("no");

        smallList.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));
        return smallList.toArray();
    }
}
