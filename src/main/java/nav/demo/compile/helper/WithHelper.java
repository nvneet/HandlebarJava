package nav.demo.compile.helper;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class WithHelper {

	public static void main(String[] args) {
		
		System.out.println(whenUsedWith_ThenContextChanges());
	}
	
	public static String whenUsedWith_ThenContextChanges() {
		TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars(templateLoader);
	    String templateString = null;
	    
	    try {
		    Template template = handlebars.compile("with");
		    Person person = new Person("Kamlesh");
		    person.getAddress().setStreet("World");
		    
		    templateString = template.apply(person);
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	}

}
