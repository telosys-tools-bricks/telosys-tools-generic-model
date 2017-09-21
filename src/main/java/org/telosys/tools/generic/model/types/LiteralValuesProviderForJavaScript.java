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
package org.telosys.tools.generic.model.types;

/**
 * Literal values provider for "JAVASCRIPT" language
 * 
 * @author Laurent GUERIN
 *
 */
public class LiteralValuesProviderForJavaScript extends LiteralValuesProvider {

	private final static String NULL_LITERAL  = "null" ; 
	private final static String TRUE_LITERAL  = "true" ; 
	private final static String FALSE_LITERAL = "false" ; 
	
	@Override
	public String getLiteralNull() {
		return NULL_LITERAL;
	}
	
	@Override
	public String generateLiteralValue(LanguageType languageType, int maxLength, int step) {
		
		// For "JavaScript", the "neutral type" is the only information available in "LanguageType"
		String neutralType = languageType.getNeutralType(); 
		
		//--- STRING
		if ( NeutralType.STRING.equals(neutralType) ) {
			return "\"" + buildStringValue(maxLength, step) + "\"" ;
		}
		
		//--- BYTE
		else if ( NeutralType.BYTE.equals(neutralType) ) {
			return "" + checkThreshold(step, Byte.MAX_VALUE) ;  
		}
		
		//--- SHORT
		else if ( NeutralType.SHORT.equals(neutralType) ) {
			return "" + checkThreshold(step, Short.MAX_VALUE) ;
		}
		
		//--- INT		
		else if ( NeutralType.INTEGER.equals(neutralType)  ) {
			return "" + (step*100);
		}
		
		//--- LONG
		else if ( NeutralType.LONG.equals(neutralType)  ) {
			return "" + (step*1000) ;
		}
		
		//--- FLOAT
		else if ( NeutralType.FLOAT.equals(neutralType)  ) {
			return (step*1000) + ".5" ;
		}
		
		//--- DOUBLE
		else if ( NeutralType.DOUBLE.equals(neutralType) ) {
			return (step*1000) + ".66" ;
		}
		
		//--- BIG DECIMAL
		else if ( NeutralType.DECIMAL.equals(neutralType) ) {
			return (step*10000) + ".77" ;
		}
		
		//--- BOOLEAN
		else if ( NeutralType.BOOLEAN.equals(neutralType)  ) {
			return step % 2 != 0 ? TRUE_LITERAL : FALSE_LITERAL ;
		}

//		//--- DATE, TIME and TIMESTAMP :  there is no Date literal in JavaScript !
//		else if ( NeutralType.DATE.equals(neutralType)  ) {
//			return NULL_LITERAL ;
//		}
//		else if ( NeutralType.TIME.equals(neutralType)  ) {
//			return NULL_LITERAL ;
//		}
//		else if ( NeutralType.TIMESTAMP.equals(neutralType)  ) {
//			return NULL_LITERAL ;
//		}		
//		//--- BINARY
//		else if ( NeutralType.BINARY.equals(neutralType)  ) {
//			return NULL_LITERAL ;
//		}
		
		return NULL_LITERAL ; 
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
