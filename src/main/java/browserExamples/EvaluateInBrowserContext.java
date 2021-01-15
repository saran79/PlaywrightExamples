package browserExamples;

import com.microsoft.playwright.*;


    public class EvaluateInBrowserContext {
        public static void main(String[] args) throws Exception {
            Playwright playwright = Playwright.create();
            BrowserType browserType = playwright.firefox();
            Browser browser = browserType.launch(new BrowserType.LaunchOptions().withHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();
            page.navigate("https://www.boots.com/");
            Object dimensions = page.evaluate("() => {\n" +
                    "  return {\n" +
                    "      width: document.documentElement.clientWidth,\n" +
                    "      height: document.documentElement.clientHeight,\n" +
                    "      deviceScaleFactor: window.devicePixelRatio\n" +
                    "  }\n" +
                    "}");
            System.out.println(dimensions);
            browser.close();
            playwright.close();
        }
    }

