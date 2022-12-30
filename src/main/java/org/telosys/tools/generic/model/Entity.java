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

import java.util.List;

/**
 * This interface describe an abstract 'entity' that must be implemented 
 * by each entity in a concrete model 
 * 
 * @author Laurent Guerin
 * @since 2.0.0  (changes in v 3.4.0)
 */
public interface Entity 
{
	/**
	 * Returns the entity class name without the package ( ie : "MyClass" ) <br>
	 * This information is MANDATORY, it must be provided by all models implementations <br>
	 * It must be unique in the model <br>
	 * It cannot be null or void
	 * @return
	 */
	public String getClassName() ;
	
	/**
	 * Returns all the attributes defined for this entity <br>
	 * This information is MANDATORY, it must be provided by all models implementations <br>
	 * It cannot be null, if no attribute the implementation is supposed to return a void list
	 * @return
	 */
	public List<Attribute> getAttributes() ;
	
	public Attribute getAttributeByName(String name); // v 3.4.0 (for standardization in all models)

	/**
	 * Returns the database catalog of the table mapped with this entity<br> 
	 * Void string if not defined
	 * @return
	 */
	public String getDatabaseCatalog() ; 
	
	/**
	 * Returns the database comment for the table mapped with this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getDatabaseComment() ;
	
	/**
	 * Returns all the foreign keys defined for this entity<br> 
	 * @return
	 */
	public List<ForeignKey> getForeignKeys() ; // v 3.4.0


	/**
	 * Returns the database schema of the table mapped with this entity<br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getDatabaseSchema() ;
	
	/**
	 * Returns the database table mapped with this entity <br> 
	 * If not supported by the model implementation : 'null'  <br> 
	 * If provided, it must be unique in the model <br>
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
	 * Returns the entity class full name ( ie : "my.package.MyClass" for a Java Class )
	 * @return
	 */
	public String getFullName();

	/**
	 * Returns a list of all the links defined for the current entity<br>
	 * This information is MANDATORY, it must be provided by all models implementations<br>
	 * It cannot be null, if no link the implementation is supposed to return a void list
	 * @return
	 */
	public List<Link> getLinks() ;

	/**
	 * Returns the entity class package or void ( ie : "my.package" or "" ) <br> 
	 * If not supported by the model implementation : 'null'
	 * @return
	 */
	public String getPackageName() ;

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

	/**
	 * Returns a list of warnings about the current entity <br>
	 * e.g. "No primary key" for an entity based on a table in a database model <br>
	 * @return a list of warnings or null if none
	 */
	public List<String> getWarnings() ;

	/**
	 * Returns all the tags defined at entity level
	 * @return
	 * @since v 3.4.0
	 */
	public TagContainer getTagContainer(); // v 3.4.0
	
	public String getSuperClass() ; // v 3.4.0
	public boolean isAbstract() ; // v 3.4.0
	public boolean isInMemoryRepository() ; // v 3.4.0
	public boolean isReadOnly() ; // v 3.4.0
	public boolean isAggregateRoot() ; // v 3.4.0
	public String getDomain(); // v 3.4.0
	public String getContext(); // v 3.4.0
	public boolean isDatabaseView(); // v 3.4.0
	public String getDatabaseTablespace(); // v 3.4.0

	public boolean isJoinEntity() ; // v 4.1.0
}
