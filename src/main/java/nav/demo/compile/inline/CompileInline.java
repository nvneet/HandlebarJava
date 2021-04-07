package nav.demo.compile.inline;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;

import nav.demo.model.Person;

public class CompileInline {
	
	public static void main (String[] args) {
//		String output = whenThereIsNoTemplateFile_ThenCompilesInline();
//		String output = whenParameterMapIsSupplied_thenDisplays();
		String output = whenParameterObjectIsSupplied_ThenDisplays();
		
		System.out.println(output);
	}
	
	/*
	 * pass a single String value to our template, we can use any Object as the context. 
	 * We must also use the {{this}} tag in our template. Then Handlebars calls the toString method 
	 * on the context object and replaces the tag with the result
	 */
	public static String whenThereIsNoTemplateFile_ThenCompilesInline() {
	    Handlebars handlebars = new Handlebars();
	    String templateString = null;
	    
		try {
			
			Template template = handlebars.compileInline("Hello {{this}}!");
			templateString = template.apply("Moustache-Handlebar");
			
		} catch (IOException e) {e.printStackTrace();
		}
		
	    return templateString;
	}
	
	//  Passing a Map as Context Object
	public static String whenParameterMapIsSupplied_thenDisplays() {
	    Handlebars handlebars = new Handlebars();
	    String templateString = null;
	    try {
	    	
	    	Template template = handlebars.compileInline("Hi {{name}}!");
	    	Map<String, String> parameterMap = new HashMap<>();
	    	parameterMap.put("name", "handlebar Map");
	    
	    	templateString = template.apply(parameterMap);
	    }catch (IOException e) {e.printStackTrace();
		}
	    return templateString;
	}
	
	public static String whenParameterObjectIsSupplied_ThenDisplays() {
	    Handlebars handlebars = new Handlebars();
	    String templateString = null;
	    
	    try {
	    
		    Template template = handlebars.compileInline("Hi {{name}}!");
		    Person person = new Person("Onkar");
		    person.setAddress(person.getAddress());
		    
		    templateString = template.apply(person);
	    }catch (IOException e) {e.printStackTrace();
		}
	    return templateString;
	}
}
