/**
 *  Copyright (C) 2008-2014  Telosys project org. ( http://www.telosys.org/ )
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

import java.util.List;

/**
 * This interface describe an abstract 'entity' that must be implemented 
 * by each entity in a concrete model 
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 */
public interface Entity 
{
	/**
	 * Returns all the attributes defined for this entity <br>
	 * This information is MENDATORY, it must be provided by all models implementations <br>
	 * It cannot be null, if no attribute the implementation is supposed to return a void list
	 * @return
	 */
	public List<Attribute> getAttributes() ;

	/**
	 * Returns the database catalog of the table mapped with this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getDatabaseCatalog() ; 
	
	/**
	 * Returns all the database foreign keys defined for this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public List<ForeignKey> getDatabaseForeignKeys() ;

	/**
	 * Returns the database schema of the table mapped with this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getDatabaseSchema() ;
	
	/**
	 * Returns the database table mapped with this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getDatabaseTable(); 
	
	/**
	 * Returns the database type of the table mapped with this entity <br>
	 * @return the type returned by the database meta-data ( 'TABLE', 'VIEW', ... )<br> 
	 * If not supported by the model implementation : 'null'
	 */
	public String getDatabaseType() ;

	/**
	 * Returns the Java class full name ( ie : "my.package.MyClass" )
	 * @return
	 */
	public String getFullName(); // TODO useful ????

	/**
	 * Returns a list of all the links defined for the current entity<br>
	 * This information is MENDATORY, it must be provided by all models implementations<br>
	 * It cannot be null, if no link the implementation is supposed to return a void list
	 * @return
	 */
	public List<Link> getLinks() ;

	/**
	 * Returns the Java class name without the package ( ie : "MyClass" ) <br>
	 * This information is MENDATORY, it must be provided by all models implementations<br>
	 * It cannot be null or void
	 * @return
	 */
	public String getName() ;
	
	/**
	 * Returns the Java class package or void ( ie : "my.package" or "" ) <br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getPackage() ;

	/**
	 * Returns TRUE if the database type of the entity is 'TABLE' <br>
	 * (it can be a TABLE or a VIEW, see also 'isViewType')<br>
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public Boolean isTableType() ;
	
	/**
	 * Returns TRUE if the database type of the entity is 'VIEW' <br>
	 * (it can be a TABLE or a VIEW, see also 'isTableType')<br>
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public Boolean isViewType() ;

}
