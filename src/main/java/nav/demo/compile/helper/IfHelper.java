package nav.demo.compile.helper;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class IfHelper {

	public static void main(String[] args) {
		
		System.out.println(whenUsedIf_ThenPutsCondition());
	}
	
	public static String whenUsedIf_ThenPutsCondition() {
		TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars(templateLoader);
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("if");
		    Person person = new Person("Devendra");
		    person.setBusy(true);
		    
		    templateString = template.apply(person);
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	}

}
