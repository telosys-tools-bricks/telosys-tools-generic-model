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
 * Definition of a foreign key part based on the current entity field
 * 
 * @author Laurent Guerin
 *
 */
public interface ForeignKeyPart {
	
	/**
	 * Returns the name of the Foreign Key the field is part of
	 * @return
	 */
	public String getFkName() ;

	/**
	 * Returns the name of the referenced entity
	 * @return
	 */
	public String getReferencedEntity() ;
	
	/**
	 * Returns the name of the referenced attribute
	 * @return
	 */
	public String getReferencedAttribute() ;
	
	/**
	 * Returns the name of the referenced table
	 * @return
	 */
	public String getReferencedTable() ;
	
	/**
	 * Returns the name of the referenced column
	 * @return
	 */
	public String getReferencedColumn() ;
	
}
