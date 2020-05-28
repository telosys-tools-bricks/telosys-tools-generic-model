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

import java.util.*;

/**
 * This interface describe an abstract model that must be implemented 
 * by each concrete model 
 *
 * @author Laurent Guerin
 * @since 3.0.0
 */
public interface Model {

    /**
     * Returns the model's name <br>
	 * This information is MENDATORY, it must be provided by all models implementations <br> 
	 * It cannot be null or void
	 * 
     * @return
     */
    public String getName() ;

    /**
     * Returns the model's type  <br>
	 * This information is MENDATORY, it must be provided by all models implementations <br>
	 * 
     * @return
     */
    public ModelType getType() ;

    /**
     * Returns the model's version <br>
	 * This information is MENDATORY, it must be provided by all models implementations <br>
	 * It cannot be null or void
	 * 
     * @return
     */
    public String getVersion() ;

    /**
     * Returns the model's description <br> 
	 * If not supported by the model implementation : 'null'
     *
     * @return the description or null if none
     */
    public String getDescription() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the ID of the database used to generate the model (if any)
	 * If not supported by the model implementation : 'null'
	 * 
	 * @return
	 */
    public Integer getDatabaseId() ;

	//-------------------------------------------------------------------------------------
	/**
	 * Returns the product name of the database used to generate the model if any <br>
	 * (the product name returned by the JDBC meta-data, e.g. 'Apache Derby')<br>
	 * If not supported by the model implementation : 'null'
	 * 
	 * @return
	 */
    public String getDatabaseProductName() ;
    
    /**
     * Returns the instance of the entity having the given class name <br>
     * (or null if no entity found)
     * @param entityClassName
     * @return
     */
    public Entity getEntityByClassName(String entityClassName) ;
    
    /**
     * Returns the instance of the entity having the given table name <br>
     * (or null if no entity found)<br>
     * Supported only by a model based on a database schema <br>
     * (if not supported always return 'null')
     * @param entityTableName
     * @return
     */
    public Entity getEntityByTableName(String entityTableName) ;
    
    /**
     * Returns all the entities defined in the model <br>
	 * This information is MENDATORY, it must be provided by all models implementations <br>
     * 
     * @return
     */
    public List<Entity> getEntities() ;

}
