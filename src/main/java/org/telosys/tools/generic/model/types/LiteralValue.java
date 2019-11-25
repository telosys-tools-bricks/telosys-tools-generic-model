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
 * Literal value 
 * 
 * @author Laurent GUERIN
 *
 */
public class LiteralValue {
	
	private final String currentLanguageValue ;

	private final Object basicValue ;

	/**
	 * Constructor
	 * @param currentLanguageValue
	 * @param basicValue
	 */
	public LiteralValue(String currentLanguageValue, Object basicValue) {
		super();
		this.currentLanguageValue = currentLanguageValue;
		this.basicValue = basicValue;
	}

	/**
	 * Returns the literal value adapted for the current target language 
	 * @return
	 */
	public String getCurrentLanguageValue() {
		return currentLanguageValue;
	}

	/**
	 * Returns the basic value used to build the literal value <br>
	 * Object types examples : String, Integer, Long, BigDecimal, Boolean (or null)
	 * @return
	 */
	public Object getBasicValue() {
		return basicValue;
	}

	@Override
	public String toString() {
		// returns the original single value for backward compatibility
		return currentLanguageValue ;
	}
	
}
