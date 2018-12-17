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

import java.util.LinkedList;
import java.util.List;

/**
 * Type converter for "PHP" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForPHP extends TypeConverter {

	public TypeConverterForPHP() {
		super("PHP");
		// No type for PHP => all types are "" (void string")
		//--- Pseudo types :
		declarePrimitiveType( buildType(NeutralType.STRING ) );
		declarePrimitiveType( buildType(NeutralType.BOOLEAN ) );
		declarePrimitiveType( buildType(NeutralType.BYTE ) );
		declarePrimitiveType( buildType(NeutralType.SHORT) );
		declarePrimitiveType( buildType(NeutralType.INTEGER) );
		declarePrimitiveType( buildType(NeutralType.LONG ) );
		declarePrimitiveType( buildType(NeutralType.FLOAT ) );
		declarePrimitiveType( buildType(NeutralType.DOUBLE ) );
		declarePrimitiveType( buildType(NeutralType.DECIMAL ) );
		declarePrimitiveType( buildType(NeutralType.DATE ) );
		declarePrimitiveType( buildType(NeutralType.TIME ) );
		declarePrimitiveType( buildType(NeutralType.TIMESTAMP ) );
		declarePrimitiveType( buildType(NeutralType.BINARY ) ); 		
	}
	private LanguageType buildType(String neutralType) {
		return new LanguageType(neutralType, 
				"",   // String simpleType, 
				"",   // String fullType, 
				true, // boolean isPrimitiveType, 
				"" ); // String wrapperType
	}

	@Override
	public List<String> getComments() {
		List<String> l = new LinkedList<>();
		l.add("PHP is dynamically typed, there are no types in the source code.");
		l.add("Hence the type conversion always return a void string.");
		return l ;
	}

	@Override
	public LanguageType getType(AttributeTypeInfo attributeTypeInfo) {
		log("type info : " + attributeTypeInfo );		
		return getPrimitiveType( attributeTypeInfo.getNeutralType() );
	}
}
