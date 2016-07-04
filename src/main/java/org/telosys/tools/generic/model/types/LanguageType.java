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

/**
 * Language type with its simple/basic type and full type if any <br>
 * The simple and full type have the same value if there's no notion of "package", "namespace", etc <br>
 * Examples : <br>
 * For Java language : "String" and "java.lang.String" or "short" and "short" <br>
 * For c# language : "Int16" and "System.Int16"<br>
 * etc <br>
 * 
 * @author Laurent Guerin
 *
 */
public class LanguageType {

	private final String simpleType ;

	private final String fullType ;

	private final boolean isPrimitiveType ;

	/**
	 * Constructor
	 * @param simpleType
	 * @param fullType
	 * @param isPrimitiveType
	 */
	public LanguageType(String simpleType, String fullType, boolean isPrimitiveType) {
		super();
		this.simpleType = simpleType;
		this.fullType = fullType;
		this.isPrimitiveType = isPrimitiveType;
	}

	/**
	 * Returns the 'simple type' name <br>
	 * e.g. 'Long' for a Java 'java.lang.Long' type <br>
	 * or 'long' for a Java primitive type (same name for simple and full name ) <br>
	 * @return
	 */
	public String getSimpleType() {
		return simpleType;
	}

	/**
	 * Returns the 'full type' name <br>
	 * e.g. 'java.lang.Long' in Java <br>
	 * or 'long' for a Java primitive type (same name for simple and full name ) <br>
	 * @return
	 */
	public String getFullType() {
		return fullType;
	}

	/**
	 * Returns true if the type is a primitive type (  e.g. 'long' in Java )
	 * @return
	 */
	public boolean isPrimitiveType() {
		return isPrimitiveType;
	}

	@Override
	public String toString() {
		String s = isPrimitiveType() ? "PRIMITIVE-TYPE" : "OBJECT-TYPE" ;
		return "LanguageType : '" + simpleType + "', '"	+ fullType + "' " + s ;
	}
}
