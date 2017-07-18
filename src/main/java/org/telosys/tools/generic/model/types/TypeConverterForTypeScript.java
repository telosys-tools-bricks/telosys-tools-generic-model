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
 * Type converter for "TypeScript" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForTypeScript extends TypeConverter {

	public TypeConverterForTypeScript() {
		super();
		// cf : https://www.typescriptlang.org/docs/handbook/basic-types.html

		//--- Object types 
		declareObjectType( buildObjectType(NeutralType.STRING,    "String" ) );
		
		declareObjectType( buildObjectType(NeutralType.BOOLEAN,   "Boolean" ) );
		
		declareObjectType( buildObjectType(NeutralType.BYTE,      "Number" ) );
		declareObjectType( buildObjectType(NeutralType.SHORT,     "Number" ) );
		declareObjectType( buildObjectType(NeutralType.INTEGER,   "Number" ) );
		declareObjectType( buildObjectType(NeutralType.LONG,      "Number" ) );
		declareObjectType( buildObjectType(NeutralType.FLOAT,     "Number" ) );
		declareObjectType( buildObjectType(NeutralType.DOUBLE,    "Number" ) );
		declareObjectType( buildObjectType(NeutralType.DECIMAL,   "Number" ) );
		
		declareObjectType( buildObjectType(NeutralType.DATE,      "Date" ) );
		declareObjectType( buildObjectType(NeutralType.TIME,      "Date" ) );
		declareObjectType( buildObjectType(NeutralType.TIMESTAMP, "Date" ) );

		//--- Object SQL types :
		// No specific SQL types 
		
		//--- Primitive types :
		declarePrimitiveType( buildPrimitiveType(NeutralType.STRING,  "string",  "String"  ) );
		
		declarePrimitiveType( buildPrimitiveType(NeutralType.BOOLEAN, "boolean", "Boolean" ) );
		
		declarePrimitiveType( buildPrimitiveType(NeutralType.BYTE,    "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.SHORT,   "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.INTEGER, "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.LONG,    "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.FLOAT,   "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DOUBLE,  "number",  "Number"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DECIMAL, "number",  "Number"  ) );
		
		// DATE => No primitive type
		// TIME => No primitive type
		// TIMESTAMP => No primitive type
		// BINARY => No primitive type
		//declarePrimitiveType( buildPrimitiveType(NeutralType.DATE,      "any",     "any"   ) );
		//declarePrimitiveType( buildPrimitiveType(NeutralType.TIME,      "any",     "any"   ) );
		//declarePrimitiveType( buildPrimitiveType(NeutralType.TIMESTAMP, "any",     "any"   ) );
		//declarePrimitiveType( buildPrimitiveType(NeutralType.BINARY,    "any",     "any"   ) );
		
		//--- Unsigned primitive types : 
		// No unsigned types
//		declarePrimitiveUnsignedType(NeutralType.SHORT,   buildPrimitiveType("ushort", "System.UInt16" ) );
		
	}

	private LanguageType buildPrimitiveType(String neutralType, String primitiveType, String wrapperType) {
		return new LanguageType(neutralType, primitiveType,  primitiveType, true, wrapperType );
	}

	private LanguageType buildObjectType(String neutralType, String objectType) {
		// simple type = full type = wrapper type
		return new LanguageType( neutralType, objectType, objectType, false, objectType );
	}

	@Override
	public LanguageType getType(AttributeTypeInfo attributeTypeInfo) {
		log("type info : " + attributeTypeInfo );
		
		// @UnsignedType, @SqlType, @NotNull are not supported in TypeScript

		//--- 1) Process explicit requirements first (if any)
		if ( attributeTypeInfo.isPrimitiveTypeExpected() ) {
			// A primitive type is explicitly required ( @PrimitiveType )
			LanguageType lt = getPrimitiveType(attributeTypeInfo.getNeutralType() ) ;
			if ( lt != null ) {
				// FOUND
				log("1) primitive type found" );
				return lt ;
			}
		}
		else if ( attributeTypeInfo.isObjectTypeExpected() ) {
			// An object type is explicitly required ( @ObjectType )
			LanguageType lt = getObjectType(attributeTypeInfo.getNeutralType() ) ;
			if ( lt != null ) {
				// FOUND
				log("1) object type found" );
				return lt ;
			}
		}

		// By default return the primitive type or object type if no primitive type
		LanguageType lt = getPrimitiveType(attributeTypeInfo.getNeutralType() ) ;
		if ( lt == null ) {
			lt = getObjectType(attributeTypeInfo.getNeutralType() ) ;
		}
		return lt ;
	}

}
