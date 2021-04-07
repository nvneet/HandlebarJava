package nav.demo.compile.classpath;

import java.io.IOException;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.github.jknack.handlebars.io.ClassPathTemplateLoader;
import com.github.jknack.handlebars.io.TemplateLoader;

import nav.demo.model.Person;

public class TemplateLoaders {

	public static void main(String[] args) {
		
//		System.out.println(whenNoLoaderIsGiven_ThenSearchesClasspath());
//		System.out.println(whenClasspathTemplateLoaderIsGiven_ThenSearchesClasspathWithPrefixSuffix());
		System.out.println(whenMultipleLoadersAreGiven_ThenSearchesSequentially());
	}
	
	/*
	 * support for reading templates from the classpath, filesystem or servlet context. 
	 * By default, Handlebars scans the classpath to load the given template.	 * 
	 */
	public static String whenNoLoaderIsGiven_ThenSearchesClasspath() {
	    Handlebars handlebars = new Handlebars();
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("greeting"); // looks for greeting.hbs in classpath
		    Person person = new Person("Shailesh");
		    
		    templateString = template.apply(person);
	    }catch (IOException e) {e.printStackTrace();
		}
	    
	    return templateString;
	}
	
	public static String whenClasspathTemplateLoaderIsGiven_ThenSearchesClasspathWithPrefixSuffix() {
	    TemplateLoader loader = new ClassPathTemplateLoader("/handlebars", ".html");
	    Handlebars handlebars = new Handlebars(loader);
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("greeting");
		    Person person = new Person("Shailesh");
	    
		    templateString = template.apply(person);
		    
	    }catch (IOException e) {e.printStackTrace(); }
    
	    return templateString;
	}
	
	/*
	 * chain multiple TemplateLoader instances. With two loaders Handlebars will search 
	 * two directories for the greeting template.
	*/
	public static String whenMultipleLoadersAreGiven_ThenSearchesSequentially() {
	    TemplateLoader firstLoader = new ClassPathTemplateLoader("/handlebars", ".html");
	    TemplateLoader secondLoader = new ClassPathTemplateLoader("/templates", ".html");
	    Handlebars handlebars = new Handlebars().with(firstLoader, secondLoader);
	    
	    String templateString = null;
	    try {
		    Template template = handlebars.compile("greeting");
		    Person person = new Person("Shailesh");
	    
		    templateString = template.apply(person);
		    
	    } catch (IOException e) {e.printStackTrace(); }
	    
	    return templateString;
	}
}
