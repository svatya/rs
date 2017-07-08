package cz.rubysoft.hcch;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HcchTemplate {

    private String template;
    private List<String> variables;

    public HcchTemplate(String template) {
        setTemplate(template);
    }

    public List<String> getVariables() {
        return variables;
    }

    public String getTemplate() {
        return template;
    }

    private void setTemplate(String template) {
        this.template = template;

        variables = new ArrayList<String>();
        Matcher m = Pattern.compile("\\$\\{[^\\}]*\\}").matcher(template);
        while (m.find()) {
            variables.add(m.group());
        }
    }
}
