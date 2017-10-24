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

import java.util.HashMap;

import org.telosys.tools.commons.TelosysToolsLogger;
import org.telosys.tools.commons.logger.ConsoleLogger;
import org.telosys.tools.generic.model.Attribute;

/**
 * Abstract type converter <br>
 * Each implementation converts a "neutral type" to a specific "language type" 
 *  
 * @author Laurent GUERIN
 *
 */
public abstract class TypeConverter {
	
	private final static boolean log = false ;
	private final static TelosysToolsLogger logger = new ConsoleLogger();
	protected void log(String msg) {
		if ( log ) {
			logger.log(this, msg);
		}
	}

	private final HashMap<String, LanguageType> primitiveTypes         = new HashMap<String, LanguageType>();
	private final HashMap<String, LanguageType> primitiveUnsignedTypes = new HashMap<String, LanguageType>();
	
	private final HashMap<String, LanguageType> objectTypes         = new HashMap<String, LanguageType>();
	private final HashMap<String, LanguageType> objectSqlTypes      = new HashMap<String, LanguageType>();
		
	/**
	 * Declares a regular primitive type
	 * @param languageType
	 */
	protected void declarePrimitiveType(LanguageType languageType) {
		primitiveTypes.put(languageType.getNeutralType(), languageType);
	}
	
	/**
	 * Declares an unsigned primitive type
	 * @param languageType
	 */
	protected void declarePrimitiveUnsignedType(LanguageType languageType) {
		primitiveUnsignedTypes.put(languageType.getNeutralType(), languageType);
	}
	
	/**
	 * Declares a regular object type
	 * @param languageType
	 */
	protected void declareObjectType(LanguageType languageType) {
		objectTypes.put(languageType.getNeutralType(), languageType);
	}
	
	/**
	 * Declares a SQL object type
	 * @param languageType
	 */
	protected void declareObjectSqlType(LanguageType languageType) {
		objectSqlTypes.put(languageType.getNeutralType(), languageType);
	}
	
	//--------------------------------------------------------------------------------------------
	// Get "PRIMITIVE TYPE" with or without "unsigned" option
	//--------------------------------------------------------------------------------------------
	/**
	 * Returns a primitive type for the given neutral type (or null if none)
	 * @param neutralType
	 * @return
	 */
	protected LanguageType getPrimitiveType(String neutralType ) {
		// Try to get a regular primitive type
		return primitiveTypes.get(neutralType);
	}
	
	/**
	 * Returns a primitive type for the given neutral type (or null if none)
	 * @param neutralType
	 * @param isUnsignedTypeExpected
	 * @return
	 */
	protected LanguageType getPrimitiveType(String neutralType, boolean isUnsignedTypeExpected ) {
		if ( isUnsignedTypeExpected ) {
			// Try to get an unsigned primitive type
			LanguageType lt = primitiveUnsignedTypes.get(neutralType);
			if ( lt != null ) {
				// unsigned type FOUND
				return lt ;
			}
			else {
				// unsigned type NOT FOUND => try to get a regular primitive type
				return primitiveTypes.get(neutralType);
			}
		}
		else {
			// Try to get a regular primitive type
			return primitiveTypes.get(neutralType);
		}
	}
	
	//--------------------------------------------------------------------------------------------
	// Get "OBJECT TYPE" with or without "SQL TYPE" option
	//--------------------------------------------------------------------------------------------
	/**
	 * Returns an object type for the given neutral type (or null if none)
	 * @param neutralType
	 * @return
	 */
	protected LanguageType getObjectType(String neutralType ) {
		// Try to get a regular object type
		return objectTypes.get(neutralType);
	}

	/**
	 * Returns an object type for the given neutral type (or null if none)
	 * @param neutralType
	 * @param isSqlTypeExpected
	 * @return
	 */
	protected LanguageType getObjectType(String neutralType, boolean isSqlTypeExpected ) {
		if ( isSqlTypeExpected ) {
			// Try to get a SQL object type
			LanguageType lt = objectSqlTypes.get(neutralType);
			if ( lt != null ) {
				// SQL type FOUND
				return lt ;
			}
			else {
				// SQL type NOT FOUND => try to get a regular object type
				return objectTypes.get(neutralType);
			}
		}
		else {
			// Try to get a regular object type
			return objectTypes.get(neutralType);
		}
	}
	
	//--------------------------------------------------------------------------------------------
	// Get type for attribute or attribute info 
	//--------------------------------------------------------------------------------------------
	/**
	 * Returns the LanguageType that suits as well as possible with the given type information
	 * @param attributeTypeInfo
	 * @return 
	 */
	public abstract LanguageType getType(AttributeTypeInfo attributeTypeInfo) ;
	
	/**
	 * Returns the LanguageType that suits as well as possible with the given attribute's characteristics
	 * @param attribute
	 * @return
	 */
	public final LanguageType getType(Attribute attribute) {		
		AttributeTypeInfo attributeTypeInfo = new AttributeTypeInfo(attribute);
		return getType(attributeTypeInfo);
	}
}
