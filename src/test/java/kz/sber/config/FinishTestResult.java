package kz.sber.config;

import io.qameta.allure.TmsLink;
import kz.sber.NameOfOperationOrFunctionality_Test;
import org.json.JSONObject;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import java.io.FileWriter;
import java.io.IOException;

public class FinishTestResult implements TestWatcher {

    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        System.out.println("TEST RESULT - FAILURE");
        String keyTestCase;
        String methodAndClassNameWithPackage = NameOfOperationOrFunctionality_Test.class.getName() + "." + NameOfOperationOrFunctionality_Test.class.getDeclaredMethods()[0].getName();
        try {
            keyTestCase = NameOfOperationOrFunctionality_Test.class.getMethod(NameOfOperationOrFunctionality_Test.class.getDeclaredMethods()[0].getName()).getAnnotation(TmsLink.class).value();
            if (!keyTestCase.isEmpty()) {
                System.out.println("Test Case key @TmsLink:  " + keyTestCase);
                generateJson(methodAndClassNameWithPackage, "Failed", keyTestCase);
            } else {
                System.out.println("Test Case key @TmsLink is empty:  " + keyTestCase);
                System.out.println("The file \"zephyrscale_result.json\" was not created!\n");
            }
        } catch (NoSuchMethodException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void testSuccessful(ExtensionContext extensionContext) {
        System.out.println("TEST RESULT - SUCCESS");
        String keyTestCase;
        String methodAndClassNameWithPackage = NameOfOperationOrFunctionality_Test.class.getName() + "." + NameOfOperationOrFunctionality_Test.class.getDeclaredMethods()[0].getName();
        try {
            keyTestCase = NameOfOperationOrFunctionality_Test.class.getMethod(NameOfOperationOrFunctionality_Test.class.getDeclaredMethods()[0].getName()).getAnnotation(TmsLink.class).value();
            if (!keyTestCase.isEmpty()) {
                System.out.println("Test Case key @TmsLink:  " + keyTestCase);
                generateJson(methodAndClassNameWithPackage, "Passed", keyTestCase);
            } else {
                System.out.println("Test Case key @TmsLink is empty:  " + keyTestCase);
                System.out.println("The file \"zephyrscale_result.json\" was not created!\n");
            }
        } catch (NoSuchMethodException | IOException e) {
            e.printStackTrace();
        }
    }

    public void generateJson(String source, String result, String testCaseKey) throws IOException {
        JSONObject jo = new JSONObject(
                "{\"version\":1,\"executions\":[{\"source\":\"" + source + "\",\"result\":\"" + result + "\",\"testCase\":{\"key\":\"" + testCaseKey + "\"}}]}"
        );
        System.out.println("zephyrscale_result.json: " + jo);
        FileWriter jsonFile = new FileWriter("zephyrscale_result.json");
        jsonFile.write(jo.toString());
        jsonFile.close();
        System.out.println("\nJSON file \"zephyrscale_result.json\" created successfully!\n");
    }
}
