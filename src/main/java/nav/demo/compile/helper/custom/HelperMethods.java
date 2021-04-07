package nav.demo.compile.helper.custom;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class HelperMethods {

	public static void main(String[] args) {
		
		System.out.println(whenHelperSourceIsCreated_ThenCanRegister());
	}
	
	public static class HelperSource {
		
	    public String isBusy(Person context) {
	        String busyString = context.isBusy() ? "busy" : "available";
	        return context.getName() + " - " + busyString;
	    }
	}
	
	public static String whenHelperSourceIsCreated_ThenCanRegister() {
		TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars(templateLoader);
	    handlebars.registerHelpers(new HelperSource());
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("person");
		    Person person = new Person("Devendra");
		    person.setBusy(false);
		    
		    templateString = template.apply(person);
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	}

}
