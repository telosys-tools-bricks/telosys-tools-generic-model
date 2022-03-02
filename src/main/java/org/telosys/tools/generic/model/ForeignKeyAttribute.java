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
package org.telosys.tools.generic.model;

/**
 * Definition of a database column that is part of a foreign key
 * 
 * @author Laurent Guerin
 * @since 3.4.0  (replaces ForeignKeyColumn)
 * 
 */
public interface ForeignKeyAttribute {
	
	/**
	 * Returns the ordinal (position of the attribute in FK)
	 * @return
	 */
	public int getOrdinal() ; // v 3.4.0
	
	/**
	 * The name of the attribute at the origin of the reference
	 * @return
	 */
	public String getOriginAttributeName() ;  // v 3.4.0

	/**
	 * The name of the referenced attribute
	 * @return
	 */
	public String getReferencedAttributeName() ;  // v 3.4.0

//	/**
//	 * Returns the name of the column
//	 * @return
//	 */
//	public String getColumnName() ;
//
//	/**
//	 * Returns the sequence of the column (the position in the foreign key : 1rst, 2nd, etc)
//	 * @return
//	 */
//	public int getSequence() ;
//
//	/**
//	 * Returns the name of the referenced column
//	 * @return
//	 */
//	public String getReferencedColumnName() ;
	
}
