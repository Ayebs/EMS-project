package kowri.java.emsbackend;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class EmsBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmsBackendApplication.class, args);

		//Dynamic loading and execution of Groovy code
		loadAndExecuteGroovyScript();
	}

	private static void loadAndExecuteGroovyScript() {

		/*Groovy script - if going with this, you'll pass the name of this script
		as a parameter to the parseClass()
		*/
//		String groovyScript = "class GroovyTestClass { " +
//				"    void sayHello() { " +
//				"        println 'Hello from Groovy World!' " +
//				"    } " +
//				"}";

		//instantiating the class loader
		GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

	try {
		//compiling & loading
		Class<?> groovyClass = groovyClassLoader.parseClass(new File("src/main/resources/ems.groovy"));

		//creating obj instance
		GroovyObject groovyObject = (GroovyObject) groovyClass.getDeclaredConstructor().newInstance();

		//invoking method
		groovyObject.invokeMethod("sayHello", null);
	} catch (Exception e) {
		e.printStackTrace();
	}

	}
}