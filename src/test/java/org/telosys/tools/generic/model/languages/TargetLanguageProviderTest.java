package org.telosys.tools.generic.model.languages;

import org.junit.Test;
import org.telosys.tools.generic.model.languages.TargetLanguageProvider;

import static org.junit.Assert.assertNotNull;

public class TargetLanguageProviderTest  {

	private void check(String languageName) {
		assertNotNull( TargetLanguageProvider.getTargetLanguage(languageName) );
		assertNotNull( TargetLanguageProvider.getTargetLanguage(languageName).getTypeConverter() );
		assertNotNull( TargetLanguageProvider.getTargetLanguage(languageName).getLiteralValuesProvider() );
		assertNotNull( TargetLanguageProvider.getTypeConverter(languageName) );
		assertNotNull( TargetLanguageProvider.getLiteralValuesProvider(languageName) );
	}
	
	@Test
	public void testCPlusPlus() {
		check("C++");
		check(" c++");
	}

	@Test
	public void testCSharp() {
		check("C#");
		check(" c#");
	}

	@Test
	public void testGo() {
		check("Go");
		check(" go");
		check("GO ");
	}

	@Test
	public void testJava() {
		check("Java");
		check(" java");
		check("JAVA  ");
	}

	@Test
	public void testJavaScript() {
		check("JavaScript");
		check(" javascript");
		check("JAVASCRIPT  ");
	}

	@Test
	public void testPHP() {
		check("PHP");
		check(" Php");
		check("php ");
	}

	@Test
	public void testPython() {
		check("PYTHON");
		check(" Python");
		check("python ");
	}

	@Test
	public void testScala() {
		check("SCALA");
		check(" Scala");
		check("scala ");
	}

	@Test
	public void testTypeScript() {
		check("TypeScript");
		check(" typescript");
		check("TYPESCRIPT  ");
	}
}
