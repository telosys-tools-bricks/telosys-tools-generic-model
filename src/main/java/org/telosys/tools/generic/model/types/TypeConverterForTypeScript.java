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
//		declareObjectType(NeutralType.STRING,    buildObjectType("String",  "System.String"  ) );

		//--- Object SQL types :
		// No specific SQL types for C#
//		declareObjectSqlType(NeutralType.DATE,  xxxx );
		
		//--- Primitive types :
		declarePrimitiveType(NeutralType.STRING,    buildPrimitiveType("string",  "string"  ) );
		
		declarePrimitiveType(NeutralType.BOOLEAN,   buildPrimitiveType("boolean", "boolean" ) );
		
		declarePrimitiveType(NeutralType.BYTE,      buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.SHORT,     buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.INTEGER,   buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.LONG,      buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.FLOAT,     buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.DOUBLE,    buildPrimitiveType("number",  "number"  ) );
		declarePrimitiveType(NeutralType.DECIMAL,   buildPrimitiveType("number",  "number"  ) );
		
		declarePrimitiveType(NeutralType.DATE,      buildPrimitiveType("any",     "any"     ) );
		declarePrimitiveType(NeutralType.TIME,      buildPrimitiveType("any",     "any"     ) );
		declarePrimitiveType(NeutralType.TIMESTAMP, buildPrimitiveType("any",     "any"     ) );
		declarePrimitiveType(NeutralType.BINARY,    buildPrimitiveType("any",     "any"     ) );
		
		//--- Unsigned primitive types : 
		// No unsigned types
//		declarePrimitiveUnsignedType(NeutralType.SHORT,   buildPrimitiveType("ushort", "System.UInt16" ) );
		
	}

	private LanguageType buildPrimitiveType(String primitiveType, String wrapperType) {
		return new LanguageType(primitiveType,  primitiveType, true, wrapperType );
	}

//	private LanguageType buildObjectType(String simpleType, String fullType) {
//		return new LanguageType(simpleType,  fullType, false, simpleType );
//	}

}
