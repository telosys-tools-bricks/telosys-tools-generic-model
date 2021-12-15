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
 * Enumeration for a boolean value
 * 
 * @author Laurent Guerin
 * @since 3.3.0
 *
 */
public enum BooleanValue {
	
	/**
	 * Undefined or not managed by the model implementation
	 */
	UNDEFINED(-1, "undefined"),
	
	/**
	 * 
	 */
	FALSE(0, "false"),
	
	/**
	 * 
	 */
	TRUE(1, "true");
	
	//---------------------------------------------------
	private final int    value ;
	private final String text  ;
	
	private BooleanValue(int value, String text) {
		this.value = value ;
		this.text  = text ;
	}
	
	/**
	 * Returns the value as an int <br>
	 * @return
	 */
	public int getValue() {
		return this.value ;
	}
	
	/**
	 * Returns the value as a text<br>
	 * e.g. : 'undefined', 'true', 'false'
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
}
