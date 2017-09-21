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
 * Abstract literal values provider
 * 
 * @author Laurent GUERIN
 *
 */
public abstract class LiteralValuesProvider {
	
	/**
	 * Ensures the value is always less than or equal at the given threshold 
	 * @param value
	 * @param max
	 * @return
	 */
	protected int checkThreshold(int value, int max) {
		if ( value <= max ) {
			// OK ( 0 to MAX )
			return value ;
		}
		else {
			int modulo = value % max ;
			if ( modulo == 0 ) {
				return max ;
			}
			else {
				return modulo ;
			}
		}
	}
	
	/**
	 * Builds a string with the given length 
	 * @param maxLength
	 * @param step the step used for randomization
	 * @return
	 */
	protected String buildStringValue(int maxLength, int step) {
		int maxLimit = 100 ;
		// 'A'-'Z' : 65-90 
		// 'a'-'z' : 97-122 
		char c = 'A' ; 
		if ( step > 0 ) {
			int delta = (step-1) % 26;
			c = (char)('A' + delta );
		}
		StringBuilder sb = new StringBuilder();
		for ( int i = 0 ; i < maxLength && i < maxLimit ; i++) {
			sb.append(c);
		}
		return sb.toString();
	}

	//------------------------------------------------------------------------------------
	// ABSTRACT METHODS
	//------------------------------------------------------------------------------------

	/**
	 * Returns the literal 'null' for the current language
	 * @return
	 */
	public abstract String getLiteralNull() ;

	/**
	 * Generates a literal value for the given language type <br>
	 * @param languageType
	 * @param maxLength
	 * @param step
	 * @return
	 */
	public abstract String generateLiteralValue(LanguageType languageType, int maxLength, int step) ;

	/**
	 * Returns the ad hoc equals statement for a given literal value according with the language type<br>
	 * Example in Java : <br>
	 *   ' == 100'  <br>
	 *   '.equals("abcd")' <br>
	 *   
	 * @param value
	 * @param languageType
	 * @return
	 */
	public abstract String getEqualsStatement(String value, LanguageType languageType) ;

}
