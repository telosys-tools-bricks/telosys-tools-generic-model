/**
 *  Copyright (C) 2008-2017  Telosys project org. ( http://www.telosys.org/ )
 *
 *  Licensed under the GNU LESSER GENERAL PUBLIC LICENSE, Version 3.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.gnu.org/licenses/lgpl.html
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.telosys.tools.generic.model.languages.literals;

import java.math.BigDecimal;

import org.telosys.tools.generic.model.languages.types.LanguageType;
import org.telosys.tools.generic.model.types.NeutralType;

/**
 * Literal values provider for "SCALA" language
 * 
 * @author Laurent GUERIN
 *
 */
public class LiteralValuesProviderForScala extends LiteralValuesProvider {
	
	private static final String NULL_LITERAL  = "null" ;   // acceptable to the compiler but discouraged
	// "null" is not supposed to be used in Scala
	// see https://docs.scala-lang.org/overviews/scala-book/no-null-values.html
	// Scala’s solution is to use constructs like the Option/Some/None classes
	// "None" y: Option[Int] = None
	
	private static final String TRUE_LITERAL  = "true" ;   // Example : b1: Boolean = true 
	private static final String FALSE_LITERAL = "false" ;  // Example : b2: Boolean = false 
	
	@Override
	public String getLiteralNull() {
		return NULL_LITERAL;
	}
	
	@Override
	public String getLiteralTrue() {
		return TRUE_LITERAL;
	}

	@Override
	public String getLiteralFalse() {
		return FALSE_LITERAL;
	}
			
	@Override
	public LiteralValue generateLiteralValue(LanguageType languageType, int maxLength, int step) {
		
		String neutralType = languageType.getNeutralType(); 

		//--- STRING
		if ( NeutralType.STRING.equals(neutralType) ) {
			String value = buildStringValue(maxLength, step);
			return new LiteralValue("\"" + value + "\"", value) ;			
		}
		
		//--- NUMBER / INTEGER
		else if (  NeutralType.BYTE.equals(neutralType) 
				|| NeutralType.SHORT.equals(neutralType)
				|| NeutralType.INTEGER.equals(neutralType) 
				|| NeutralType.LONG.equals(neutralType) ) {
			Long value = buildIntegerValue(neutralType, step);  
			return new LiteralValue(value.toString(), value) ; // eg : 123
		}
		
		//--- NUMBER (NOT INTEGER)
		else if (  NeutralType.FLOAT.equals(neutralType) 
				|| NeutralType.DOUBLE.equals(neutralType) 
				|| NeutralType.DECIMAL.equals(neutralType) ) {
			BigDecimal value = buildDecimalValue(neutralType, step);
			return new LiteralValue(value.toString(), value) ; // eg :  123.77
		}

		//--- BOOLEAN
		else if ( NeutralType.BOOLEAN.equals(neutralType)  ) {
			boolean value = buildBooleanValue(step);
			return new LiteralValue(value ? TRUE_LITERAL : FALSE_LITERAL, Boolean.valueOf(value)) ;
		}

		//--- DATE, TIME and TIMESTAMP : 
		else if ( NeutralType.DATE.equals(neutralType)  ) {
			return generateJavaLocalDateLiteralValue(step) ;
		}
		else if ( NeutralType.TIME.equals(neutralType)  ) {
			return generateJavaLocalTimeValue(step)  ;
		}
		else if ( NeutralType.TIMESTAMP.equals(neutralType)  ) {
			return generateJavaLocalDateTimeValue(step) ;
		}
		
		//--- No literal value for BINARY
		
		return new LiteralValue(NULL_LITERAL, null);
	}
	
	private int generateYearValue(int step) {
		return 2000 + ( step % 1000 ) ;  // between 2000 and 2999 
	}
	private LiteralValue generateJavaLocalDateLiteralValue(int step) {
		int year = generateYearValue(step);
		int month = 6;
		int dayOfMonth = 22;
		String s = "java.time.LocalDate.of(" + year + "," + month + "," + dayOfMonth + ")";
		
		return new LiteralValue(s, null) ; // null : no basic value for JSON, URL
	}
	private LiteralValue generateJavaLocalTimeValue(int step) {
		int hour = step % 24 ;
		int minute = 46 ;
		int second = 52 ;
		String s = "java.time.LocalTime.of(" + hour + "," + minute + "," + second + ")";
		return new LiteralValue(s, null) ;  // null : no basic value for JSON, URL
	}
	private LiteralValue generateJavaLocalDateTimeValue(int step) {
		int year = generateYearValue(step);
		int month = 5;
		int dayOfMonth = 21;
		int hour = step % 24 ;
		int minute = 46 ;
		int second = 52 ;
		String s = "java.time.LocalDateTime.of(" + year + "," + month + "," + dayOfMonth + ","
				+ hour + "," + minute + "," + second + ")";
		return new LiteralValue(s, null) ;  // null : no basic value for JSON, URL		
	}

	/* 
	 * Returns something like that : 
	 *   ' == 100' 
	 *   '.equals("xxx")'
	 */
	@Override
	public String getEqualsStatement(String value, LanguageType languageType) {

		// Always "==" ( whatever the type ) 
		return " == " + value ;
	}
}
