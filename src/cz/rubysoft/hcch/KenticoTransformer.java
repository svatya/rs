package cz.rubysoft.hcch;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class KenticoTransformer {
	private static Configuration freemarkerCfg;
	private static class SingletonHolder {
		private static final KenticoTransformer INSTANCE = new KenticoTransformer();
	}
	
	private KenticoTransformer() {
		freemarkerCfg = new Configuration(Configuration.VERSION_2_3_25);

		try {
			File test = new File("./templates");
			test.getAbsolutePath();
			freemarkerCfg.setDirectoryForTemplateLoading(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		freemarkerCfg.setDefaultEncoding("UTF-8");
		freemarkerCfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		freemarkerCfg.setLogTemplateExceptions(false);
	}
	
	public static KenticoTransformer theTransformer() {
		return SingletonHolder.INSTANCE;
	}
	
	
	public String transform(String jsonDefinition, String templateName) throws TemplateException, IOException {
		Template template = freemarkerCfg.getTemplate(templateName);

		Map root = new HashMap();
        root.put("kentico", jsonDefinition);
        
		StringWriter stringWriter = new StringWriter();
		template.process(root, stringWriter);
		
		stringWriter.close();
		
		return stringWriter.toString();
		
	}
}
