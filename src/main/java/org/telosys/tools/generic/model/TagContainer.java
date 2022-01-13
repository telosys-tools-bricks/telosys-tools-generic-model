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
 * Tag container interface 
 * 
 * @author Laurent Guerin
 *
 */
public interface TagContainer {

	/**
	 * Returns the number of tags in this container
	 * @return
	 */
	public int size();

	/**
	 * Returns true if this container contains no tag.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Returns TRUE if the tag exists
	 * @param tagName
	 * @return
	 */
	public boolean containsTag(String tagName);
	
	/**
	 * Returns the value of the given tag name <br>
	 * If the tag is undefined or has no value, the returned value is an empty string.
	 * 
	 * @param tagName
	 * @return
	 */
	public String getTagValue(String tagName);

	/**
	 * Returns the value of the given tag name <br>
	 * If the tag is undefined or has no value, the given default value is returned.
	 * @param tagName
	 * @param defaultValue
	 * @return
	 */
	public String getTagValue(String tagName, String defaultValue);

	/**
	 * @param tagName
	 * @param defaultValue
	 * @return
	 */
	public int getTagValueAsInt(String tagName, int defaultValue);

	/**
	 * @param tagName
	 * @param defaultValue
	 * @return
	 */
	public boolean getTagValueAsBoolean(String tagName, boolean defaultValue);

}
