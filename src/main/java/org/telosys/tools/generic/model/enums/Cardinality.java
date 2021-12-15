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
 * Enumeration for the different types of CARDINALITY : "OneToMany", "ManyToOne", "OneToOne", "ManyToMany" 
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 *
 */
public enum Cardinality {
	
	/**
	 * Undefined or not managed by the model implementation
	 */
	UNDEFINED(0, ""),
	
	/**
	 * 
	 */
	ONE_TO_MANY(1, "OneToMany"),
	
	/**
	 * 
	 */
	MANY_TO_ONE(2, "ManyToOne"),
	
	/**
	 * 
	 */
	ONE_TO_ONE(3, "OneToOne"),
	
	/**
	 * 
	 */
	MANY_TO_MANY(4, "ManyToMany");
	
	//---------------------------------------------------
	private final int    value ;
	private final String text  ;
	
	private Cardinality(int value, String text) {
		this.value = value ;
		this.text  = text ;
	}
	
	/**
	 * Returns the cardinality as an int value (0 to 4) <br>
	 * @return
	 */
	public int getValue() {
		return this.value ;
	}
	
	/**
	 * Returns the cardinality as a text<br>
	 * e.g. : 'OneToMany', 'ManyToOne', 'OneToOne', 'ManyToMany'
	 * @return
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Returns true if the cardinality is "MANY_TO_ONE" or "ONE_TO_ONE"
	 * @return
	 */
	public boolean isToOne() {
		if ( this == MANY_TO_ONE ) return true ;
		if ( this == ONE_TO_ONE ) return true ;
		return false ;
	}

	/**
	 * Returns true if the cardinality is "ONE_TO_MANY" or "MANY_TO_MANY"
	 * @return
	 */
	public boolean isToMany() {
		if ( this == ONE_TO_MANY ) return true ;
		if ( this == MANY_TO_MANY ) return true ;
		return false ;
	}
}
