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
 * Enumeration for the different types of CASCADE 
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 *
 */
public enum CascadeOption {
	
	/**
	 * 
	 */
	MERGE(0, "MERGE", "M"),
	
	/**
	 * 
	 */
	PERSIST(1, "PERSIST", "P"),
	
	/**
	 * 
	 */
	REFRESH(2, "REFRESH", "REF"),
	
	/**
	 * 
	 */
	REMOVE(3, "REMOVE", "REM"),
		
	/**
	 * 
	 */
	ALL(4, "ALL", "A");
	
	//---------------------------------------------------
	private final int    value ;
	private final String longText  ;
	private final String shortText  ;
	
	private CascadeOption(int value, String longText, String shortText) {
		this.value = value ;
		this.longText  = longText ;
		this.shortText  = shortText ;
	}
	
	/**
	 * Returns the int value identifying the cascade option <br>
	 * @return
	 */
	public int getValue() {
		return this.value ;
	}
	
	/**
	 * Returns the text in long format<br>
	 * e.g. : 'MERGE', 'PERSIST', etc
	 * @return
	 */
	public String getLongText() {
		return this.longText;
	}

	/**
	 * Returns the text in short format<br>
	 * e.g. : 'M', 'P', 'REF', etc
	 * @return
	 */
	public String getShortText() {
		return this.shortText;
	}
}
