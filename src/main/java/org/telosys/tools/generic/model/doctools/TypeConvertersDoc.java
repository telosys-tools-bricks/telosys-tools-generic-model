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
package org.telosys.tools.generic.model.doctools;

import java.io.BufferedWriter;
import java.util.LinkedList;
import java.util.List;

import org.telosys.tools.generic.model.types.AttributeTypeInfo;
import org.telosys.tools.generic.model.types.LanguageType;
import org.telosys.tools.generic.model.types.NeutralType;
import org.telosys.tools.generic.model.types.TypeConverter;

public class TypeConvertersDoc extends DocPrinter {

	private final TypeConverter  typeConverter ;
	
	public TypeConvertersDoc(TypeConverter typeConverter, BufferedWriter writer ) {
		super(writer);
		this.typeConverter = typeConverter ;
	}
	
	public void printDoc() {
		String title = "Type conversion for " + typeConverter.getLanguageName() ;
		printHtmlHeader(title);
		printTable();
		printRemarks();
		printHtmlFooter();
	}
	
	private void printTable() {
		print("<table style=\"\"> ");
		println();
		println("<colgroup>");
		print(" <col style=\"width: 16%; background-color: GhostWhite ; \">" );
		for ( int n=0 ; n < 6 ; n++ ) { // 6 columns x 14% = 84%
			print(" <col style=\"width: 14%;\">" );
		}
		println();
		println("</colgroup>");

		println("<thead>");
		print(" <tr>");
		print(" <th> Model type </th>" ); 
		print(" <th> Default </th> " );
		print(" <th> @UnsignedType </th>" ); 
		print(" <th> @NotNull </th>" ); 
		print(" <th> @PrimitiveType </th>" ); 
		print(" <th> @ObjectType </th>" );  
		print(" <th> @SqlType </th>" );  
		println("</tr>");
	    println("</thead>");

		println("<tbody>");
		for ( String neutralType : NeutralType.getAllNeutralTypes() ) {
			List<String> types = getSimpleTypes(neutralType); 
			printRow(neutralType, types);
		}		
		println("</tbody>");
		println("</table>");
	}
	
	private List<String> getSimpleTypes(String neutralType) {
		List<String> list = new LinkedList<>();
		
		list.add( getSimpleType(neutralType, AttributeTypeInfo.NONE) ); // "default"
		list.add( getSimpleType(neutralType, AttributeTypeInfo.UNSIGNED_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.NOT_NULL) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.PRIMITIVE_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.OBJECT_TYPE) );
		list.add( getSimpleType(neutralType, AttributeTypeInfo.SQL_TYPE) );
		
		return list;
	}
	
	private String getSimpleType(String neutralType, int info) {
		LanguageType lt = typeConverter.getType(new AttributeTypeInfo(neutralType, info));
		return lt.getSimpleType();
	}	
	
	private void printRow(String neutralType, List<String> types) {
				
		print(" <tr>" );
		print(" <td>" + neutralType + "</td>");
		for ( String type : types ) {
			print(" <td>" + type + "</td>");
		}
		print(" </tr>\n" );
	}

	private void printRemarks() {
		List<String >remarks = typeConverter.getComments() ;
		if ( remarks == null || remarks.isEmpty() ) {
			return ;
		}
		print("<h2>Remarks</h2>" );	
		print("<p>" );	
		for ( String s : typeConverter.getComments() ) {
			print( s + "<br>" );	
		}
		print("</p>" );	
	}
	
}
