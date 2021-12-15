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
package org.telosys.tools.generic.model.enums;

/**
 * Enumeration of all the model types usable by the generator 
 * 
 * @author Laurent Guerin
 * @since 3.0.0
 *
 */
public enum ModelType {
	
	/**
	 * Model created from a SQL Database Schema (Telosys Tools Database Repository)
	 */
	DATABASE_SCHEMA,
	
	/**
	 * Model created by using the "Telosys Tools DSL"
	 */
	DOMAIN_SPECIFIC_LANGUAGE,
	
	/**
	 * Model created by Java classes introspection 
	 */
	JAVA_CLASSES,
	
	/**
	 * Other type (specific model provided by an other tool)
	 */
	OTHER
}
