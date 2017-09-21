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
package org.telosys.tools.generic.model;

/**
 * Enumeration for the different types of date
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 *
 */
public enum DateType {
	
	/**
	 * Undefined or not managed by the model implementation
	 */
	UNDEFINED(0),
	
	/**
	 * Date information only (no time)
	 */
	DATE_ONLY(1),
	
	/**
	 * Time information only (no date)
	 */
	TIME_ONLY(2),
	
	/**
	 * Date and time information
	 */
	DATE_AND_TIME(3);
	
	//---------------------------------------------------
	private int value ;
	
	private DateType(int value) {
		this.value = value ;
	}
	
	public int getValue() {
		return this.value ;
	}
}
