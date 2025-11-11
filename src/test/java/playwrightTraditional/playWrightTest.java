package playwrightTraditional;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.*;

class playWrightTest {
/*
    @BeforeAll
    static void settingUpBrowser()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
    }

    @AfterAll
    static void closeBrowser()
    {
        playwright.close();
    }
*/
    @Test
    void barnesAndNobleWebsiteTest(){
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(true));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos/"))
                    .setRecordVideoSize(1280, 720));
            Page page = context.newPage();
            page.navigate("https://depaul.bncollege.com/");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("earbuds");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
            page.getByText("brand JBL").first().click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
            page.getByText("Color Black").click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
            page.getByText("Price Over $").click();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();
            assertThat(page.getByLabel("main").getByRole(AriaRole.HEADING)).containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
            assertThat(page.getByLabel("main")).containsText("668972707");
            assertThat(page.getByLabel("main")).containsText("$164.98");
            assertThat(page.getByLabel("main")).containsText("Adaptive noise cancelling allows awareness of environment when gaming on the go. Light weight, durable, water resist. USB-C dongle for low latency connection < than 30ms.");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();
            assertThat(page.locator("#headerDesktopView")).containsText("1 items");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();
            assertThat(page.getByLabel("main")).containsText("Your Shopping Cart");
            assertThat(page.getByLabel("main")).containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
            assertThat(page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Quantity, edit and press"))).hasValue("1");
            assertThat(page.getByLabel("main")).containsText("$164.98");
            page.getByText("FAST In-Store PickupDePaul").click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).fill("TEST");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Promo Code")).click();
            assertThat(page.locator("#js-voucher-result")).containsText("The coupon code entered is not valid.");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed To Checkout")).first().click();
            assertThat(page.getByLabel("main")).containsText("Create Account");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();
            assertThat(page.getByLabel("main")).containsText("Contact Information");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("John");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).press("Tab");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("Smith");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).fill("test@example.com");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).fill("7732020450");
            assertThat(page.getByLabel("main")).containsText("$164.98");
            assertThat(page.getByLabel("main")).containsText("$3.00");
            assertThat(page.getByLabel("main")).containsText("TBD");
            assertThat(page.getByLabel("main")).containsText("$167.98");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            assertThat(page.getByLabel("main")).containsText("John");
            assertThat(page.getByLabel("main")).containsText("Smith");
            assertThat(page.getByLabel("main")).containsText("test@example.com");
            assertThat(page.getByLabel("main")).containsText("17732020450");
            assertThat(page.locator("#bnedPickupPersonForm")).containsText("DePaul University Loop Campus & SAIC");
            assertThat(page.locator("#bnedPickupPersonForm")).containsText("I'll pick them up");
            assertThat(page.locator(".checkmark").first()).isVisible();
            assertThat(page.getByLabel("main")).containsText("$164.98");
            assertThat(page.getByLabel("main")).containsText("$3.00");
            assertThat(page.getByLabel("main")).containsText("TBD");
            assertThat(page.getByLabel("main")).containsText("$167.98");
            assertThat(page.getByLabel("main")).containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
            assertThat(page.getByLabel("main")).containsText("$164.98");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();
            assertThat(page.getByLabel("main")).containsText("$164.98");
            assertThat(page.getByLabel("main")).containsText("$3.00");
            assertThat(page.getByLabel("main")).containsText("$17.22");
            assertThat(page.getByLabel("main")).containsText("$185.20");
            assertThat(page.getByLabel("main")).containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");
            assertThat(page.getByLabel("main")).containsText("$164.98");
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove product JBL Quantum")).click();
            assertThat(page.getByLabel("main").getByRole(AriaRole.HEADING)).containsText("Your cart is empty");
        }
    }
}