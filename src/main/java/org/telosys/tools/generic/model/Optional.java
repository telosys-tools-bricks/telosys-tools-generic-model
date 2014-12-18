/**
 *  Copyright (C) 2008-2014  Telosys project org. ( http://www.telosys.org/ )
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
package org.telosys.tools.generic.model;

/**
 * Enumeration for the different types of OPTIONAL 
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 *
 */
public enum Optional {
	
	/**
	 * Undefined or not managed by the model implementation
	 */
	UNDEFINED(0, "undefined"),
	
	/**
	 * 
	 */
	TRUE(1, "true"),
	
	/**
	 * 
	 */
	FALSE(2, "false");
		
	//---------------------------------------------------
	private final int    value ;
	private final String text  ;
	
	private Optional(int value, String text) {
		this.value = value ;
		this.text  = text ;
	}
	
	/**
	 * Returns the 'optional' type as an int value (0 to 2) <br>
	 * @return
	 */
	public int getValue() {
		return this.value ;
	}
	
	/**
	 * Returns the 'optional' type as a text<br>
	 * e.g. : 'true' or 'false' or 'undefined'
	 * @return
	 */
	public String getText() {
		return this.text;
	}
}
