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
 * Type converter for "JAVA" language
 * 
 * @author Laurent Guerin
 *
 */
public class TypeConverterForJava extends TypeConverter {

	public TypeConverterForJava() {
		super();
		
		//--- Object types 
		declareObjectType( buildJavaType(NeutralType.STRING,    java.lang.String.class) );
		declareObjectType( buildJavaType(NeutralType.BOOLEAN,   java.lang.Boolean.class) );
		declareObjectType( buildJavaType(NeutralType.BYTE,      java.lang.Byte.class) );
		declareObjectType( buildJavaType(NeutralType.SHORT,     java.lang.Short.class) );
		declareObjectType( buildJavaType(NeutralType.INTEGER,   java.lang.Integer.class) );
		declareObjectType( buildJavaType(NeutralType.LONG,      java.lang.Long.class) );
		declareObjectType( buildJavaType(NeutralType.FLOAT,     java.lang.Float.class) );
		declareObjectType( buildJavaType(NeutralType.DOUBLE,    java.lang.Double.class) );
		declareObjectType( buildJavaType(NeutralType.DECIMAL,   java.math.BigDecimal.class) );
		declareObjectType( buildJavaType(NeutralType.DATE,      java.util.Date.class) );
		declareObjectType( buildJavaType(NeutralType.TIME,      java.util.Date.class) );
		declareObjectType( buildJavaType(NeutralType.TIMESTAMP, java.util.Date.class) );
//		declareObjectType(NeutralType.LONGTEXT,  buildJavaType(java.lang.String.class) );
//		declareObjectType(NeutralType.BINARY,    buildJavaType(java.nio.ByteBuffer.class) );

		//--- Object SQL types 
		declareObjectSqlType( buildJavaType(NeutralType.DATE,      java.sql.Date.class) );
		declareObjectSqlType( buildJavaType(NeutralType.TIME,      java.sql.Time.class) );
		declareObjectSqlType( buildJavaType(NeutralType.TIMESTAMP, java.sql.Timestamp.class) );
//		declareObjectSqlType(NeutralType.LONGTEXT,  buildJavaType(java.sql.Clob.class) );
		declareObjectSqlType( buildJavaType(NeutralType.BINARY,    java.sql.Blob.class) );
		
		//--- Primitive types 
		// STRING => No primitive type
		declarePrimitiveType( buildJavaType(NeutralType.BOOLEAN, boolean.class) );
		declarePrimitiveType( buildJavaType(NeutralType.BYTE,    byte.class) );
		declarePrimitiveType( buildJavaType(NeutralType.SHORT,   short.class) );
		declarePrimitiveType( buildJavaType(NeutralType.INTEGER, int.class) );
		declarePrimitiveType( buildJavaType(NeutralType.LONG,    long.class) );
		declarePrimitiveType( buildJavaType(NeutralType.FLOAT,   float.class) );
		declarePrimitiveType( buildJavaType(NeutralType.DOUBLE,  double.class) );
		// DECIMAL => No primitive type
		// DATE => No primitive type
		// TIME => No primitive type
		// TIMESTAMP => No primitive type
		// LONGTEXT => No primitive type
		declarePrimitiveType( buildJavaType(NeutralType.BINARY,  byte[].class) );
		
		//--- Unsigned primitive types : No unsigned primitive types in Java
	}

	private LanguageType buildJavaType(String neutralType, Class<?> clazz) {
		if ( clazz.isPrimitive() ) {
			// Primitive type
			return new LanguageType( neutralType, clazz.getSimpleName(), clazz.getSimpleName(), true, getWrapperType(clazz.getSimpleName()) );
		}
		else {
			// Object type => the wrapper type is the same 
			return new LanguageType( neutralType, clazz.getSimpleName(), clazz.getCanonicalName(), false, clazz.getSimpleName() );
		}
	}
	
	/**
	 * Returns the Java wrapper type for the given primitive type
	 * @param primitiveType
	 * @return
	 */
	private String getWrapperType(String primitiveType) {
		
		if ( boolean.class.getSimpleName().equals(primitiveType) ) {
			return Boolean.class.getSimpleName() ;
		}
		else if ( char.class.getSimpleName().equals(primitiveType) ) {
			return Character.class.getSimpleName() ;
		}
		else if ( byte.class.getSimpleName().equals(primitiveType) ) {
			return Byte.class.getSimpleName() ;
		}
		else if ( short.class.getSimpleName().equals(primitiveType) ) {
			return Short.class.getSimpleName() ;
		}
		else if ( int.class.getSimpleName().equals(primitiveType) ) {
			return Integer.class.getSimpleName() ;
		}
		else if ( long.class.getSimpleName().equals(primitiveType) ) {
			return Long.class.getSimpleName() ;
		}
		else if ( float.class.getSimpleName().equals(primitiveType) ) {
			return Float.class.getSimpleName() ;
		}
		else if ( double.class.getSimpleName().equals(primitiveType) ) {
			return Double.class.getSimpleName() ;
		}
		else {
			return primitiveType ; // Never happens
		}
	}
}
