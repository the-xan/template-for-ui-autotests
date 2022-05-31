package kz.sber;

import io.qameta.allure.*;
import kz.sber.config.TestBase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static kz.sber.pages.SalaryProjectPage.CreateRequestForSalaryProjectPage;

@DisplayName("Bitbucket repository name")
@Feature("Module name")
@Tag("UI")
@Tag("Regress")
public class NameOfOperationOrFunctionality_Test extends TestBase {

    @Description(value = "Bitbucket repository description")
    @Severity(value = CRITICAL)
    @Story("Bitbucket repository name")
    @Issue("Jira issue key")
    @TmsLink("Test case key")
    @Test
    public void DEMO_T4() {
        CreateRequestForSalaryProjectPage();
    }
}
