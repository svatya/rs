import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import cz.rubysoft.hcch.HcchTemplate;
import cz.rubysoft.hcch.KenticoTransformer;

public class Test {
    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void main(String[] args) throws Exception {

        /* ------------------------------------------------------------------------ */
        /* You should do this ONLY ONCE in the whole application life-cycle: */

        /* Create and adjust the configuration singleton */
        // Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
        // cfg.setDirectoryForTemplateLoading(new File("./templates"));
        // cfg.setDefaultEncoding("UTF-8");
        // cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        // cfg.setLogTemplateExceptions(false);

        /* ------------------------------------------------------------------------ */
        /* You usually do these for MULTIPLE TIMES in the application life-cycle: */

        /* Create a data-model */
        // Map root = new HashMap();
        //
        //
        //
        //
        // root.put("user", "Big Joe");
        // Product latest = new Product();
        // latest.setUrl("products/greenmouse.html");
        // latest.setName("green mouse");
        // root.put("latestProduct", latest);

        String fileAsString = readFile("kentico_message.json", StandardCharsets.UTF_8);

        HcchTemplate result = KenticoTransformer.theTransformer().transform(fileAsString, "message.ftl");

        System.out.println(result.getTemplate());

        // root.put("jsonTest", fileAsString);
        // /* Get the template (uses cache internally) */
        // Template temp = cfg.getTemplate("test.ftl");
        //
        // /* Merge data-model with template */
        // Writer out = new OutputStreamWriter(System.out);
        // temp.process(root, out);
        // // Note: Depending on what `out` is, you may need to call `out.close()`.
        // // This is usually the case for file output, but not for servlet output.
    }
}