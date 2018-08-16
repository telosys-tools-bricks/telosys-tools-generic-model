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
 * Type converter for "Go" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForGo extends TypeConverter {

	public TypeConverterForGo() {
		super();
		
		//--- Primitive types :
		declarePrimitiveType( buildPrimitiveType(NeutralType.STRING,   "string",  "string"  ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.BOOLEAN,  "bool",    "bool"    ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.BYTE,     "byte",    "byte"    ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.SHORT,    "int16",   "int16"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.INTEGER,  "int32",   "int32"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.LONG,     "int64",   "int64"   ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.FLOAT,    "float32", "float32" ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DOUBLE,   "float64", "float64" ) );
		declarePrimitiveType( buildPrimitiveType(NeutralType.DECIMAL,  "float64", "float64" ) );
		// DATE => No primitive type
		// TIME => No primitive type
		// TIMESTAMP => No primitive type
		declarePrimitiveType( buildPrimitiveType(NeutralType.BINARY, "[]byte", "[]byte" )  ); // No Wrapper type for binary / byte[] ?
		
		//--- Unsigned primitive types : 
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.BYTE,    "uint8",   "uint8"  ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.SHORT,   "uint16",  "uint16" ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.INTEGER, "uint32",  "uint32" ) );
		declarePrimitiveUnsignedType( buildPrimitiveType(NeutralType.LONG,    "uint64",  "uint64" ) );

		//--- Object types : for GO "object types" are used for "structures" define in a "package" ( when "import" is required )
		declareObjectType( buildObjectType(NeutralType.DATE,      "time.Time",  "time.Time" ) );
		declareObjectType( buildObjectType(NeutralType.TIME,      "time.Time",  "time.Time" ) );
		declareObjectType( buildObjectType(NeutralType.TIMESTAMP, "time.Time",  "time.Time" ) );
	}

	private LanguageType buildPrimitiveType(String neutralType, String primitiveType, String wrapperType) {
		return new LanguageType(neutralType, primitiveType,  primitiveType, true, wrapperType );
	}

	private LanguageType buildObjectType(String neutralType, String simpleType, String fullType) {
		return new LanguageType(neutralType, simpleType,  fullType, false, simpleType );
	}
	
	
//	@Override
//	public LanguageType getType(AttributeTypeInfo attributeTypeInfo) {
//		
//		log("type info : " + attributeTypeInfo );
//		
//		log("STEP 1" );
//		//--- 1) Process explicit requirements first (if any)
//		// A primitive type is explicitly required ( @PrimitiveType or @UnsignedType )
//		if ( attributeTypeInfo.isPrimitiveTypeExpected() || attributeTypeInfo.isUnsignedTypeExpected() ) {
//			LanguageType lt = getPrimitiveType(attributeTypeInfo.getNeutralType(), attributeTypeInfo.isUnsignedTypeExpected() ) ;
//			if ( lt != null ) {
//				// FOUND
//				log("1) primitive type found" );
//				return lt ;
//			}
//		}
//		log("1) primitive type not found" );
//		
//		// An object type is explicitly required ( @ObjectType or @SqlType )
//		if ( attributeTypeInfo.isObjectTypeExpected() || attributeTypeInfo.isSqlTypeExpected() ) {
//			LanguageType lt = getObjectType(attributeTypeInfo.getNeutralType(), attributeTypeInfo.isSqlTypeExpected() ) ;
//			if ( lt != null ) {
//				// FOUND
//				log("1) object type found" );
//				return lt ;
//			}
//		}
//		log("1) object type not found" );
//
//		log("STEP 2 " );
//		//--- 2) Process standard type conversion
//		if ( attributeTypeInfo.isNotNull() ) {
//			log("2) Not Null : TRUE" );
//			// Try to found a primitive type first
//			LanguageType lt = getPrimitiveType(attributeTypeInfo.getNeutralType(), false ) ;
//			if ( lt != null ) {
//				// FOUND
//				return lt ;
//			}
//			// Still not found : try to found an object type
//			return getObjectType(attributeTypeInfo.getNeutralType(), false ) ;
//		}
//		else {
//			log("2) Not Null : FALSE" );
////			// Try to found an object type first
////			LanguageType lt = getObjectType(attributeTypeInfo.getNeutralType(), false ) ;
////			if ( lt != null ) {
////				// FOUND
////				return lt ;
////			}
//			// Still not found : try to found a primitive type
//			return getPrimitiveType(attributeTypeInfo.getNeutralType(), false ) ;
//		}
//	}

	@Override
	public LanguageType getType(AttributeTypeInfo attributeTypeInfo) {
		
		String neutralType = attributeTypeInfo.getNeutralType() ;
		// Search a "primitive type" first 
		LanguageType lt = getPrimitiveType(neutralType, attributeTypeInfo.isUnsignedTypeExpected() ) ;
		if ( lt != null ) {
			// FOUND
			log("1) primitive type found" );
			return lt ;
		}
		// if "primitive type" not found search an "object type" 
		return getObjectType( neutralType ) ;
	}
	
}
