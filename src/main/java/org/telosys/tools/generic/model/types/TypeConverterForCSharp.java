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
 * Type converter for "C#" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForCSharp extends TypeConverter {

	public TypeConverterForCSharp() {
		super();
		
		//--- Object types 
		declareObjectType(NeutralType.STRING,    buildObjectType("String",  "System.String"  ) );
		declareObjectType(NeutralType.BOOLEAN,   buildObjectType("Boolean", "System.Boolean" ) );
		declareObjectType(NeutralType.BYTE,      buildObjectType("SByte",   "System.SByte"   ) );
		declareObjectType(NeutralType.SHORT,     buildObjectType("Int16",   "System.Int16"   ) );
		declareObjectType(NeutralType.INTEGER,   buildObjectType("Int32",   "System.Int32"   ) );
		declareObjectType(NeutralType.LONG,      buildObjectType("Int64",   "System.Int64"   ) );
		declareObjectType(NeutralType.FLOAT,     buildObjectType("Single",  "System.Single"  ) );
		declareObjectType(NeutralType.DOUBLE,    buildObjectType("Double",  "System.Double"  ) );
		declareObjectType(NeutralType.DECIMAL,   buildObjectType("Decimal", "System.Decimal" ) );
		declareObjectType(NeutralType.DATE,      buildObjectType("DateTime", "System.DateTime" ) );
		declareObjectType(NeutralType.TIME,      buildObjectType("DateTime", "System.DateTime" ) );
		declareObjectType(NeutralType.TIMESTAMP, buildObjectType("DateTime", "System.DateTime" ) );
//		declareObjectType(NeutralType.BINARY,    buildJavaType(java.nio.ByteBuffer.class) );

		//--- Object SQL types :
		// No specific SQL types for C#
//		declareObjectSqlType(NeutralType.DATE,  xxxx );
		
		//--- Primitive types :
		declarePrimitiveType(NeutralType.STRING,   buildPrimitiveType("string",  "String"  ) );
		declarePrimitiveType(NeutralType.BOOLEAN,  buildPrimitiveType("boolean", "Boolean" ) );
		declarePrimitiveType(NeutralType.BYTE,     buildPrimitiveType("sbyte",   "System.SByte"   ) );
		declarePrimitiveType(NeutralType.SHORT,    buildPrimitiveType("short",   "System.Int16"   ) );
		declarePrimitiveType(NeutralType.INTEGER,  buildPrimitiveType("int",     "System.Int32"   ) );
		declarePrimitiveType(NeutralType.LONG,     buildPrimitiveType("long",    "System.Int64"   ) );
		declarePrimitiveType(NeutralType.FLOAT,    buildPrimitiveType("float",   "System.Single"  ) );
		declarePrimitiveType(NeutralType.DOUBLE,   buildPrimitiveType("double",  "System.Double"  ) );
		declarePrimitiveType(NeutralType.DECIMAL,  buildPrimitiveType("decimal", "System.Decimal" ) );
		// DATE => No primitive type
		// TIME => No primitive type
		// TIMESTAMP => No primitive type
		declarePrimitiveType(NeutralType.BINARY,   buildPrimitiveType("byte[]", "byte[]" )  ); // No Wrapper type for binary / byte[] ?
		
		//--- Unsigned primitive types : 
		declarePrimitiveUnsignedType(NeutralType.BYTE,    buildPrimitiveType("byte",   "System.Byte"   ) );
		declarePrimitiveUnsignedType(NeutralType.SHORT,   buildPrimitiveType("ushort", "System.UInt16" ) );
		declarePrimitiveUnsignedType(NeutralType.INTEGER, buildPrimitiveType("uint",   "System.UInt32" ) );
		declarePrimitiveUnsignedType(NeutralType.LONG,    buildPrimitiveType("ulong",  "System.UInt64" ) );
	}

	private LanguageType buildPrimitiveType(String primitiveType, String wrapperType) {
		return new LanguageType(primitiveType,  primitiveType, true, wrapperType );
	}

	private LanguageType buildObjectType(String simpleType, String fullType) {
		return new LanguageType(simpleType,  fullType, false, simpleType );
	}

}
