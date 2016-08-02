/**
 *  Copyright (C) 2008-2015  Telosys project org. ( http://www.telosys.org/ )
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

public interface LiteralValuesProvider {
	
	/**
	 * Returns the literal 'null' for the current language
	 * @return
	 */
	public String getLiteralNull() ;

	/**
	 * Generates a literal value for the given language type <br>
	 * @param languageType
	 * @param maxLength
	 * @param step
	 * @return
	 */
	public String generateLiteralValue(LanguageType languageType, int maxLength, int step) ;

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
	public String getEqualsStatement(String value, LanguageType languageType) ;

}
