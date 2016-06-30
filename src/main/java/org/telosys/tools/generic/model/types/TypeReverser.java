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

import java.util.HashMap;

import org.telosys.tools.generic.model.DateType;

/**
 * Utility class usable to revert the type <br>
 * Converts a Java type (as used in the original ".dbrep" model) to a "neutral type" (as used in the new generic model)  <br>
 * 
 * @author Laurent Guerin
 *
 */
public class TypeReverser {

	private final HashMap<String,String> types = new HashMap<String,String>();

	public TypeReverser() {
		super();
		
		//--- Java primitive types
		types.put(boolean.class.getSimpleName(), NeutralType.BOOLEAN ) ;
		types.put(byte.class.getSimpleName(),    NeutralType.BYTE ) ;
		types.put(short.class.getSimpleName(),   NeutralType.SHORT ) ;
		types.put(int.class.getSimpleName(),     NeutralType.INTEGER ) ;
		types.put(long.class.getSimpleName(),    NeutralType.LONG ) ;
		types.put(float.class.getSimpleName(),   NeutralType.FLOAT ) ;
		types.put(double.class.getSimpleName(),  NeutralType.DOUBLE ) ;
		types.put(byte[].class.getSimpleName(),  NeutralType.BINARY ) ;
		
		
		//--- Java object - standard types
		types.put(java.lang.String.class.getCanonicalName(),     NeutralType.STRING ) ;

		types.put(java.lang.Boolean.class.getCanonicalName(),    NeutralType.BOOLEAN ) ;

		types.put(java.lang.Byte.class.getCanonicalName(),       NeutralType.BYTE ) ;
		types.put(java.lang.Short.class.getCanonicalName(),      NeutralType.SHORT ) ;
		types.put(java.lang.Integer.class.getCanonicalName(),    NeutralType.INTEGER ) ;
		types.put(java.lang.Long.class.getCanonicalName(),       NeutralType.LONG ) ;

		types.put(java.lang.Float.class.getCanonicalName(),      NeutralType.FLOAT ) ;
		types.put(java.lang.Double.class.getCanonicalName(),     NeutralType.DOUBLE ) ;
		types.put(java.math.BigDecimal.class.getCanonicalName(), NeutralType.DECIMAL ) ;
		
		types.put(java.nio.ByteBuffer.class.getCanonicalName(),  NeutralType.BINARY ) ;

		//--- Java object - SQL Types
		types.put(java.sql.Date.class.getCanonicalName(),      NeutralType.DATE ) ;
		types.put(java.sql.Time.class.getCanonicalName(),      NeutralType.TIME ) ;
		types.put(java.sql.Timestamp.class.getCanonicalName(), NeutralType.TIMESTAMP ) ;
		types.put(java.sql.Clob.class.getCanonicalName(),      NeutralType.LONGTEXT ) ;
		types.put(java.sql.Blob.class.getCanonicalName(),      NeutralType.BINARY ) ;
		
	}


	public String getNeutralType(String javaType, DateType dateType) {
		String neutralType= types.get(javaType) ;
		if ( neutralType != null ) {
			// Found
			return neutralType ; 
		}
		else {
			// Ambiguous types : java.util.Date
			if ( java.util.Date.class.getCanonicalName().equals(javaType) ) {
				switch ( dateType ) {
				case DATE_ONLY :
					return NeutralType.DATE ;
				case TIME_ONLY :
					return NeutralType.TIME ;
				case DATE_AND_TIME :
					return NeutralType.TIMESTAMP ;
				default :
					return NeutralType.DATE ;
				}
			}
			else {
				throw new IllegalStateException("Unexpected java type '" + javaType + "'");
			}
		}
	}
}
