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
package org.telosys.tools.generic.model.enums;

/**
 * Enumeration for Generated Value Strategy
 * 
 * @author Laurent Guerin
 * @since 3.4.0
 *
 */
public enum GeneratedValueStrategy {
	UNDEFINED(0, ""),
	AUTO(1, "AUTO"),
	IDENTITY(2, "IDENTITY"),
	SEQUENCE(3, "SEQUENCE"),
	TABLE(4, "TABLE");
	
	//---------------------------------------------------
	private final int    value ;
	private final String text  ;
	
	private GeneratedValueStrategy(int value, String text) {
		this.value = value ;
		this.text  = text ;
	}
	
	/**
	 * Returns the strategy as an int value (0 to 4) <br>
	 * @return
	 */
	public int getValue() {
		return this.value ;
	}
	
	/**
	 * Returns the strategy as a text<br>
	 * e.g. : 'AUTO' or 'IDENTITY' or 'SEQUENCE' or 'TABLE'
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
}
