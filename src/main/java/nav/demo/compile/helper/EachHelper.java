package nav.demo.compile.helper;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class EachHelper {

	public static void main(String[] args) {
		
		System.out.println(whenUsedEach_ThenIterates());

	}
	
	
	public static String whenUsedEach_ThenIterates() {
		TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars(templateLoader);
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("each");
		    Person person = new Person("Suresh");
		    Person friend1 = new Person("Java");
		    Person friend2 = new Person("Spring");
		    person.getFriends().add(friend1);
		    person.getFriends().add(friend2);
		    
		    templateString = template.apply(person);
		    
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	}
}
