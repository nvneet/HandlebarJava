package nav.demo.compile.helper.custom;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class PersonHelper {

	public static void main(String[] args) {

		System.out.println(whenHelperIsCreated_ThenCanRegister());
//		new Helper<Person>() {
//		    @Override
//		    public Object apply(Person context, Options options) throws IOException {
//		        String busyString = context.isBusy() ? "busy" : "available";
//		        return context.getName() + " - " + busyString;
//		    }
//		};

	}
	
	public static String whenHelperIsCreated_ThenCanRegister() {
		TemplateLoader templateLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars(templateLoader);
	    handlebars.registerHelper("isBusy", new Helper<Person>() {
	        @Override
	        public Object apply(Person context, Options options) throws IOException {
	            String busyString = context.isBusy() ? "busy" : "available";
	            return context.getName() + " - " + busyString;
	        }
	    });
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("person");
		    Person person = new Person("Devendra");
		    person.setBusy(true);
		    
		    templateString = template.apply(person);
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	    
	}
}
